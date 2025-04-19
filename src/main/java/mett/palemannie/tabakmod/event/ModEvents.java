package mett.palemannie.tabakmod.event;


import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import mett.palemannie.tabakmod.TabakMod;
import mett.palemannie.tabakmod.block.ModBlocks;
import mett.palemannie.tabakmod.item.ModItems;
import mett.palemannie.tabakmod.villager.ModVillagers;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Optional;

@Mod.EventBusSubscriber(modid = TabakMod.MODID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event){
//////////////////////////////////////////////////////TABAKHÄNDLER//////////////////////////////////////////////////////
//1111111111111111111111111111111111111111111111111111111111111//NEULING////////////////////////////////////////////////
        if(event.getType() == ModVillagers.TABAKHAENDLER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe = new ItemCost(Items.EMERALD, 1);
            ItemStack ausgabe = new ItemStack(ModItems.ZIGARETTE_SCHEISE.get(), 1);
            int villagerLevel = 1;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe, ausgabe, 10, 1, 0.02f));
        }
        if(event.getType() == ModVillagers.TABAKHAENDLER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe = new ItemCost(Items.EMERALD, 4);
            ItemStack ausgabe = new ItemStack(ModItems.DECKBLATT.get(), 10);
            int villagerLevel = 1;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe, ausgabe, 10, 1, 0.02f));
        }
        if(event.getType() == ModVillagers.TABAKHAENDLER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe = new ItemCost(ModItems.ZIGARETTENSTUMMEL.get(), 8);
            ItemStack ausgabe = new ItemStack(Items.EMERALD, 1);
            int villagerLevel = 1;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe, ausgabe, 10, 1, 0.02f));
        }
        if(event.getType() == ModVillagers.TABAKHAENDLER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe = new ItemCost(ModItems.ZIGARRENSTUMMEL.get(), 4);
            ItemStack ausgabe = new ItemStack(Items.EMERALD, 1);
            int villagerLevel = 1;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe, ausgabe, 10, 1, 0.02f));
        }
        if(event.getType() == ModVillagers.TABAKHAENDLER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe1 = new ItemCost(ModItems.ZIGARETTENSCHACHTEL_LEER.get(), 1);
            ItemCost eingabe2 = new ItemCost(Items.EMERALD_BLOCK, 2);
            ItemStack ausgabe = new ItemStack(ModItems.ZIGARETTENSCHACHTEL.get(), 1);
            int villagerLevel = 1;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe1, Optional.of(eingabe2), ausgabe, 10, 2, 0.02f));
        }
        if(event.getType() == ModVillagers.TABAKHAENDLER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe1 = new ItemCost(ModItems.ZIGARRENSCHACHTEL_LEER.get(), 1);
            ItemCost eingabe2 = new ItemCost(Items.EMERALD_BLOCK, 5);
            ItemStack ausgabe = new ItemStack(ModItems.ZIGARRENSCHACHTEL.get(), 1);
            int villagerLevel = 1;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe1, Optional.of(eingabe2), ausgabe, 10, 2, 0.02f));
        }
        if(event.getType() == ModVillagers.TABAKHAENDLER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe = new ItemCost(Items.EMERALD, 2);
            ItemStack ausgabe = new ItemStack(ModItems.ZIGARETTENFILTER.get(), 1);
            int villagerLevel = 1;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe, ausgabe, 10, 1, 0.02f));
        }
//2222222222222222222222222222222222222222222222222222222222222//LEHRLING///////////////////////////////////////////////
        if(event.getType() == ModVillagers.TABAKHAENDLER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe1 = new ItemCost(ModItems.ZIGARETTENSTUMMEL.get(), 1);
            ItemCost eingabe2 = new ItemCost(Items.EMERALD, 2);
            ItemStack ausgabe = new ItemStack(ModItems.ZIGARETTE.get(), 1);
            int villagerLevel = 2;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe1, Optional.of(eingabe2), ausgabe, 10, 2, 0.02f));
        }
        if(event.getType() == ModVillagers.TABAKHAENDLER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe1 = new ItemCost(ModItems.ZIGARRENSTUMMEL.get(), 1);
            ItemCost eingabe2 = new ItemCost(Items.EMERALD, 7);
            ItemStack ausgabe = new ItemStack(ModItems.ZIGARRE.get(), 1);
            int villagerLevel = 2;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe1, Optional.of(eingabe2), ausgabe, 5, 3, 0.02f));
        }
        if(event.getType() == ModVillagers.TABAKHAENDLER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe = new ItemCost(Items.EMERALD, 10);
            ItemStack ausgabe = new ItemStack(ModItems.ZIGARETTEN.get(), 1);
            int villagerLevel = 2;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe, ausgabe, 10, 2, 0.02f));
        }
        if(event.getType() == ModVillagers.TABAKHAENDLER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe = new ItemCost(Items.EMERALD, 29);
            ItemStack ausgabe = new ItemStack(ModItems.ZIGARREN.get(), 1);
            int villagerLevel = 2;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe, ausgabe, 10, 1, 0.02f));
        }
        if(event.getType() == ModVillagers.TABAKHAENDLER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe = new ItemCost(ModItems.HELLER_TABAK.get(), 8);
            ItemStack ausgabe = new ItemStack(Items.EMERALD, 2);
            int villagerLevel = 2;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe, ausgabe, 10, 1, 0.02f));
        }
        if(event.getType() == ModVillagers.TABAKHAENDLER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe = new ItemCost(ModItems.MITTLERER_TABAK.get(), 8);
            ItemStack ausgabe = new ItemStack(Items.EMERALD, 3);
            int villagerLevel = 2;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe, ausgabe, 10, 1, 0.02f));
        }
        if(event.getType() == ModVillagers.TABAKHAENDLER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe = new ItemCost(ModItems.DUNKLER_TABAK.get(), 8);
            ItemStack ausgabe = new ItemStack(Items.EMERALD, 4);
            int villagerLevel = 2;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe, ausgabe, 10, 1, 0.02f));
        }

//3333333333333333333333333333333333333333333333333333333333333//GESELLE////////////////////////////////////////////////
        if(event.getType() == ModVillagers.TABAKHAENDLER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe1 = new ItemCost(ModItems.ZIGARETTENSCHACHTEL_MENTHOL_LEER.get(), 1);
            ItemCost eingabe2 = new ItemCost(Items.EMERALD, 50);
            ItemStack ausgabe = new ItemStack(ModBlocks.HELLER_TABAKBALLEN.get(), 1);
            int villagerLevel = 3;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe1, Optional.of(eingabe2), ausgabe, 5, 6, 0.02f));
        }
        if(event.getType() == ModVillagers.TABAKHAENDLER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe = new ItemCost(Items.EMERALD, 12);
            ItemStack ausgabe = new ItemStack(ModBlocks.ASCHENBECHER.get(), 1);
            int villagerLevel = 3;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe, ausgabe, 4, 6, 0.02f));
        }
        if(event.getType() == ModVillagers.TABAKHAENDLER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe1 = new ItemCost(ModBlocks.GETROCKNETER_TABAKBALLEN.get(), 1);
            ItemCost eingabe2 = new ItemCost(Items.EMERALD, 10);
            ItemStack ausgabe = new ItemStack(ModBlocks.HELLER_TABAKBALLEN.get(), 1);
            int villagerLevel = 3;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe1, Optional.of(eingabe2), ausgabe, 5, 6, 0.02f));
        }
        if(event.getType() == ModVillagers.TABAKHAENDLER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe1 = new ItemCost(ModBlocks.GETROCKNETER_TABAKBALLEN.get(), 1);
            ItemCost eingabe2 = new ItemCost(Items.EMERALD, 15);
            ItemStack ausgabe = new ItemStack(ModBlocks.MITTLERER_TABAKBALLEN.get(), 1);
            int villagerLevel = 3;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe1, Optional.of(eingabe2), ausgabe, 5, 6, 0.02f));
        }
        if(event.getType() == ModVillagers.TABAKHAENDLER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe1 = new ItemCost(ModBlocks.GETROCKNETER_TABAKBALLEN.get(), 1);
            ItemCost eingabe2 = new ItemCost(Items.EMERALD, 20);
            ItemStack ausgabe = new ItemStack(ModBlocks.DUNKLER_TABAKBALLEN.get(), 1);
            int villagerLevel = 3;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe1, Optional.of(eingabe2), ausgabe, 5, 6, 0.02f));
        }
        if(event.getType() == ModVillagers.TABAKHAENDLER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe = new ItemCost(Items.EMERALD, 32);
            ItemStack ausgabe = new ItemStack(ModItems.PFEIFE_LEER.get(), 1);
            int villagerLevel = 3;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe, ausgabe, 2, 15, 0.02f));
        }

//4444444444444444444444444444444444444444444444444444444444444//EXPERTE////////////////////////////////////////////////
        if(event.getType() == ModVillagers.TABAKHAENDLER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe = new ItemCost(Items.EMERALD_BLOCK, 10);
            ItemStack ausgabe = new ItemStack(ModItems.ZIGARETTENSCHACHTEL.get(), 1);
            int villagerLevel = 4;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe, ausgabe, 1, 10, 0.02f));
        }
        if(event.getType() == ModVillagers.TABAKHAENDLER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe = new ItemCost(Items.EMERALD_BLOCK, 30);
            ItemStack ausgabe = new ItemStack(ModItems.ZIGARRENSCHACHTEL.get(), 1);
            int villagerLevel = 4;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe, ausgabe, 1, 10, 0.02f));
        }
        if(event.getType() == ModVillagers.TABAKHAENDLER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe = new ItemCost(ModItems.HELLER_TABAK_BEHANDELT.get(), 2);
            ItemStack ausgabe = new ItemStack(Items.EMERALD, 3);
            int villagerLevel = 4;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe, ausgabe, 1, 10, 0.02f));
        }
        if(event.getType() == ModVillagers.TABAKHAENDLER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe = new ItemCost(ModItems.MITTLERER_TABAK_BEHANDELT.get(), 2);
            ItemStack ausgabe = new ItemStack(Items.EMERALD, 5);
            int villagerLevel = 4;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe, ausgabe, 1, 10, 0.02f));
        }
        if(event.getType() == ModVillagers.TABAKHAENDLER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe = new ItemCost(ModItems.DUNKLER_TABAK_BEHANDELT.get(), 2);
            ItemStack ausgabe = new ItemStack(Items.EMERALD, 7);
            int villagerLevel = 4;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe, ausgabe, 1, 10, 0.02f));
        }
        if(event.getType() == ModVillagers.TABAKHAENDLER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe = new ItemCost(Items.EMERALD, 4);
            ItemStack ausgabe = new ItemStack(ModItems.ZIGARETTE_MENTHOL.get(), 1);
            int villagerLevel = 4;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe, ausgabe, 1, 10, 0.02f));
        }
//5555555555555555555555555555555555555555555555555555555555555//MEISTER////////////////////////////////////////////////
        if(event.getType() == ModVillagers.TABAKHAENDLER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe = new ItemCost(Items.EMERALD_BLOCK, 20);
            ItemStack ausgabe = new ItemStack(ModItems.ZIGARETTENSCHACHTEL_GROSS.get(), 1);
            int villagerLevel = 5;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe, ausgabe, 1, 200, 0.02f));
        }
        if(event.getType() == ModVillagers.TABAKHAENDLER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe1 = new ItemCost(ModItems.ZIGARETTENSCHACHTEL_GROSS_LEER.get(), 1);
            ItemCost eingabe2 = new ItemCost(Items.EMERALD_BLOCK, 4);
            ItemStack ausgabe = new ItemStack(ModItems.ZIGARETTENSCHACHTEL_GROSS.get(), 1);
            int villagerLevel = 5;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe1, Optional.of(eingabe2), ausgabe, 10, 20, 0.02f));
        }
        if(event.getType() == ModVillagers.TABAKHAENDLER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe = new ItemCost(Items.EMERALD, 30);
            ItemStack ausgabe = new ItemStack(ModBlocks.ASCHENBECHER_GROSS.get(), 1);
            int villagerLevel = 5;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe, ausgabe, 1, 10, 0.02f));
        }
        if(event.getType() == ModVillagers.TABAKHAENDLER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe = new ItemCost(Items.EMERALD, 64);
            ItemStack ausgabe = new ItemStack(ModItems.ZIGARETTENSCHACHTEL_MENTHOL.get(), 1);
            int villagerLevel = 5;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe, ausgabe, 1, 10, 0.02f));
        }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////BAUER/////////////////////////////////////////////////////////
        if(event.getType() == VillagerProfession.FARMER){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe = new ItemCost(ModBlocks.TABAKBLAETTER_GETROCKNET.get(), 4);
            ItemStack ausgabe = new ItemStack(Items.EMERALD, 4);
            int villagerLevel = 1;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe, ausgabe, 10, 1, 0.02f));
        }
        if(event.getType() == VillagerProfession.FARMER){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe = new ItemCost(Items.EMERALD, 1);
            ItemStack ausgabe = new ItemStack(ModItems.TABAKBLATT.get(), 7);
            int villagerLevel = 1;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe, ausgabe, 10, 1, 0.02f));
        }
        if(event.getType() == VillagerProfession.FARMER){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe = new ItemCost(Items.EMERALD, 4);
            ItemStack ausgabe = new ItemStack(ModItems.TABAKSAMEN.get(), 1);
            int villagerLevel = 2;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe, ausgabe, 10, 2, 0.02f));
        }
        if(event.getType() == VillagerProfession.FARMER){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe = new ItemCost(ModBlocks.TABAKBLAETTER.get(), 4);
            ItemCost eingabe2 = new ItemCost(Items.EMERALD, 4);
            ItemStack ausgabe = new ItemStack(ModBlocks.TABAKBLAETTER_GETROCKNET.get(), 4);
            int villagerLevel = 2;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe, Optional.of(eingabe2), ausgabe, 10, 2, 0.02f));
        }
        if(event.getType() == VillagerProfession.FARMER){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe = new ItemCost(ModItems.TABAKSAMEN.get(), 16);
            ItemStack ausgabe = new ItemStack(Items.EMERALD, 1);
            int villagerLevel = 3;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe, ausgabe, 10, 6, 0.02f));
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if(event.getType() == VillagerProfession.MASON){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe = new ItemCost(Items.EMERALD, 10);
            ItemStack ausgabe = new ItemStack(ModBlocks.ASCHENBECHER.get(), 1);
            int villagerLevel = 3;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe, ausgabe, 2, 10, 0.02f));
        }
        if(event.getType() == VillagerProfession.MASON){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemCost eingabe = new ItemCost(Items.EMERALD, 32);
            ItemStack ausgabe = new ItemStack(ModBlocks.ASCHENBECHER_GROSS.get(), 1);
            int villagerLevel = 5;
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(eingabe, ausgabe, 1, 20, 0.02f));
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
