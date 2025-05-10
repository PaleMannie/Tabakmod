package mett.palemannie.tabakmod.entity.custom;

import mett.palemannie.tabakmod.entity.ModEntities;
import mett.palemannie.tabakmod.item.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

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

    public StummelEntity( Level pLevel, LivingEntity pLivingEntity) {
        super(ModEntities.STUMMEL.get(), pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.ZIGARETTENSTUMMEL.get();
    }

    @Override
    public void tick() {
        super.tick();
        level().addParticle(ParticleTypes.ASH,
                this.getX() + RandomSource.create().nextFloat()/3,
                this.getY() + RandomSource.create().nextFloat()/3,
                this.getZ() + RandomSource.create().nextFloat()/3, 0d, 0.5d, 0d);
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        this.discard();
        super.onHitBlock(pResult);
    }
}
