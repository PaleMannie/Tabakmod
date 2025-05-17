package mett.palemannie.tabakmod.item.custom;

import mett.palemannie.tabakmod.entity.custom.RaketenZigrrEntity;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class RaketenZigrrItem extends Item implements ProjectileItem {

    public RaketenZigrrItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(Level pLevel, Player pPlayer, InteractionHand pHand) {

        ItemStack itemstack = pPlayer.getItemInHand(pHand);

        pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.FIREWORK_ROCKET_LAUNCH, SoundSource.NEUTRAL, 1f, 1f);

        if (pLevel instanceof ServerLevel serverlevel) {
            Projectile.spawnProjectileFromRotation(RaketenZigrrEntity::new, serverlevel, itemstack, pPlayer, 0f, 1.0f, 1f);
        }

        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        itemstack.consume(1, pPlayer);
        return InteractionResult.SUCCESS;
    }

    @Override
    public @NotNull Projectile asProjectile(@NotNull Level pLevel, Position pPos, @NotNull ItemStack pStack, @NotNull Direction pDirection) {
        return new RaketenZigrrEntity(pPos.x(), pPos.y(), pPos.z(), pLevel, pStack);
    }

    @Override
    public boolean isPiglinCurrency(ItemStack stack) { return true; }
    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) { return true; }
    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlot armorType, Entity entity) { return true; }
}