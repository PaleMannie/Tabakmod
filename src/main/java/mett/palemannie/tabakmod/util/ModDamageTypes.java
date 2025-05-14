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
    public static final ResourceKey<DamageType> ZIG_SCHEISE_SCHADEN =   register("zig_scheise_schaden");
    public static final ResourceKey<DamageType> ZIGRR_SCHADEN =   register("zigrr_schaden");
    public static final ResourceKey<DamageType> ZIG_MENTH_SCHADEN =   register("zig_menth_schaden");
    public static final ResourceKey<DamageType> DSCHOINT_SCHADEN =   register("dschoint_schaden");
    public static final ResourceKey<DamageType> PFEIFE_SCHADEN =   register("pfeife_schaden");
    public static final ResourceKey<DamageType> SPUCK_SCHADEN =   register("spuck_schaden");
    public static final ResourceKey<DamageType> SUIZIDZIGARETTE_SCHADEN =   register("suizidzigarette_schaden");
    public static final ResourceKey<DamageType> RAKETENZIGARRE_SCHADEN =   register("raketenzigarre_schaden");
}
