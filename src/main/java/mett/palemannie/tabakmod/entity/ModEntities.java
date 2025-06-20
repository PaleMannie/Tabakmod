package mett.palemannie.tabakmod.entity;

import mett.palemannie.tabakmod.TabakMod;
import mett.palemannie.tabakmod.entity.custom.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES.getRegistryKey(), TabakMod.MODID);

    public static final RegistryObject<EntityType<SpuckeEntity>> SPUCKE =
            ENTITY_TYPES.register("spucke", () -> build(EntityType.Builder.<SpuckeEntity>of(SpuckeEntity::new, MobCategory.MISC)
                    .sized(0.2f, 0.2f)
                    .fireImmune(), "spucke"));

    public static final RegistryObject<EntityType<ZigStummelEntity>> STUMMEL =
            ENTITY_TYPES.register("stummel", () -> build(EntityType.Builder.<ZigStummelEntity>of(ZigStummelEntity::new, MobCategory.MISC)
                    .sized(0.2f, 0.2f)
                    .fireImmune(), "stummel"));

    public static final RegistryObject<EntityType<ZigKamelStummelEntity>> STUMMEL_KAMEL =
            ENTITY_TYPES.register("stummel_kamel", () -> build(EntityType.Builder.<ZigKamelStummelEntity>of(ZigKamelStummelEntity::new, MobCategory.MISC)
                    .sized(0.2f, 0.2f)
                    .fireImmune(), "stummel_kamel"));

    public static final RegistryObject<EntityType<ZigMentholStummelEntity>> STUMMEL_MENTHOL =
            ENTITY_TYPES.register("stummel_menthol", () -> build(EntityType.Builder.<ZigMentholStummelEntity>of(ZigMentholStummelEntity::new, MobCategory.MISC)
                    .sized(0.2f, 0.2f)
                    .fireImmune(), "stummel_menthol"));

    public static final RegistryObject<EntityType<ZigrrStummelEntity>> STUMMEL_ZIGRR =
            ENTITY_TYPES.register("zigarrenstummel", () -> build(EntityType.Builder.<ZigrrStummelEntity>of(ZigrrStummelEntity::new, MobCategory.MISC)
                    .sized(0.2f, 0.2f)
                    .fireImmune(), "zigarrenstummel"));

    public static final RegistryObject<EntityType<RaketenZigrrEntity>> RAKETENZIGRR =
            ENTITY_TYPES.register("raketenzigarre", () -> build(EntityType.Builder.<RaketenZigrrEntity>of(RaketenZigrrEntity::new, MobCategory.MISC)
                    .sized(0.25f, 0.25f)
                    .fireImmune(), "raketenzigarre"));

    private static <T extends Entity> EntityType<T> build(EntityType.Builder<T> builder, String type) {
        ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, type));
        return builder.build(key);
    }

    public static void register(BusGroup eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
