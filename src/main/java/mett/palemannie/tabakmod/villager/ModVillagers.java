package mett.palemannie.tabakmod.villager;

import net.minecraft.core.registries.Registries;
import com.google.common.collect.ImmutableSet;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.trading.TradeSet;
import mett.palemannie.tabakmod.TabakMod;
import mett.palemannie.tabakmod.block.ModBlocks;
import mett.palemannie.tabakmod.sound.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(Registries.POINT_OF_INTEREST_TYPE, TabakMod.MODID);

    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(Registries.VILLAGER_PROFESSION, TabakMod.MODID);

    public static final DeferredHolder<PoiType, PoiType> ASCHENBECHER_POI = POI_TYPES.register("aschenbecher_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.ASCHENBECHER_GROSS.get().getStateDefinition().getPossibleStates()), 1, 1));

    public static final DeferredHolder<VillagerProfession, VillagerProfession> TABAKHAENDLER = VILLAGER_PROFESSIONS.register("tabakhaendler",
            () -> new VillagerProfession(Component.translatable("entity.minecraft.villager.tabakmod.tabakhaendler"), x -> x.is(ASCHENBECHER_POI.getKey()), x -> x.is(ASCHENBECHER_POI.getKey()),
                    ImmutableSet.of(), ImmutableSet.of(), ModSounds.PFEIFE_LADEN.get(), tradeSets()));

    private static Int2ObjectMap<ResourceKey<TradeSet>> tradeSets() {
        var sets = new Int2ObjectOpenHashMap<ResourceKey<TradeSet>>();
        for (int level = 1; level <= 5; level++) {
            sets.put(level, ResourceKey.create(Registries.TRADE_SET,
                    Identifier.fromNamespaceAndPath(TabakMod.MODID, "tabakhaendler/level_" + level)));
        }
        return sets;
    }

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
