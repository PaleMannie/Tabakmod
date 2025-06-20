package mett.palemannie.tabakmod.event;

import mett.palemannie.tabakmod.TabakMod;
import mett.palemannie.tabakmod.networking.ModMessages;
import mett.palemannie.tabakmod.networking.packets.SpuckenC2SPacket;
import mett.palemannie.tabakmod.util.KeyBinding;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ClientEvents {

    private static final Map<UUID, Long> cooldownMap = new HashMap<>();
    private static final long COOLDOWN_TIME = 150;

    @Mod.EventBusSubscriber(modid = TabakMod.MODID, value = Dist.CLIENT)
    public static class ClientForgeEvents {

        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event){

            Minecraft minecraft = Minecraft.getInstance();
            if (minecraft.player == null) return;
            LivingEntity player = minecraft.player;

            if(KeyBinding.SPUCKTASTE.consumeClick()) {
                UUID playerId = player.getUUID();
                long currentTime = System.currentTimeMillis();

                if (!cooldownMap.containsKey(playerId) || (currentTime - cooldownMap.get(playerId) >= COOLDOWN_TIME)){
                    ModMessages.sendToServer(new SpuckenC2SPacket());
                    cooldownMap.put(playerId, currentTime);
                }
            }
        }

        @Mod.EventBusSubscriber(modid = TabakMod.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
        public static class ClientModBusEvents {
            @SubscribeEvent
            public static void onKeyRegister(RegisterKeyMappingsEvent event){
            event.register(KeyBinding.SPUCKTASTE);
            }
        }
    }
}
