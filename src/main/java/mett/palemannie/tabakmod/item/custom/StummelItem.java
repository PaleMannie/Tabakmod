package mett.palemannie.tabakmod.item.custom;

import mett.palemannie.tabakmod.entity.ModEntities;
import mett.palemannie.tabakmod.entity.custom.SpuckeEntity;
import mett.palemannie.tabakmod.entity.custom.StummelEntity;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class StummelItem extends Item implements ProjectileItem {
    public StummelItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);

        pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));

        if (pLevel instanceof ServerLevel serverlevel) {
            Projectile.spawnProjectileFromRotation(StummelEntity::new, serverlevel, itemstack, pPlayer, 0f, 0.5f, 10f);
        }

        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        itemstack.consume(1, pPlayer);
        return InteractionResult.SUCCESS;
    }

    @Override
    public int getEntityLifespan(ItemStack itemStack, Level level) {
        return 72000;
    }

    @Override
    public @NotNull Projectile asProjectile(Level pLevel, Position pPos, ItemStack pStack, Direction pDirection) {
        return new StummelEntity(pPos.x(), pPos.y(), pPos.z(), pLevel, pStack);
    }
}