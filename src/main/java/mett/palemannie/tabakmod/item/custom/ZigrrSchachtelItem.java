package mett.palemannie.tabakmod.item.custom;

import mett.palemannie.tabakmod.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.level.Level;

public class ZigrrSchachtelItem extends ZigSchachtelItem{
    public ZigrrSchachtelItem(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        ItemStack zigrr = new ItemStack(ModItems.ZIGARRE.get());

        stack.hurtAndBreak(1,pPlayer, EquipmentSlot.MAINHAND);

        if(stack.getDamageValue() >= stack.getMaxDamage()-1){
            pPlayer.playSound(SoundEvents.AXE_STRIP,4f,1);
            if(this == ModItems.ZIGARRENSCHACHTEL.get()){ pPlayer.setItemInHand(pUsedHand, new ItemStack(ModItems.ZIGARRENSCHACHTEL_LEER.get())); }
            pPlayer.stopUsingItem();
        }
        pPlayer.playSound(SoundEvents.ARMOR_EQUIP_CHAIN.get());
        pPlayer.addItem(zigrr);
        pPlayer.stopUsingItem();
        return ItemUtils.startUsingInstantly(pLevel, pPlayer, pUsedHand);
    }
}