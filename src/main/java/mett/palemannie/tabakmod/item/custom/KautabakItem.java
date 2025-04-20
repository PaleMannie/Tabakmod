package mett.palemannie.tabakmod.item.custom;

import mett.palemannie.tabakmod.effect.ModEffects;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
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
////////////////////////////////////////////////////NUTZMETHODEN////////////////////////////////////////////////////////
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        return ItemUtils.startUsingInstantly(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity, int pTimeCharged) {
        this.stopUsing(pLivingEntity);
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
            player.getCooldowns().addCooldown(this, 2);
        }
    }

////////////////////////////////////////////////////SONSTIGE METHODEN///////////////////////////////////////////////////
    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.EAT;
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

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 50;
    }
}
