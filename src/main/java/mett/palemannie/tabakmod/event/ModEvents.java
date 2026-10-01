package mett.palemannie.tabakmod.event;


import mett.palemannie.tabakmod.TabakMod;
import mett.palemannie.tabakmod.sound.ModSounds;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.neoforged.neoforge.event.ServerChatEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

import java.util.Locale;

@EventBusSubscriber(modid = TabakMod.MODID)
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
