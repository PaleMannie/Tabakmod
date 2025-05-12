package mett.palemannie.tabakmod.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class SuizidZigarettenItem extends Item {

    public SuizidZigarettenItem(Properties pProperties) { super(pProperties); }

    @Override
    public int getUseDuration(ItemStack pStack, LivingEntity pEntity) {
        return 80;
    }
}
