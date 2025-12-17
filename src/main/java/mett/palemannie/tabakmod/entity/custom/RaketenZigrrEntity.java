package mett.palemannie.tabakmod.entity.custom;

import mett.palemannie.tabakmod.entity.ModEntities;
import mett.palemannie.tabakmod.item.ModItems;
import mett.palemannie.tabakmod.util.ModDamageTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class RaketenZigrrEntity extends ThrowableItemProjectile {

    private int dauer = 0;

    public RaketenZigrrEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {

        super(pEntityType, pLevel);
    }

    @Override
    protected Item m_439752_() {
        return null;
    }

    public RaketenZigrrEntity(Level pLevel, LivingEntity livingEntity, ItemStack stack) {

        this(livingEntity.getX(), livingEntity.getEyeY() - 0.2, livingEntity.getZ(), pLevel, stack);
        this.setOwner(livingEntity);
    }

    public RaketenZigrrEntity(double x, double y, double z, Level pLevel, ItemStack stack) {

        super(ModEntities.RAKETENZIGRR.get(), x, y, z, pLevel, stack);
        this.setItem(stack);
    }

    @Override
    public void tick() {

        super.tick();

        dauer++;

        level().addParticle(ParticleTypes.FIREWORK,
                this.getX() + RandomSource.create().nextFloat()/3,
                this.getY() + RandomSource.create().nextFloat()/3,
                this.getZ() + RandomSource.create().nextFloat()/3,
                0d + RandomSource.create().nextInt(-10, 10)/100d,
                0d + RandomSource.create().nextInt(-10, 10)/100d,
                0d + RandomSource.create().nextInt(-10, 10)/100d);

        if (!this.level().isClientSide()) {

            if (this.dauer > 30) {
                explode();
            }
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {

        if (!this.level().isClientSide()) {

            explode();
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {

        if (!this.level().isClientSide()) {

            explode();
        }
    }

    private void explode() {

        level().explode(null, level().damageSources().source(ModDamageTypes.RAKETENZIGARRE_SCHADEN),
                new ExplosionDamageCalculator(),
                this.getX(),
                this.getEyeY(),
                this.getZ(),
                1f,
                false,
                Level.ExplosionInteraction.NONE
        );
        this.discard();
    }


    @Override
    protected Item getDefaultItem() { return ModItems.RAKETENZIGARRE.get(); }

    @Override
    public boolean isNoGravity() { return true; }

}
