package mett.palemannie.tabakmod.villager;

import com.google.common.collect.ImmutableSet;
import mett.palemannie.tabakmod.TabakMod;
import mett.palemannie.tabakmod.block.ModBlocks;
import mett.palemannie.tabakmod.sound.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.concurrent.Immutable;
import java.lang.reflect.InvocationTargetException;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, TabakMod.MODID);

    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, TabakMod.MODID);

    public static final RegistryObject<PoiType> ASCHENBECHER_POI = POI_TYPES.register("aschenbecher_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.ASCHENBECHER_GROSS.get().getStateDefinition().getPossibleStates()), 1, 1));

    public static final RegistryObject<VillagerProfession> TABAKHAENDLER = VILLAGER_PROFESSIONS.register("tabakhaendler",
            () -> new VillagerProfession(Component.translatable("entity.minecraft.villager.tabakmod.tabakhaendler"), x -> x.get() == ASCHENBECHER_POI.get(), x -> x.get() == ASCHENBECHER_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(), ModSounds.PFEIFE_LADEN.get()));

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
