package mett.palemannie.tabakmod.entity.custom;

import mett.palemannie.tabakmod.entity.ModEntities;
import mett.palemannie.tabakmod.item.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class SpuckeEntity extends ThrowableItemProjectile {

    public SpuckeEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    public SpuckeEntity(Level pLevel, LivingEntity livingEntity, ItemStack stack) {
        this(livingEntity.getX(), livingEntity.getEyeY() - 0.2, livingEntity.getZ(), pLevel, stack);
        this.setOwner(livingEntity);
    }

    public SpuckeEntity(double x, double y, double z, Level pLevel, ItemStack stack) {
        super(ModEntities.SPUCKE.get(), x, y, z, pLevel, stack);
        this.setItem(stack);

    }

    public SpuckeEntity( Level pLevel, LivingEntity pLivingEntity) {
        super(ModEntities.SPUCKE.get(), pLevel);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.isInLiquid()) {
            this.discard();
        } else if (this.level().getBlockStates(this.getBoundingBox()).noneMatch(BlockBehaviour.BlockStateBase::isAir)) {
            this.discard();
        }

        if (this.tickCount % 7 == 0) {
            level().addParticle(ParticleTypes.SPIT, this.getX(), this.getY() + 0.2, this.getZ(), 0d, 0d, 0d);
        }
        level().addParticle(ParticleTypes.SPLASH, this.getX(), this.getY() + 0.2, this.getZ(), 0d, 0d, 0d);
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)3);
            this.discard();
        }
        super.onHitBlock(pResult);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        Entity entity = pResult.getEntity();
        entity.hurt(damageSources().thrown(this, this.getOwner()), 1f);
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte) 3);
            this.discard();
        }
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.SPUCKE.get();
    }

}
