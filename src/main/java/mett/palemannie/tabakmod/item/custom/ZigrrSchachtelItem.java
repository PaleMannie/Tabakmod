package mett.palemannie.tabakmod.item.custom;

import mett.palemannie.tabakmod.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.level.Level;

public class ZigrrSchachtelItem extends Item {
    public ZigrrSchachtelItem(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public InteractionResult use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        ItemStack zigrr = new ItemStack(ModItems.ZIGARRE.get());

        if(!(pPlayer.getInventory().getFreeSlot() == -1)) {

            if(!pLevel.isClientSide()) {

                stack.hurtAndBreak(1, pPlayer, EquipmentSlot.MAINHAND);

                if (stack.getDamageValue() >= stack.getMaxDamage()) {

                    pLevel.playSound(null, pPlayer.getX(), pPlayer.getEyeY(), pPlayer.getZ(), SoundEvents.AXE_STRIP, SoundSource.PLAYERS,4f, 1f);
                    if (this == ModItems.ZIGARRENSCHACHTEL.get()) {
                        pPlayer.setItemInHand(pUsedHand, new ItemStack(ModItems.ZIGARRENSCHACHTEL_LEER.get()));
                    }
                    pPlayer.stopUsingItem();
                }

                pLevel.playSound(null, pPlayer.getX(), pPlayer.getEyeY(), pPlayer.getZ(), SoundEvents.ARMOR_EQUIP_CHAIN, SoundSource.PLAYERS,1f, 1f);
                pPlayer.addItem(zigrr);
                pPlayer.stopUsingItem();
            }
        } else {

            var msg = MutableComponent.create(new TranslatableContents("tabakmod.iteminteraction.schachtel", null, new Object[0])).withStyle(ChatFormatting.GOLD);
            pPlayer.displayClientMessage(msg, true);
            return InteractionResult.FAIL;
        }

        return InteractionResult.PASS;
    }

    @Override
    public ItemUseAnimation getUseAnimation(ItemStack pStack) { return ItemUseAnimation.BLOCK; }
}