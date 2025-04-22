package mett.palemannie.tabakmod.item.custom;

import mett.palemannie.tabakmod.item.ModItems;
import mett.palemannie.tabakmod.sound.ModSounds;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class LeerePfeifenItem extends Item {
    public LeerePfeifenItem(Properties pProperties) {
        super(pProperties);
    }
////////////////////////////////////////////EIGENE METHODEN/////////////////////////////////////////////////////////////

////////////////////////////////////////////NUTZMETHODEN////////////////////////////////////////////////////////////////
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        ItemStack derPassendeTabak = new ItemStack(ModItems.MITTLERER_TABAK_BEHANDELT.get());
        boolean istTabakImInventar = pPlayer.getInventory().contains(derPassendeTabak);
        if(istTabakImInventar || pPlayer.isCreative()){
            pPlayer.startUsingItem(pUsedHand);
            RandomSource rdm = RandomSource.create();
            float r = (float)rdm.nextInt(8,12)/10;
            pPlayer.playSound(SoundEvents.COMPOSTER_READY, 0.5f,r);

            return InteractionResultHolder.consume(itemstack);
        } else {
        return InteractionResultHolder.fail(itemstack); }
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
        if(pRemainingUseDuration % 10 == 0){
        RandomSource rdm = RandomSource.create();
        float r = (float)rdm.nextInt(8,12)/10;
        pLivingEntity.playSound(ModSounds.PFEIFE_LADEN.get(), 1f,r);
        }
        super.onUseTick(pLevel, pLivingEntity, pStack, pRemainingUseDuration);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        ItemStack tbk = new ItemStack(ModItems.MITTLERER_TABAK_BEHANDELT.get());
        if(pLivingEntity instanceof Player pPlayer){
            if(!pPlayer.isCreative()){
            pPlayer.getInventory().removeItem(pPlayer.getInventory().findSlotMatchingItem(tbk),1);
            }
            InteractionHand pHand = pPlayer.getUsedItemHand();
            pPlayer.setItemInHand(pHand, new ItemStack(ModItems.PFEIFE.get()));
            RandomSource rdm = RandomSource.create();
            float r = (float)rdm.nextInt(8,12)/10;
            pPlayer.playSound(SoundEvents.EXPERIENCE_ORB_PICKUP, 1f,r);

        }
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }

    @Override
    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity, int pTimeCharged) {
        super.releaseUsing(pStack, pLevel, pLivingEntity, pTimeCharged);
    }
//////////////////////////////////////////////SONSTIGE METHODEN/////////////////////////////////////////////////////////
    @Override
    public UseAnim getUseAnimation(ItemStack pStack) { return UseAnim.BRUSH; }
    public int getUseDuration(ItemStack pStack) { return 77; }

    @Override
    public int getEntityLifespan(ItemStack itemStack, Level level) { return 72000; }
    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlot armorType, Entity entity) { return true; }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
