package mett.palemannie.tabakmod.item.custom;

import mett.palemannie.tabakmod.item.ModItems;
import mett.palemannie.tabakmod.util.ModDamageTypes;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.Set;

public class SuizidZigarettenItem extends Item {

    public SuizidZigarettenItem(Properties pProperties) { super(pProperties); }

    @Override
    public InteractionResult use(Level pLevel, Player pPlayer, InteractionHand pHand) {

        float lava = RandomSource.create().nextFloat();

        if (!pPlayer.isUnderWater()
                && (pPlayer.isOnFire()
                || pPlayer.isCreative()
                || pPlayer.getInventory().hasAnyOf(Set.of(Items.FLINT_AND_STEEL, Items.LAVA_BUCKET, Items.FIRE_CHARGE)))){

            if (pPlayer.isOnFire()) pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.TNT_PRIMED, SoundSource.PLAYERS, 1f, 1f);
            if (pPlayer.isCreative()) pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.TNT_PRIMED, SoundSource.PLAYERS, 1f, 1f);

            if (!pLevel.isClientSide()) {

                Inventory inv = pPlayer.getInventory();

                //Prioritätensetzung: 1. Feuerzeug, 2. Lavaeimer, 3. Feuerkugel
                boolean prio = false;

                for (int i = 0; i < inv.getContainerSize(); i++) {

                    ItemStack stack = inv.getItem(i);

                    if (stack.is(Items.FLINT_AND_STEEL)) {

                        pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.TNT_PRIMED, SoundSource.PLAYERS, 1f, 1f);
                        stack.hurtAndBreak(1, pPlayer, EquipmentSlot.MAINHAND);
                        prio = true;
                        break;
                    }
                }

                if (!prio) {

                    for (int i = 0; i < inv.getContainerSize(); i++) {

                        ItemStack stack = inv.getItem(i);

                        if (stack.is(Items.LAVA_BUCKET)) {

                            if (lava < 0.10f) {

                                pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.TNT_PRIMED, SoundSource.PLAYERS, 1f, 1f);
                                inv.setItem(i, new ItemStack(Items.BUCKET));
                            } else pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.TNT_PRIMED, SoundSource.PLAYERS, 1f, 1f);

                            prio = true;
                            break;
                        }
                    }
                }

                if (!prio) {

                    int slot = inv.findSlotMatchingItem(new ItemStack(Items.FIRE_CHARGE));

                    if (slot != -1) {

                        pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.TNT_PRIMED, SoundSource.PLAYERS, 1f, 1f);
                        inv.removeItem(slot, 1);
                    }
                }
            }

            return ItemUtils.startUsingInstantly(pLevel, pPlayer, pHand);

        } else return ItemStack.EMPTY.use(pLevel, pPlayer, pHand);
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {

        if(pRemainingUseDuration % 5 == 0) tntschadenzaehler++;

        Vec3 MausPos = pLivingEntity.getEyePosition();
        Vec3 SchauWinkel = pLivingEntity.getLookAngle();
        pLevel.addParticle(ParticleTypes.SMOKE,
                MausPos.x, MausPos.y-0.15d, MausPos.z,
                SchauWinkel.x/10, SchauWinkel.y/10, SchauWinkel.z/10);
    }

    @Override
    public boolean releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pEntity, int pTimeLeft) {

        pLevel.explode(null, pLevel.damageSources().source(ModDamageTypes.SUIZIDZIGARETTE_SCHADEN),
                new ExplosionDamageCalculator(),
                pEntity.getX(),
                pEntity.getEyeY(),
                pEntity.getZ(),
                (float) (pStack.getUseDuration(pEntity) - pTimeLeft)/10,
                false,
                Level.ExplosionInteraction.TNT);

        if(pEntity instanceof Player player && !player.isCreative()){
            pStack.shrink(1);
            player.stopUsingItem();
            player.getCooldowns().addCooldown(ModItems.SUIZIDZIGARETTE.get().getDefaultInstance(), 5);
        }

        if(pLevel instanceof ServerLevel sevel && pEntity instanceof Player player){
            player.hurtServer(sevel, pLevel.damageSources().source(ModDamageTypes.SUIZIDZIGARETTE_SCHADEN), tntschadenzaehler);
            tntschadenzaehler = 0f;
        }

        return false;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {

        pLevel.explode(null, pLevel.damageSources().source(ModDamageTypes.SUIZIDZIGARETTE_SCHADEN),
                new ExplosionDamageCalculator(),
                pLivingEntity.getX(),
                pLivingEntity.getEyeY(),
                pLivingEntity.getZ(),
                8f,
                false,
                Level.ExplosionInteraction.TNT);

        if(pLivingEntity instanceof Player player && !player.isCreative()){
            pStack.shrink(1);
            player.getCooldowns().addCooldown(ModItems.SUIZIDZIGARETTE.get().getDefaultInstance(), 5);
        }

        if(pLevel instanceof ServerLevel sevel && pLivingEntity instanceof Player player){
            player.hurtServer(sevel, pLevel.damageSources().source(ModDamageTypes.SUIZIDZIGARETTE_SCHADEN), 32f);
        }

        tntschadenzaehler = 0f;

        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }


    @Override
    public boolean isPiglinCurrency(ItemStack stack) { return true; }
    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) { return true; }
    @Override
    public ItemUseAnimation getUseAnimation(ItemStack pStack) { return ItemUseAnimation.BOW; }

    float tntschadenzaehler = 0f;

    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlot armorType, Entity entity) { return true; }

    @Override
    public int getUseDuration(ItemStack pStack, LivingEntity pEntity) { return 80; }
}
