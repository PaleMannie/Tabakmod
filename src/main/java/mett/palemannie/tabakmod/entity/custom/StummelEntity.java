package mett.palemannie.tabakmod.entity.custom;

import mett.palemannie.tabakmod.entity.ModEntities;
import mett.palemannie.tabakmod.item.ModItems;
import net.minecraft.core.particles.ParticleTypes;
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

public class StummelEntity extends ThrowableItemProjectile {

    public StummelEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    public StummelEntity(Level pLevel, LivingEntity livingEntity, ItemStack stack) {
        this(livingEntity.getX(), livingEntity.getEyeY() - 0.2, livingEntity.getZ(), pLevel, stack);
        this.setOwner(livingEntity);
    }

    public StummelEntity(double x, double y, double z, Level pLevel, ItemStack stack) {
        super(ModEntities.STUMMEL.get(), x, y, z, pLevel, stack);
        this.setItem(stack);

    }

    @Override
    protected Item getDefaultItem() {

        return ModItems.ZIGARETTENSTUMMEL.get();
    }

    @Override
    public void tick() {

        super.tick();
        level().addParticle(ParticleTypes.ASH,
                this.getX() + RandomSource.create().nextFloat() * this.getViewVector(0f).x/4,
                this.getY() + RandomSource.create().nextFloat() * this.getViewVector(0f).y/4 + 0.1f,
                this.getZ() + RandomSource.create().nextFloat() * this.getViewVector(0f).z/4, 0d, 0d, 0d);
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {

        this.setPos(this.getX(), this.getY(), this.getZ());
        this.setDeltaMovement(0d,0d,0d);
        super.onHitBlock(pResult);
    }

    @Override
    public void playerTouch(Player pPlayer) {

        super.playerTouch(pPlayer);
        ItemStack stack = pPlayer.getItemInHand(InteractionHand.MAIN_HAND);

        if(stack.is(Items.BRUSH) && pPlayer.isUsingItem()){

            pPlayer.drop(ModItems.ZIGARETTENSTUMMEL.get().getDefaultInstance(), false);
            this.discard();
        }
    }

    @Override
    public boolean isPushable() {

        return true;
    }

}
