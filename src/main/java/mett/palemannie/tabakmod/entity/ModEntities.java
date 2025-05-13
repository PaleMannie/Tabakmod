package mett.palemannie.tabakmod.entity;

import mett.palemannie.tabakmod.TabakMod;
import mett.palemannie.tabakmod.entity.custom.RaketenZigrrEntity;
import mett.palemannie.tabakmod.entity.custom.SpuckeEntity;
import mett.palemannie.tabakmod.entity.custom.StummelEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
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

    public static final RegistryObject<EntityType<StummelEntity>> STUMMEL =
            ENTITY_TYPES.register("stummel", () -> build(EntityType.Builder.<StummelEntity>of(StummelEntity::new, MobCategory.MISC)
                    .sized(0.2f, 0.2f)
                    .fireImmune(), "stummel"));

    public static final RegistryObject<EntityType<RaketenZigrrEntity>> RAKETENZIGRR =
            ENTITY_TYPES.register("raketenzigarre", () -> build(EntityType.Builder.<RaketenZigrrEntity>of(RaketenZigrrEntity::new, MobCategory.MISC)
                    .sized(0.25f, 0.25f)
                    .fireImmune(), "raketenzigarre"));

    private static <T extends Entity> EntityType<T> build(EntityType.Builder<T> builder, String type) {
        ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, type));
        return builder.build(key);
    }

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
