package mett.palemannie.tabakmod.event;


import mett.palemannie.tabakmod.TabakMod;
import mett.palemannie.tabakmod.block.ModBlocks;
import mett.palemannie.tabakmod.item.ModItems;
import mett.palemannie.tabakmod.sound.ModSounds;
import mett.palemannie.tabakmod.villager.ModVillagers;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
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

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event){
//////////////////////////////////////////////////////TABAKHÄNDLER//////////////////////////////////////////////////////

        if(event.getType() == ModVillagers.TABAKHAENDLER.getKey()) {
            var trades = event.getTrades();

            ///NEULING

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(ModItems.ZIGARETTE_SCHEISE.get(), 1), 100, 1, 0.05f));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.KAUTABAKMISCHE.get(), 1),
                    new ItemStack(Items.EMERALD, 1), 4, 2, 0.05f));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 4),
                    new ItemStack(ModItems.DECKBLATT.get(), 6), 10, 1, 0.05f));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.ZIGARETTENSTUMMEL.get(), 6),
                    new ItemStack(Items.EMERALD, 1), 10, 1, 0.05f));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.ZIGARRENSTUMMEL.get(), 6),
                    new ItemStack(Items.EMERALD, 1), 10, 1, 0.05f));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.STUMMEL_KAMEL.get(), 6),
                    new ItemStack(Items.EMERALD, 1), 10, 1, 0.05f));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.STUMMEL_MENTHOL.get(), 6),
                    new ItemStack(Items.EMERALD, 1), 10, 1, 0.05f));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.STUMMEL_SCHEISE.get(), 1),
                    new ItemStack(Items.EMERALD, 1), 10, 1, 0.05f));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.ZIGARETTENSCHACHTEL_LEER.get(), 1),
                    Optional.of(new ItemCost(Items.EMERALD, 25)),
                    new ItemStack(ModItems.ZIGARETTENSCHACHTEL.get(), 1), 1, 2, 0.05f));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.ZIGARRENSCHACHTEL_LEER.get(), 1),
                    Optional.of(new ItemCost(Items.EMERALD, 40)),
                    new ItemStack(ModItems.ZIGARRENSCHACHTEL.get(), 1), 1, 5, 0.05f));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 2),
                    new ItemStack(ModItems.ZIGARETTENFILTER.get(), 1), 10, 1, 0.05f));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.HELLER_TABAK.get(), 8),
                    Optional.of(new ItemCost(Items.EMERALD, 1)),
                    new ItemStack(ModItems.HELLER_TABAK_BEHANDELT.get(), 8), 1, 1, 0.05f));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.MITTLERER_TABAK.get(), 8),
                    Optional.of(new ItemCost(Items.EMERALD, 1)),
                    new ItemStack(ModItems.MITTLERER_TABAK_BEHANDELT.get(), 8), 1, 1, 0.05f));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.DUNKLER_TABAK.get(), 8),
                    Optional.of(new ItemCost(Items.EMERALD, 1)),
                    new ItemStack(ModItems.DUNKLER_TABAK_BEHANDELT.get(), 8), 1, 1, 0.05f));

            ///LEHRLING

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.ZIGARETTENSTUMMEL.get(), 1),
                    Optional.of(new ItemCost(Items.EMERALD, 1)),
                    new ItemStack(ModItems.ZIGARETTE.get(), 1), 10, 2, 0.05f));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.ZIGARRENSTUMMEL.get(), 1),
                    Optional.of(new ItemCost(Items.EMERALD, 13)),
                    new ItemStack(ModItems.ZIGARRE.get(), 1), 6, 2, 0.05f));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.STUMMEL_MENTHOL.get(), 1),
                    Optional.of(new ItemCost(Items.EMERALD, 7)),
                    new ItemStack(ModItems.ZIGARETTE_MENTHOL.get(), 1), 6, 2, 0.05f));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 18),
                    new ItemStack(ModItems.ZIGARETTEN.get(), 1), 10, 2, 0.05f));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 36),
                    new ItemStack(ModItems.ZIGARREN.get(), 1), 10, 2, 0.05f));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.HELLER_TABAK.get(), 8),
                    new ItemStack(Items.EMERALD, 2), 10, 2, 0.05f));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.MITTLERER_TABAK.get(), 8),
                    new ItemStack(Items.EMERALD, 3), 10, 2, 0.05f));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.DUNKLER_TABAK.get(), 8),
                    new ItemStack(Items.EMERALD, 4), 10, 2, 0.05f));

            ///GESELLE

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.ZIGARETTENSCHACHTEL_MENTHOL_LEER.get(), 1),
                    Optional.of(new ItemCost(Items.EMERALD, 40)),
                    new ItemStack(ModItems.ZIGARETTENSCHACHTEL_MENTHOL.get(), 1), 10, 6, 0.05f));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 15),
                    new ItemStack(ModBlocks.ASCHENBECHER.get(), 1), 10, 3, 0.05f));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModBlocks.GETROCKNETER_TABAKBALLEN.get(), 1),
                    Optional.of(new ItemCost(Items.EMERALD, 6)),
                    new ItemStack(ModBlocks.HELLER_TABAKBALLEN.get(), 1), 10, 4, 0.05f));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModBlocks.GETROCKNETER_TABAKBALLEN.get(), 1),
                    Optional.of(new ItemCost(Items.EMERALD, 12)),
                    new ItemStack(ModBlocks.MITTLERER_TABAKBALLEN.get(), 1), 10, 4, 0.05f));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModBlocks.GETROCKNETER_TABAKBALLEN.get(), 1),
                    Optional.of(new ItemCost(Items.EMERALD, 18)),
                    new ItemStack(ModBlocks.DUNKLER_TABAKBALLEN.get(), 1), 10, 4, 0.05f));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 28),
                    new ItemStack(ModItems.PFEIFE_LEER.get(), 1), 2, 12, 0.05f));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.STUMMEL_KAMEL.get(), 1),
                    Optional.of(new ItemCost(Items.EMERALD, 64)),
                    new ItemStack(ModItems.ZIGARETTE_KAMEL.get(), 1), 1, 20, 0.05f));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 16),
                    new ItemStack(ModItems.RAKETENZIGARRE.get(), 1), 4, 12, 0.05f));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 16),
                    new ItemStack(ModItems.SUIZIDZIGARETTE.get(), 1), 1, 12, 0.05f));

            ///EXPERTE

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 64),
                    new ItemStack(ModItems.ZIGARETTENSCHACHTEL.get(), 1), 2, 18, 0.05f));

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 12),
                    new ItemStack(ModItems.KAUTABAK.get(), 1), 5, 10, 0.05f));

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 64),
                    Optional.of(new ItemCost(Items.EMERALD, 64)),
                    new ItemStack(ModItems.ZIGARRENSCHACHTEL.get(), 1), 2, 36, 0.05f));

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.HELLER_TABAK_BEHANDELT.get(), 3),
                    new ItemStack(Items.EMERALD, 2), 10, 5, 0.05f));

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.MITTLERER_TABAK_BEHANDELT.get(), 3),
                    new ItemStack(Items.EMERALD, 3), 10, 5, 0.05f));

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.DUNKLER_TABAK_BEHANDELT.get(), 3),
                    new ItemStack(Items.EMERALD, 4), 10, 5, 0.05f));

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 4),
                    new ItemStack(ModItems.ZIGARETTE_MENTHOL.get(), 1), 10, 5, 0.05f));

            ///MEISTER

            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 64),
                    Optional.of(new ItemCost(Items.EMERALD, 63)),
                    new ItemStack(ModItems.ZIGARETTENSCHACHTEL_GROSS.get(), 1), 1, 30, 0.05f));

            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.KAUTABAK.get(), 1),
                    new ItemStack(Items.EMERALD, 2), 8, 8, 0.05f));

            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.ZIGARETTENSCHACHTEL_GROSS_LEER.get(), 1),
                    Optional.of(new ItemCost(Items.EMERALD, 40)),
                    new ItemStack(ModItems.ZIGARETTENSCHACHTEL_GROSS.get(), 1), 1, 60, 0.05f));

            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 31),
                    new ItemStack(ModBlocks.ASCHENBECHER_GROSS.get(), 1), 2, 30, 0.05f));

            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 63),
                    new ItemStack(ModItems.ZIGARETTENSCHACHTEL_MENTHOL.get(), 1), 2, 60, 0.05f));

            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.KAUTABAKMISCHE.get(), 1),
                    Optional.of(new ItemCost(Items.EMERALD, 1)),
                    new ItemStack(ModItems.KAUTABAK.get(), 1), 10, 10, 0.05f));

        }

//////////////////////////////////////////////////////MAURER////////////////////////////////////////////////////////////

        if(event.getType() == VillagerProfession.MASON) {
            var trades = event.getTrades();

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 10),
                    new ItemStack(ModBlocks.ASCHENBECHER.get(), 1), 6, 4, 0.05f));

            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 30),
                    new ItemStack(ModBlocks.ASCHENBECHER_GROSS.get(), 1), 6, 4, 0.05f));
        }

//////////////////////////////////////////////////////BAUER/////////////////////////////////////////////////////////////

        if(event.getType() == VillagerProfession.FARMER) {
            var trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModBlocks.TABAKBLAETTER_GETROCKNET.get(), 4),
                    new ItemStack(Items.EMERALD, 3), 6, 4, 0.05f));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(ModBlocks.TABAKBLAETTER.get(), 5), 6, 4, 0.05f));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 4),
                    new ItemStack(ModItems.TABAKSAMEN.get(), 1), 1, 12, 0.05f));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModBlocks.TABAKBLAETTER.get(), 4),
                    Optional.of(new ItemCost(Items.EMERALD, 4)),
                    new ItemStack(ModItems.TABAKSAMEN.get(), 1), 1, 12, 0.05f));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.TABAKSAMEN.get(), 4),
                    new ItemStack(Items.EMERALD, 1), 1, 12, 0.05f));

        }

//////////////////////////////////////////////////////FISCHER///////////////////////////////////////////////////////////

        if(event.getType() == VillagerProfession.FISHERMAN) {
            var trades = event.getTrades();

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 10),
                    new ItemStack(ModItems.KAUTABAK.get(), 1), 6, 4, 0.05f));

        }

    }

}
