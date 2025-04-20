package mett.palemannie.tabakmod.item.custom;

import mett.palemannie.tabakmod.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class ZigSchachtelItem extends Item {
    public ZigSchachtelItem(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        ItemStack zig = new ItemStack(ModItems.ZIGARETTE.get());
        ItemStack zig_menthol = new ItemStack(ModItems.ZIGARETTE_MENTHOL.get());
        ItemStack zig_scheise = new ItemStack(ModItems.ZIGARETTE_SCHEISE.get());

        stack.hurtAndBreak(1,pPlayer, EquipmentSlot.MAINHAND); /*p ->{
            if(this == ModItems.ZIGARETTENSCHACHTEL.get()){
                ItemStack z = new ItemStack(ModItems.ZIGARETTENSCHACHTEL_LEER.get());
                p.setItemInHand(pUsedHand,z);
            }
            if(this == ModItems.ZIGARETTENSCHACHTEL_GROSS.get()){
                ItemStack x = new ItemStack(ModItems.ZIGARETTENSCHACHTEL_GROSS_LEER.get());
                p.setItemInHand(pUsedHand,x);
            }
            if(this == ModItems.ZIGARETTENSCHACHTEL_MENTHOL.get()){
                ItemStack x = new ItemStack(ModItems.ZIGARETTENSCHACHTEL_MENTHOL_LEER.get());
                p.setItemInHand(pUsedHand,x);
            }
            p.stopUsingItem();
        });*/

        if(stack.getDamageValue() >= stack.getMaxDamage()-1){
            pPlayer.playSound(SoundEvents.BOOK_PAGE_TURN);
            if(this == ModItems.ZIGARETTENSCHACHTEL.get()){ pPlayer.setItemInHand(pUsedHand, new ItemStack(ModItems.ZIGARETTENSCHACHTEL_LEER.get())); }
            if(this == ModItems.ZIGARETTENSCHACHTEL_GROSS.get()){ pPlayer.setItemInHand(pUsedHand, new ItemStack(ModItems.ZIGARETTENSCHACHTEL_GROSS_LEER.get())); }
            if(this == ModItems.ZIGARETTENSCHACHTEL_MENTHOL.get()){ pPlayer.setItemInHand(pUsedHand, new ItemStack(ModItems.ZIGARETTENSCHACHTEL_MENTHOL_LEER.get())); }
            pPlayer.stopUsingItem();
        }
        pPlayer.playSound(SoundEvents.CHAIN_PLACE);
        if(this == ModItems.ZIGARETTENSCHACHTEL_MENTHOL.get()){pPlayer.addItem(zig_menthol);} else pPlayer.addItem(zig);
        pPlayer.stopUsingItem();
        return ItemUtils.startUsingInstantly(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BLOCK;
    }
}
