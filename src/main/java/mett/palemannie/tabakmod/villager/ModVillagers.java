package mett.palemannie.tabakmod.villager;

import com.google.common.collect.ImmutableSet;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import mett.palemannie.tabakmod.TabakMod;
import mett.palemannie.tabakmod.block.ModBlocks;
import mett.palemannie.tabakmod.sound.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, TabakMod.MODID);

    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, TabakMod.MODID);

    public static final RegistryObject<PoiType> ASCHENBECHER_POI = POI_TYPES.register("aschenbecher_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.ASCHENBECHER_GROSS.get().getStateDefinition().getPossibleStates()), 1, 1));

    public static final RegistryObject<VillagerProfession> TABAKHAENDLER = VILLAGER_PROFESSIONS.register(
            "tabakhaendler",
            () -> new VillagerProfession(
                    Component.translatable("entity.minecraft.villager.tabakmod.tabakhaendler"),
                    holder -> holder.get() == ASCHENBECHER_POI.get(),
                    holder -> holder.get() == ASCHENBECHER_POI.get(),
                    ImmutableSet.of(),
                    ImmutableSet.of(),
                    ModSounds.PFEIFE_LADEN.get(),
                    Int2ObjectMap.ofEntries(
                            Int2ObjectMap.entry(1, ModTradeSets.TABAKHAENDLER_LEVEL_1),
                            Int2ObjectMap.entry(2, ModTradeSets.TABAKHAENDLER_LEVEL_2),
                            Int2ObjectMap.entry(3, ModTradeSets.TABAKHAENDLER_LEVEL_3),
                            Int2ObjectMap.entry(4, ModTradeSets.TABAKHAENDLER_LEVEL_4),
                            Int2ObjectMap.entry(5, ModTradeSets.TABAKHAENDLER_LEVEL_5)
                    )
            )
    );

    public static void register(BusGroup eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
