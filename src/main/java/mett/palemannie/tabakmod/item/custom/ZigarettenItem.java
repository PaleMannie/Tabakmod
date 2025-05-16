package mett.palemannie.tabakmod.item.custom;

import mett.palemannie.tabakmod.item.ModItems;
import mett.palemannie.tabakmod.sound.ModSounds;
import mett.palemannie.tabakmod.util.ModDamageTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.Set;


public class ZigarettenItem extends Item {

    public ZigarettenItem(Properties pProperties) { super(pProperties); }

//////////////////////////////////////////////////EIGENE METHODEN///////////////////////////////////////////////////////

    void paffe(Level level, Player player){

        level.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.PAFFEN.get(), SoundSource.PLAYERS, 1f, (float) RandomSource.create().nextInt(80, 120)/100);
        Vec3 MausPos = player.getEyePosition();
        Vec3 SchauWinkel = player.getLookAngle();
        level.addParticle(ParticleTypes.SMOKE,
                MausPos.x, MausPos.y-0.15d, MausPos.z,
                SchauWinkel.x/10, SchauWinkel.y/10, SchauWinkel.z/10);
    }

    void exhaliere(Level level, Player player, int wieVielRauchMussSein){

        Vec3 MausPos = player.getEyePosition();
        Vec3 SchauWinkel = player.getLookAngle();

        for(int i = wieVielRauchMussSein; i>=0; i--) {

            level.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE,
                    MausPos.x + RandomSource.create().nextFloat()/50,
                    MausPos.y - 0.2d + RandomSource.create().nextFloat()/50,
                    MausPos.z + RandomSource.create().nextFloat()/50,
                    (SchauWinkel.x / 20) + RandomSource.create().nextFloat()/50,
                    (SchauWinkel.y / 20) + RandomSource.create().nextFloat()/50,
                    (SchauWinkel.z / 20) + RandomSource.create().nextFloat()/50);
        }

        if (level instanceof ServerLevel slevel) {

            slevel.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, MausPos.x, MausPos.y-0.2d, MausPos.z, 2, 0.15d, 0d, 0.15d,0.02d);
        }
    }

    void gibRauchStandardEffekte(Player player, ItemStack stack, int gepaffteZeit){

        player.addEffect(new MobEffectInstance(MobEffects.NAUSEA,getUseDuration(stack, player)-gepaffteZeit+58,0));
        player.addEffect(new MobEffectInstance(MobEffects.STRENGTH,(24*(getUseDuration(stack,player)-gepaffteZeit))/10,0));
        player.addEffect(new MobEffectInstance(MobEffects.SATURATION,1,0));
    }

    void ueberzugsEffekte(Player player, Level level){

        if(level instanceof ServerLevel sevel){
            player.hurtServer(sevel, level.damageSources().source(ModDamageTypes.ZIG_SCHADEN), 2f);
        }

        player.playSound(ModSounds.ZU_LANGE_GEZOGEN.get(), 1f, (float) RandomSource.create().nextInt(8, 12)/10);
    }

    /////////////////////////////////////////////////////NUTZMETHODEN///////////////////////////////////////////////////////

    @Override
    public InteractionResult use(Level pLevel, @NotNull Player pPlayer, @NotNull InteractionHand pUsedHand) {

        RandomSource rdm = RandomSource.create();
        float lava = rdm.nextFloat();
        float r = (float) rdm.nextInt(8, 12) / 10;

        if (!pPlayer.isUnderWater()
                && (pPlayer.isOnFire()
                || pPlayer.isCreative()
                || pPlayer.getInventory().hasAnyOf(Set.of(Items.FLINT_AND_STEEL, Items.LAVA_BUCKET, Items.FIRE_CHARGE)))){

            if (pPlayer.isOnFire()) pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.BLAZE_AMBIENT, SoundSource.PLAYERS, 1f, r);
            if (pPlayer.isCreative()) pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), ModSounds.TABAKPRODUKT_ANZUENDEN.get(), SoundSource.PLAYERS, 1f, r);

            if (!pLevel.isClientSide()) {

                Inventory inv = pPlayer.getInventory();

                //Prioritätensetzung: 1. Feuerzeug, 2. Lavaeimer, 3. Feuerkugel
                boolean prio = false;

                for (int i = 0; i < inv.getContainerSize(); i++) {

                    ItemStack stack = inv.getItem(i);

                    if (stack.is(Items.FLINT_AND_STEEL)) {

                        pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), ModSounds.TABAKPRODUKT_ANZUENDEN.get(), SoundSource.PLAYERS, 1f, r);
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

                                pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.LAVA_EXTINGUISH, SoundSource.PLAYERS, 1f, r);
                                inv.setItem(i, new ItemStack(Items.BUCKET));
                            } else pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.BUCKET_FILL_LAVA, SoundSource.PLAYERS, 1f, r);

                            prio = true;
                            break;
                        }
                    }
                }

                if (!prio) {

                    int slot = inv.findSlotMatchingItem(new ItemStack(Items.FIRE_CHARGE));

                    if (slot != -1) {

                        pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.FIRECHARGE_USE, SoundSource.PLAYERS, 1f, r);
                        inv.removeItem(slot, 1);
                    }
                }
            }

            return ItemUtils.startUsingInstantly(pLevel, pPlayer, pUsedHand);

        } else return ItemStack.EMPTY.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {

        if(!pLivingEntity.isUnderWater()) {

            super.onUseTick(pLevel, pLivingEntity, pStack, pRemainingUseDuration);

            if (pLivingEntity instanceof Player pPlayer && (pRemainingUseDuration <= getUseDuration(pStack, pLivingEntity) - 15)) {

                if(pRemainingUseDuration % 5 == 0) exhalatZaehler++;
                pStack.hurtAndBreak(1, pPlayer, EquipmentSlot.MAINHAND);
                paffe(pLevel, pPlayer);

                ///Überziehen tut weh und macht Rauchprodukt schneller kaputt
                if(pRemainingUseDuration <= getUseDuration(pStack, pLivingEntity) - ueberzug){

                    pStack.hurtAndBreak(1, pPlayer, EquipmentSlot.MAINHAND);
                    if(pRemainingUseDuration % 10 == 0){
                        ueberzugsEffekte(pPlayer, pLevel);
                        exhaliere(pLevel, pPlayer, 1);
                    }
                }

                ///Wenn Haltbarkeit zu ende geht, gehe kaputt
                if (pStack.getDamageValue() >= pStack.getMaxDamage()) {

                    gibRauchStandardEffekte(pPlayer, pStack, pRemainingUseDuration);
                    pLevel.playSound(null, pLivingEntity.getX(), pLivingEntity.getY(), pLivingEntity.getZ(), ModSounds.FERTIG_GERAUCHT.get(), SoundSource.PLAYERS, 1f, (float)RandomSource.create().nextInt(8, 12)/10);
                    pPlayer.drop(new ItemStack(ModItems.ZIGARETTENSTUMMEL.get()), false);
                    releaseUsing(pStack, pLevel, pLivingEntity, pRemainingUseDuration);
                }

                if (pStack.getDamageValue() >= pStack.getMaxDamage()-1) {

                    exhaliere(pLevel, pPlayer, 10);
                }
            }
        } else releaseUsing(pStack, pLevel, pLivingEntity, pRemainingUseDuration);
    }

    @Override
    public boolean releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity, int pTimeCharged) {

        super.releaseUsing(pStack, pLevel, pLivingEntity, pTimeCharged);
        if(pLivingEntity instanceof Player pPlayer && (pTimeCharged <= getUseDuration(pStack, pLivingEntity) - 15)){

            exhaliere(pLevel,pPlayer, exhalatZaehler);
            gibRauchStandardEffekte(pPlayer, pStack, pTimeCharged);
            pLevel.playSound(null, pLivingEntity.getX(), pLivingEntity.getY(), pLivingEntity.getZ(), ModSounds.FERTIG_GERAUCHT.get(), SoundSource.PLAYERS, 1f, (float) RandomSource.create().nextInt(8,12)/10);
        }

        this.stopUsing(pLivingEntity);
        return false;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {

        super.finishUsingItem(pStack, pLevel, pLivingEntity);
        this.stopUsing(pLivingEntity);
        return pStack;
    }

    private void stopUsing(LivingEntity pUser) {

        if(pUser instanceof Player player){
            exhalatZaehler = 0;
            player.stopUsingItem();
            player.getCooldowns().addCooldown(ModItems.ZIGARETTE.getId(),2);
        }
    }

    //////////////////////////////////////////////////SONSTIGE METHODEN/////////////////////////////////////////////////////

    @Override
    public boolean isPiglinCurrency(ItemStack stack) { return true; }
    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) { return true; }
    @Override
    public int getEntityLifespan(ItemStack itemStack, Level level) {
        return 72000;
    }
    public int getUseDuration(ItemStack pStack, LivingEntity pEntity) {
        return 199;
    }
    public ItemUseAnimation getUseAnimation(ItemStack pStack) {
        return ItemUseAnimation.BOW;
    }
    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) { return slotChanged; }
    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlot armorType, Entity entity) { return true; }
    int ueberzug = 59;
    int exhalatZaehler = 0;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
