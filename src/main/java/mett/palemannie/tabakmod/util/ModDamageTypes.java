package mett.palemannie.tabakmod.util;

import mett.palemannie.tabakmod.TabakMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;

public class ModDamageTypes {

    public static final ResourceKey<DamageType> register(String name){
        return ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, name));
    }

    public static final ResourceKey<DamageType> ZIG_SCHADEN =   register("zig_schaden");
    public static final ResourceKey<DamageType> SPUCK_SCHADEN =   register("spuck_schaden");
}
