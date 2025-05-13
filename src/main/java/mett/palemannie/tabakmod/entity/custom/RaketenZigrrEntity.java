package mett.palemannie.tabakmod.entity.custom;

import mett.palemannie.tabakmod.entity.ModEntities;
import mett.palemannie.tabakmod.item.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class RaketenZigrrEntity extends ThrowableItemProjectile {

    private int dauer = 0;

    public RaketenZigrrEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {

        super(pEntityType, pLevel);
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

        if (!this.level().isClientSide) {

            if (this.dauer > 40) {
                explode();
            }
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {

        if (!this.level().isClientSide) {

            explode();
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {

        if (!this.level().isClientSide) {

            explode();
        }
    }

    private void explode() {

        this.level().explode(this, this.getX(), this.getY(), this.getZ(), 1f, Level.ExplosionInteraction.NONE);
        this.discard();
    }

    @Override
    protected Item getDefaultItem() { return ModItems.RAKETENZIGARRE.get(); }

    @Override
    public boolean isNoGravity() { return true; }

}
