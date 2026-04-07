package mett.palemannie.tabakmod.item.custom;

import mett.palemannie.tabakmod.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.server.level.ServerPlayer;
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

public class ZigSchachtelItem extends Item {
    public ZigSchachtelItem(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public InteractionResult use(Level pLevel, Player pPlayer, InteractionHand pHand) {

        ItemStack stack = pPlayer.getItemInHand(pHand);
        Item item = stack.getItem();

        ItemStack zig = new ItemStack(ModItems.ZIGARETTE.get());
        ItemStack zigMenthol = new ItemStack(ModItems.ZIGARETTE_MENTHOL.get());
        ItemStack zigKamel = new ItemStack(ModItems.ZIGARETTE_KAMEL.get());

        float r = pLevel.getRandom().nextFloat();

        boolean used = false;

        if(!(pPlayer.getInventory().getFreeSlot() == -1)){

        if(!pLevel.isClientSide()) {

            if (item == ModItems.ZIGARETTENSCHACHTEL.get() || item == ModItems.ZIGARETTENSCHACHTEL_GROSS.get()) {

                if (r > 0.99f) {

                    pPlayer.addItem(zigKamel);
                    pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(),SoundEvents.PLAYER_LEVELUP, SoundSource.PLAYERS, 1f, 0.5f);
                    pPlayer.stopUsingItem();
                } else {

                    pPlayer.addItem(zig);
                    pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(),SoundEvents.CHAIN_PLACE, SoundSource.PLAYERS, 1f, 1f);
                    pPlayer.stopUsingItem();
                }

                used = true;
            }

            if (item == ModItems.ZIGARETTENSCHACHTEL_MENTHOL.get()) {

                pPlayer.addItem(zigMenthol);
                pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(),SoundEvents.CHAIN_PLACE, SoundSource.PLAYERS, 1f, 1f);
                pPlayer.stopUsingItem();
                used = true;
            }

            if (stack.getDamageValue() >= stack.getMaxDamage()-2) {

                pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(),SoundEvents.ITEM_BREAK, SoundSource.PLAYERS, 1f, 1f);

                if (item == ModItems.ZIGARETTENSCHACHTEL.get()) { pPlayer.setItemInHand(pHand, new ItemStack(ModItems.ZIGARETTENSCHACHTEL_LEER.get())); }
                if (item == ModItems.ZIGARETTENSCHACHTEL_GROSS.get()) { pPlayer.setItemInHand(pHand, new ItemStack(ModItems.ZIGARETTENSCHACHTEL_GROSS_LEER.get())); }
                if (item == ModItems.ZIGARETTENSCHACHTEL_MENTHOL.get()) { pPlayer.setItemInHand(pHand, new ItemStack(ModItems.ZIGARETTENSCHACHTEL_MENTHOL_LEER.get())); }
            }

            if (used) {

                stack.hurtAndBreak(1, pPlayer, EquipmentSlot.MAINHAND);
                return ItemUtils.startUsingInstantly(pLevel, pPlayer, pHand);
            }

            }
        } else {

            var msg = MutableComponent.create(new TranslatableContents("tabakmod.iteminteraction.schachtel", null, new Object[0])).withStyle(ChatFormatting.GOLD);

            if(pPlayer instanceof ServerPlayer serverPlayer){

                serverPlayer.sendSystemMessage(msg, true);
            }

            return InteractionResult.FAIL; 
        }

        return InteractionResult.PASS;
    }

    @Override
    public ItemUseAnimation getUseAnimation(ItemStack pStack) { return ItemUseAnimation.BLOCK; }
}