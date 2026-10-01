package mett.palemannie.tabakmod.effect;

import net.minecraft.core.registries.Registries;
import mett.palemannie.tabakmod.TabakMod;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(Registries.MOB_EFFECT, TabakMod.MODID);

    public static final DeferredHolder<MobEffect, MobEffect> SPUCKEN = MOB_EFFECTS.register("spucken", ()-> new SpuckenEffect(MobEffectCategory.NEUTRAL, 11924987));

    public static void register(IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);
    }
}
