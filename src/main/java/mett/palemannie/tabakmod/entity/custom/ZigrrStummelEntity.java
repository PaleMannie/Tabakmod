package mett.palemannie.tabakmod.entity.custom;

import mett.palemannie.tabakmod.entity.ModEntities;
import mett.palemannie.tabakmod.item.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class ZigrrStummelEntity extends ThrowableItemProjectile {

    public ZigrrStummelEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {

        super(pEntityType, pLevel);
    }

    public ZigrrStummelEntity(Level pLevel, LivingEntity livingEntity, ItemStack stack) {

        this(livingEntity.getX(), livingEntity.getEyeY() - 0.2, livingEntity.getZ(), pLevel, stack);
        this.setOwner(livingEntity);
    }

    public ZigrrStummelEntity(double x, double y, double z, Level pLevel, ItemStack stack) {

        super(ModEntities.STUMMEL.get(), x, y, z, pLevel, stack);
        this.setItem(stack);
    }

    @Override
    public void tick() {

        if(this.isInLava()) {

            this.discard();
            level().playSound(this, this.blockPosition(), SoundEvents.LAVA_EXTINGUISH, SoundSource.NEUTRAL, 1f, 1f);
        }

        if(this.isInLiquid()) {

            this.push(0d, 0.1d, 0d);
        }

        super.tick();
        level().addParticle(ParticleTypes.ASH,
                this.getX() + RandomSource.create().nextFloat() * this.getViewVector(0f).x/4,
                this.getY() + RandomSource.create().nextFloat() * this.getViewVector(0f).y/4 + 0.1f,
                this.getZ() + RandomSource.create().nextFloat() * this.getViewVector(0f).z/4, 0d, 0d, 0d);
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {

        this.setPos(this.getX(), this.getY(), this.getZ());
        this.setDeltaMovement(0d,0.0305d,0d);
        super.onHitBlock(pResult);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {

        super.onHitEntity(pResult);
    }

    @Override
    public void playerTouch(Player pPlayer) {

        super.playerTouch(pPlayer);

        ItemStack stack = pPlayer.getItemInHand(InteractionHand.MAIN_HAND);

        if(stack.is(Items.BRUSH) && pPlayer.isUsingItem()){

            pPlayer.drop(ModItems.ZIGARRENSTUMMEL.get().getDefaultInstance(), false);
            this.discard();
        }
    }

    @Override
    protected Item getDefaultItem() { return ModItems.ZIGARRENSTUMMEL.get(); }

    @Override
    public boolean isPushable() { return true; }

}