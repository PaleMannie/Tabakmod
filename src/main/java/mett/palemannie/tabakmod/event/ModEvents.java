package mett.palemannie.tabakmod.event;


import mett.palemannie.tabakmod.TabakMod;
import mett.palemannie.tabakmod.block.ModBlocks;
import mett.palemannie.tabakmod.item.ModItems;
import mett.palemannie.tabakmod.sound.ModSounds;
import mett.palemannie.tabakmod.villager.ModVillagers;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Locale;
import java.util.Optional;

@Mod.EventBusSubscriber(modid = TabakMod.MODID/*, bus = Mod.EventBusSubscriber.Bus.FORGE*/)
public class ModEvents {

    @SubscribeEvent
    public static void onChat(ServerChatEvent event) {
        String chat = event.getMessage().getString().toLowerCase(Locale.ROOT);

        if (chat.contains("slon")) {
            MinecraftServer server = event.getPlayer().level().getServer();

            if (server == null) return;

            for (ServerPlayer player : server.getPlayerList().getPlayers()) {
                player.level().playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.SLON.get(), SoundSource.PLAYERS,
                        (float) RandomSource.create().nextInt(8,12)/10, (float) RandomSource.create().nextInt(8,12)/10);
            }
        }

        if (chat.contains("me when tabakmod")) {
            MinecraftServer server = event.getPlayer().level().getServer();

            if (server == null) return;

            for (ServerPlayer player : server.getPlayerList().getPlayers()) {
                player.level().playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.MWTM.get(), SoundSource.PLAYERS,
                        (float) RandomSource.create().nextInt(80,120)/100, (float) RandomSource.create().nextInt(80,120)/100);
            }
        }
    }
}
