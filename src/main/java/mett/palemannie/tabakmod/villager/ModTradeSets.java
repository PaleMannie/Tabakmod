package mett.palemannie.tabakmod.villager;

import mett.palemannie.tabakmod.TabakMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.trading.TradeSet;

public final class ModTradeSets {
    public static final ResourceKey<TradeSet> TABAKHAENDLER_LEVEL_1 = key("tabakhaendler/level_1");
    public static final ResourceKey<TradeSet> TABAKHAENDLER_LEVEL_2 = key("tabakhaendler/level_2");
    public static final ResourceKey<TradeSet> TABAKHAENDLER_LEVEL_3 = key("tabakhaendler/level_3");
    public static final ResourceKey<TradeSet> TABAKHAENDLER_LEVEL_4 = key("tabakhaendler/level_4");
    public static final ResourceKey<TradeSet> TABAKHAENDLER_LEVEL_5 = key("tabakhaendler/level_5");

    private static ResourceKey<TradeSet> key(String path) {
        return ResourceKey.create(Registries.TRADE_SET, Identifier.fromNamespaceAndPath(TabakMod.MODID, path));
    }

    private ModTradeSets() {}
}