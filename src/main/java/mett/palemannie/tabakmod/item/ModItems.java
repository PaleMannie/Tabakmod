package mett.palemannie.tabakmod.item;

import mett.palemannie.tabakmod.TabakMod;
import mett.palemannie.tabakmod.block.ModBlocks;
import mett.palemannie.tabakmod.item.custom.*;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(Registries.ITEM, TabakMod.MODID);
////////////////////////////////////////////////TABAKGEWÄCHS////////////////////////////////////////////////////////////////////////
    public static final DeferredHolder<Item, Item> TABAKSAMEN = ITEMS.register("tabaksamen",
            () -> new BlockItem(ModBlocks.TABAKPFLANZE.get(),new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "tabaksamen"))).compostable(ResourceKey.create(Registries.CONTEXT_INT_PROVIDER, Identifier.fromNamespaceAndPath(TabakMod.MODID, "compostable/tabaksamen"))).useItemDescriptionPrefix()));
    public static final DeferredHolder<Item, Item> TABAKBLATT = ITEMS.register("tabakblatt",
        () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "tabakblatt"))).compostable(ContextIntProviders.COMPOSTABLE_LOW)));
    public static final DeferredHolder<Item, Item> TROCKENER_TABAK = ITEMS.register("trockener_tabak",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "trockener_tabak")))));
    public static final DeferredHolder<Item, Item> HELLER_TABAK = ITEMS.register("heller_tabak",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "heller_tabak")))));
    public static final DeferredHolder<Item, Item> MITTLERER_TABAK = ITEMS.register("mittlerer_tabak",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "mittlerer_tabak")))));
    public static final DeferredHolder<Item, Item> DUNKLER_TABAK = ITEMS.register("dunkler_tabak",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "dunkler_tabak")))));
    public static final DeferredHolder<Item, Item> HELLER_TABAK_BEHANDELT = ITEMS.register("heller_tabak_behandelt",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "heller_tabak_behandelt")))));
    public static final DeferredHolder<Item, Item> MITTLERER_TABAK_BEHANDELT = ITEMS.register("mittlerer_tabak_behandelt",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "mittlerer_tabak_behandelt")))));
    public static final DeferredHolder<Item, Item> DUNKLER_TABAK_BEHANDELT = ITEMS.register("dunkler_tabak_behandelt",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "dunkler_tabak_behandelt")))));
/////////////////////////////////////////////////TABAKPRODUKTE///////////////////////////////////////////////////////////////////////
    public static final DeferredHolder<Item, Item> ZIGARETTE = ITEMS.register("zigarette",
            () -> new ZigarettenItem(new Item.Properties().durability(200).setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "zigarette")))));
    public static final DeferredHolder<Item, Item> ZIGARETTENSTUMMEL = ITEMS.register("zigarettenstummel",
            () -> new StummelItem(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "zigarettenstummel")))));
    public static final DeferredHolder<Item, Item> ZIGARETTENFILTER = ITEMS.register("zigarettenfilter",
            () -> new StummelItem(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "zigarettenfilter")))));
    public static final DeferredHolder<Item, Item> ZIGARETTEN = ITEMS.register("zigaretten",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "zigaretten")))));
    public static final DeferredHolder<Item, Item> ZIGARETTENSCHACHTEL = ITEMS.register("zigarettenschachtel",
            () -> new ZigSchachtelItem(new Item.Properties().durability(21).setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "zigarettenschachtel")))));
    public static final DeferredHolder<Item, Item> ZIGARETTENSCHACHTEL_LEER = ITEMS.register("zigarettenschachtel_leer",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "zigarettenschachtel_leer")))));
    public static final DeferredHolder<Item, Item> ZIGARETTENSCHACHTEL_GROSS = ITEMS.register("zigarettenschachtel_gross",
            () -> new ZigSchachtelItem(new Item.Properties().durability(31).setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "zigarettenschachtel_gross")))));
    public static final DeferredHolder<Item, Item> ZIGARETTENSCHACHTEL_GROSS_LEER = ITEMS.register("zigarettenschachtel_gross_leer",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "zigarettenschachtel_gross_leer")))));
    public static final DeferredHolder<Item, Item> ZIGARRE = ITEMS.register("zigarre",
            () -> new ZigarrenItem(new Item.Properties().durability(600).setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "zigarre")))));
    public static final DeferredHolder<Item, Item> ZIGARREN = ITEMS.register("zigarren",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "zigarren")))));
    public static final DeferredHolder<Item, Item> ZIGARRENSTUMMEL = ITEMS.register("zigarrenstummel",
            () -> new StummelItem(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "zigarrenstummel")))));
    public static final DeferredHolder<Item, Item> ZIGARRENSCHACHTEL = ITEMS.register("zigarrenschachtel",
            () -> new ZigrrSchachtelItem(new Item.Properties().durability(6).setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "zigarrenschachtel")))));
    public static final DeferredHolder<Item, Item> ZIGARRENSCHACHTEL_LEER = ITEMS.register("zigarrenschachtel_leer",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "zigarrenschachtel_leer")))));
    public static final DeferredHolder<Item, Item> DECKBLATT = ITEMS.register("deckblatt",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "deckblatt")))));
    public static final DeferredHolder<Item, Item> PFEIFE = ITEMS.register("pfeife",
            () -> new PfeifenItem(new Item.Properties().durability(220).setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "pfeife")))));
    public static final DeferredHolder<Item, Item> PFEIFE_LEER = ITEMS.register("pfeife_leer",
            () -> new LeerePfeifenItem(new Item.Properties().stacksTo(1).setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "pfeife_leer")))));
    public static final DeferredHolder<Item, Item> ZIGARETTE_MENTHOL = ITEMS.register("zigarette_menthol",
            () -> new MenthZigarettenItem(new Item.Properties().durability(200).setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "zigarette_menthol")))));
    public static final DeferredHolder<Item, Item> ZIGARETTENSCHACHTEL_MENTHOL = ITEMS.register("zigarettenschachtel_menthol",
            () -> new ZigSchachtelItem(new Item.Properties().durability(21).setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "zigarettenschachtel_menthol")))));
    public static final DeferredHolder<Item, Item> ZIGARETTENSCHACHTEL_MENTHOL_LEER = ITEMS.register("zigarettenschachtel_menthol_leer",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "zigarettenschachtel_menthol_leer")))));
    public static final DeferredHolder<Item, Item> ZIGARETTE_SCHEISE = ITEMS.register("zigarette_scheise",
            () -> new ScheisZigarettenItem(new Item.Properties().durability(100).setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "zigarette_scheise")))));
    public static final DeferredHolder<Item, Item> DSCHOINT = ITEMS.register("dschoint",
            () -> new DschointItem(new Item.Properties().durability(200).setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "dschoint")))));
    public static final DeferredHolder<Item, Item> KAKERLAKE = ITEMS.register("kakerlake",
            () -> new KakerlakenItem(new Item.Properties().stacksTo(64).setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "kakerlake")))));
    public static final DeferredHolder<Item, Item> KAUTABAK = ITEMS.register("kautabak",
            () -> new KautabakItem(new Item.Properties().stacksTo(64).setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "kautabak")))));
    public static final DeferredHolder<Item, Item> KAUTABAKMISCHE = ITEMS.register("kautabakmische",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "kautabakmische")))));
    public static final DeferredHolder<Item, Item> TABAKEISKREM = ITEMS.register("tabakeiskrem",
            () -> new TabakEiskremItem(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "tabakeiskrem"))).stacksTo(8)));
    public static final DeferredHolder<Item, Item> SUIZIDZIGARETTE = ITEMS.register("suizidzigarette",
            () -> new SuizidZigarettenItem(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "suizidzigarette"))).stacksTo(1)));
    public static final DeferredHolder<Item, Item> RAKETENZIGARRE = ITEMS.register("raketenzigarre",
            () -> new RaketenZigrrItem(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "raketenzigarre"))).stacksTo(16)));
    public static final DeferredHolder<Item, Item> ZIGARETTE_KAMEL = ITEMS.register("zigarette_kamel",
            () -> new KamelZigItem(new Item.Properties().rarity(Rarity.EPIC).component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true).durability(300).setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "zigarette_kamel")))));
    public static final DeferredHolder<Item, Item> STUMMEL_MENTHOL = ITEMS.register("stummel_menthol",
            () -> new StummelItem(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "stummel_menthol")))));
    public static final DeferredHolder<Item, Item> STUMMEL_KAMEL = ITEMS.register("stummel_kamel",
            () -> new StummelItem(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "stummel_kamel")))));
    public static final DeferredHolder<Item, Item> STUMMEL_SCHEISE = ITEMS.register("stummel_scheise",
            () -> new StummelItem(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, "stummel_scheise")))));



    public static void register(IEventBus eventBus)
    {
    ITEMS.register(eventBus);
    }
}