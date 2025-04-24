package mett.palemannie.tabakmod.item.custom;

import mett.palemannie.tabakmod.effect.ModEffects;
import mett.palemannie.tabakmod.item.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.extensions.IForgeMobEffect;

public class KautabakItem extends Item implements IForgeMobEffect {
    public KautabakItem(Properties pProperties) { super(pProperties); }
////////////////////////////////////////////////////EIGENE METHODEN/////////////////////////////////////////////////////
    void gibEffekt(Player player, int zeit){
        player.playSound(SoundEvents.SLIME_JUMP, 3f, 1f);
        player.getFoodData().eat(2, 2);

        player.addEffect(new MobEffectInstance(ModEffects.SPUCKEN.getHolder().get(), zeit, 0));
        player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 150, 0));
        player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, zeit, 0));
    }
/// /////////////////////////////////////////////////NUTZMETHODEN////////////////////////////////////////////////////////
    @Override
    public InteractionResult use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        return ItemUtils.startUsingInstantly(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public boolean releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity, int pTimeCharged) {
        this.stopUsing(pLivingEntity);
        return false;
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity pEntity, ItemStack pStack, int pRemainingTime) {
        pLevel.addParticle(ParticleTypes.CRIT, pEntity.getEyePosition().x + pEntity.getViewVector(1f).x/3, pEntity.getEyePosition().y-0.2f + pEntity.getViewVector(1f).y/3, pEntity.getEyePosition().z + pEntity.getViewVector(1f).z/3, 0f,0f,0f);
        if(pRemainingTime % 4 == 0 && pRemainingTime < this.getUseDuration(pStack, pEntity)-5) pLevel.playSound(null, pEntity.getX(), pEntity.getY(), pEntity.getZ(), SoundEvents.GENERIC_EAT, SoundSource.PLAYERS, 1f, 1f);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if(pLivingEntity instanceof Player player) {
            gibEffekt(player, 600);
            if(!((Player) pLivingEntity).isCreative()){
                pStack.shrink(1);
            }

        }
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }
    private void stopUsing(LivingEntity pUser) {
        if (pUser instanceof Player player) {
            player.getCooldowns().addCooldown(ModItems.KAUTABAK.getId(), 2);
        }
    }

////////////////////////////////////////////////////SONSTIGE METHODEN///////////////////////////////////////////////////
    @Override
    public ItemUseAnimation getUseAnimation(ItemStack pStack) {
        return ItemUseAnimation.EAT;
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged;
    }

    @Override
    public int getEntityLifespan(ItemStack itemStack, Level level) {
        return 72000;
    }

    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlot armorType, Entity entity) {
        return true;
    }

    public int getUseDuration(ItemStack pStack, LivingEntity pEntity) {
        return 49;
    }
}
