package mett.palemannie.tabakmod.item.custom;

import mett.palemannie.tabakmod.item.ModItems;
import mett.palemannie.tabakmod.sound.ModSounds;
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

public class TabakEiskremItem extends Item implements IForgeMobEffect {

    public TabakEiskremItem(Properties pProperties) { super(pProperties); }

    ////////////////////////////////////////////////////EIGENE METHODEN/////////////////////////////////////////////////////

    void gibEffekt(Player player, int zeit){

        player.playSound(ModSounds.MWTM.get(), 3f, 1f);
        player.playSound(SoundEvents.PLAYER_BURP, 3f, 1f);

        player.getFoodData().eat(8, 1);

        player.addEffect(new MobEffectInstance(MobEffects.NAUSEA, 200, 0));
        player.addEffect(new MobEffectInstance(MobEffects.MINING_FATIGUE, zeit, 1));
        player.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, zeit, 1));
        player.addEffect(new MobEffectInstance(MobEffects.STRENGTH, zeit, 2));
    }

    ////////////////////////////////////////////////////NUTZMETHODEN////////////////////////////////////////////////////////

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

        if(pRemainingTime % 4 == 0 && pRemainingTime < this.getUseDuration(pStack, pEntity)-15) {
            pLevel.playSound(null, pEntity.getX(), pEntity.getY(), pEntity.getZ(), SoundEvents.GENERIC_EAT, SoundSource.PLAYERS, 1f, 1f);
            pLevel.addParticle(ParticleTypes.SPIT, pEntity.getEyePosition().x + pEntity.getViewVector(1f).x/3, pEntity.getEyePosition().y-0.2f + pEntity.getViewVector(1f).y/3, pEntity.getEyePosition().z + pEntity.getViewVector(1f).z/3, 0f,0f,0f);
        }
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

            player.getCooldowns().addCooldown(ModItems.TABAKEISKREM.getId(), 2);
        }
    }

    ////////////////////////////////////////////////////SONSTIGE METHODEN///////////////////////////////////////////////////

    @Override
    public boolean isPiglinCurrency(ItemStack stack) { return true; }
    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) { return true; }
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
        return 99;
    }
}
