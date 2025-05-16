package mett.palemannie.tabakmod.item;

import mett.palemannie.tabakmod.TabakMod;
import mett.palemannie.tabakmod.block.ModBlocks;
import mett.palemannie.tabakmod.item.custom.*;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TabakMod.MODID);
////////////////////////////////////////////////TABAKGEWÄCHS////////////////////////////////////////////////////////////////////////
    public static final RegistryObject<Item> TABAKSAMEN = ITEMS.register("tabaksamen",
            () -> new BlockItem(ModBlocks.TABAKPFLANZE.get(),new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "tabaksamen"))).useItemDescriptionPrefix()));
    public static final RegistryObject<Item> TABAKBLATT = ITEMS.register("tabakblatt",
        () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "tabakblatt")))));
    public static final RegistryObject<Item> TROCKENER_TABAK = ITEMS.register("trockener_tabak",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "trockener_tabak")))));
    public static final RegistryObject<Item> HELLER_TABAK = ITEMS.register("heller_tabak",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "heller_tabak")))));
    public static final RegistryObject<Item> MITTLERER_TABAK = ITEMS.register("mittlerer_tabak",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "mittlerer_tabak")))));
    public static final RegistryObject<Item> DUNKLER_TABAK = ITEMS.register("dunkler_tabak",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "dunkler_tabak")))));
    public static final RegistryObject<Item> HELLER_TABAK_BEHANDELT = ITEMS.register("heller_tabak_behandelt",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "heller_tabak_behandelt")))));
    public static final RegistryObject<Item> MITTLERER_TABAK_BEHANDELT = ITEMS.register("mittlerer_tabak_behandelt",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "mittlerer_tabak_behandelt")))));
    public static final RegistryObject<Item> DUNKLER_TABAK_BEHANDELT = ITEMS.register("dunkler_tabak_behandelt",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "dunkler_tabak_behandelt")))));
/////////////////////////////////////////////////TABAKPRODUKTE///////////////////////////////////////////////////////////////////////
    public static final RegistryObject<Item> ZIGARETTE = ITEMS.register("zigarette",
            () -> new ZigarettenItem(new Item.Properties().durability(200).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "zigarette")))));
    public static final RegistryObject<Item> ZIGARETTENSTUMMEL = ITEMS.register("zigarettenstummel",
            () -> new StummelItem(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "zigarettenstummel")))));
    public static final RegistryObject<Item> ZIGARETTENFILTER = ITEMS.register("zigarettenfilter",
            () -> new StummelItem(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "zigarettenfilter")))));
    public static final RegistryObject<Item> ZIGARETTEN = ITEMS.register("zigaretten",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "zigaretten")))));
    public static final RegistryObject<Item> ZIGARETTENSCHACHTEL = ITEMS.register("zigarettenschachtel",
            () -> new ZigSchachtelItem(new Item.Properties().durability(21).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "zigarettenschachtel")))));
    public static final RegistryObject<Item> ZIGARETTENSCHACHTEL_LEER = ITEMS.register("zigarettenschachtel_leer",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "zigarettenschachtel_leer")))));
    public static final RegistryObject<Item> ZIGARETTENSCHACHTEL_GROSS = ITEMS.register("zigarettenschachtel_gross",
            () -> new ZigSchachtelItem(new Item.Properties().durability(31).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "zigarettenschachtel_gross")))));
    public static final RegistryObject<Item> ZIGARETTENSCHACHTEL_GROSS_LEER = ITEMS.register("zigarettenschachtel_gross_leer",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "zigarettenschachtel_gross_leer")))));
    public static final RegistryObject<Item> ZIGARRE = ITEMS.register("zigarre",
            () -> new ZigarrenItem(new Item.Properties().durability(600).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "zigarre")))));
    public static final RegistryObject<Item> ZIGARREN = ITEMS.register("zigarren",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "zigarren")))));
    public static final RegistryObject<Item> ZIGARRENSTUMMEL = ITEMS.register("zigarrenstummel",
            () -> new StummelItem(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "zigarrenstummel")))));
    public static final RegistryObject<Item> ZIGARRENSCHACHTEL = ITEMS.register("zigarrenschachtel",
            () -> new ZigrrSchachtelItem(new Item.Properties().durability(6).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "zigarrenschachtel")))));
    public static final RegistryObject<Item> ZIGARRENSCHACHTEL_LEER = ITEMS.register("zigarrenschachtel_leer",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "zigarrenschachtel_leer")))));
    public static final RegistryObject<Item> DECKBLATT = ITEMS.register("deckblatt",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "deckblatt")))));
    public static final RegistryObject<Item> PFEIFE = ITEMS.register("pfeife",
            () -> new PfeifenItem(new Item.Properties().durability(220).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "pfeife")))));
    public static final RegistryObject<Item> PFEIFE_LEER = ITEMS.register("pfeife_leer",
            () -> new LeerePfeifenItem(new Item.Properties().stacksTo(1).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "pfeife_leer")))));
    public static final RegistryObject<Item> ZIGARETTE_MENTHOL = ITEMS.register("zigarette_menthol",
            () -> new MenthZigarettenItem(new Item.Properties().durability(200).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "zigarette_menthol")))));
    public static final RegistryObject<Item> ZIGARETTENSCHACHTEL_MENTHOL = ITEMS.register("zigarettenschachtel_menthol",
            () -> new ZigSchachtelItem(new Item.Properties().durability(21).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "zigarettenschachtel_menthol")))));
    public static final RegistryObject<Item> ZIGARETTENSCHACHTEL_MENTHOL_LEER = ITEMS.register("zigarettenschachtel_menthol_leer",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "zigarettenschachtel_menthol_leer")))));
    public static final RegistryObject<Item> ZIGARETTE_SCHEISE = ITEMS.register("zigarette_scheise",
            () -> new ScheisZigarettenItem(new Item.Properties().durability(100).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "zigarette_scheise")))));
    public static final RegistryObject<Item> DSCHOINT = ITEMS.register("dschoint",
            () -> new DschointItem(new Item.Properties().durability(200).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "dschoint")))));
    public static final RegistryObject<Item> KAKERLAKE = ITEMS.register("kakerlake",
            () -> new KakerlakenItem(new Item.Properties().stacksTo(64).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "kakerlake")))));
    public static final RegistryObject<Item> KAUTABAK = ITEMS.register("kautabak",
            () -> new KautabakItem(new Item.Properties().stacksTo(64).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "kautabak")))));
    public static final RegistryObject<Item> KAUTABAKMISCHE = ITEMS.register("kautabakmische",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "kautabakmische")))));
    public static final RegistryObject<Item> TABAKEISKREM = ITEMS.register("tabakeiskrem",
            () -> new TabakEiskremItem(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "tabakeiskrem"))).stacksTo(8)));
    public static final RegistryObject<Item> SUIZIDZIGARETTE = ITEMS.register("suizidzigarette",
            () -> new SuizidZigarettenItem(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "suizidzigarette"))).stacksTo(1)));
    public static final RegistryObject<Item> RAKETENZIGARRE = ITEMS.register("raketenzigarre",
            () -> new RaketenZigrrItem(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "raketenzigarre"))).stacksTo(16)));
    public static final RegistryObject<Item> ZIGARETTE_KAMEL = ITEMS.register("zigarette_kamel",
            () -> new KamelZigItem(new Item.Properties().rarity(Rarity.EPIC).component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true).durability(300).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "zigarette_kamel")))));
    public static final RegistryObject<Item> STUMMEL_MENTHOL = ITEMS.register("stummel_menthol",
            () -> new StummelItem(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "stummel_menthol")))));
    public static final RegistryObject<Item> STUMMEL_KAMEL = ITEMS.register("stummel_kamel",
            () -> new StummelItem(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "stummel_kamel")))));

    public static final RegistryObject<Item> SPUCKE = ITEMS.register("spucke",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "spucke")))));

    public static void register(IEventBus eventBus)
    {
    ITEMS.register(eventBus);
    }
}