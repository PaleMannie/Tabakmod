package mett.palemannie.tabakmod.item.custom;

import mett.palemannie.tabakmod.item.ModItems;
import mett.palemannie.tabakmod.sound.ModSounds;
import mett.palemannie.tabakmod.util.ModDamageTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
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
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;


public class DschointItem extends Item {
    public DschointItem(Properties pProperties) { super(pProperties); }
////////////////////////////////////////////////EIGENE METHODEN////////////////////////////////////////////////////////////////////////
    void paffe(Level level, Player player){
            RandomSource rdm = RandomSource.create();
            float r = (float)rdm.nextInt(1,19)/10;
            level.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.PAFFEN.get(), SoundSource.PLAYERS, 1f, r);
        Vec3 MausPos = player.getEyePosition();
        Vec3 SchauWinkel = player.getLookAngle();
        level.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE,
                MausPos.x, MausPos.y-0.15d, MausPos.z,
                SchauWinkel.x/10, SchauWinkel.y/10, SchauWinkel.z/10);
    }
    void exhaliere(Level level, Player player){
            RandomSource rdm = RandomSource.create();
            float r = (float)rdm.nextInt(9,11)/10;
            level.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.PAFFEN.get(), SoundSource.PLAYERS, 1f, r);
        Vec3 MausPos = player.getEyePosition();
        Vec3 SchauWinkel = player.getLookAngle();
        level.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,
                MausPos.x, MausPos.y-0.2d, MausPos.z,
                SchauWinkel.x/20, SchauWinkel.y/20, SchauWinkel.z/20);
        if (level instanceof ServerLevel slevel) {
            slevel.sendParticles(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, MausPos.x, MausPos.y-0.2d, MausPos.z, 50, 0.15d, 0d, 0.15d,0.02d);
            }
        }
    void gibRauchStandardEffekte(Player player, ItemStack stack, int gepaffteZeit){
        player.addEffect(new MobEffectInstance(MobEffects.MINING_FATIGUE, (getUseDuration(stack, player)-gepaffteZeit)*10,0));
        player.addEffect(new MobEffectInstance(MobEffects.SLOWNESS,(getUseDuration(stack, player)-gepaffteZeit)*10,0));
        player.addEffect(new MobEffectInstance(MobEffects.LEVITATION,10+(getUseDuration(stack, player)-gepaffteZeit)/2,0));
        player.addEffect(new MobEffectInstance(MobEffects.NAUSEA,98+(getUseDuration(stack, player)-gepaffteZeit)*2,0));
        player.addEffect(new MobEffectInstance(MobEffects.DARKNESS,(getUseDuration(stack, player)-gepaffteZeit)*2,0));
    }

    void gibZuLangesZiehenEffekte(Player player, Level level){
        player.addEffect(new MobEffectInstance(MobEffects.MINING_FATIGUE,1020,1));
        player.addEffect(new MobEffectInstance(MobEffects.SLOWNESS,1020,0));
        player.addEffect(new MobEffectInstance(MobEffects.LEVITATION,70,0));
        player.addEffect(new MobEffectInstance(MobEffects.NAUSEA,300,0));
        player.addEffect(new MobEffectInstance(MobEffects.DARKNESS,210,0));
        if(level instanceof ServerLevel sevel){
            player.hurtServer(sevel, level.damageSources().source(ModDamageTypes.DSCHOINT_SCHADEN), 2f);
        }
    }
/// /////////////////////////////////////////////NUTZMETHODEN////////////////////////////////////////////////////////////////////////
    @Override
    public InteractionResult use(Level pLevel, @NotNull Player pPlayer, @NotNull InteractionHand pUsedHand) {
        if(!pPlayer.isUnderWater()) {
            RandomSource rdm = RandomSource.create();
            float r = (float) rdm.nextInt(8, 12) / 10;
            pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), ModSounds.TABAKPRODUKT_ANZUENDEN.get(), SoundSource.PLAYERS, 1f, r);
            return ItemUtils.startUsingInstantly(pLevel, pPlayer, pUsedHand);
        } else return ItemStack.EMPTY.use(pLevel, pPlayer, pUsedHand);
    }
    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
        if(!pLivingEntity.isUnderWater()) {
            super.onUseTick(pLevel, pLivingEntity, pStack, pRemainingUseDuration);
            if (pLivingEntity instanceof Player pPlayer && (pRemainingUseDuration <= getUseDuration(pStack,pLivingEntity) - 15)) {
                if (pRemainingUseDuration % 4 == 0) {
                    paffe(pLevel, pPlayer);
                }
                pStack.hurtAndBreak(1, pPlayer, EquipmentSlot.MAINHAND);
                if (pStack.getDamageValue() >= pStack.getMaxDamage() - 1) {
                    gibRauchStandardEffekte(pPlayer, pStack, pRemainingUseDuration);
                    RandomSource rdm = RandomSource.create();
                    float r = (float) rdm.nextInt(9, 11) / 10;
                    pPlayer.playSound(ModSounds.DSCHOINT.get(), 1f, r);
                    exhaliere(pLevel, pPlayer);
                    pPlayer.drop(new ItemStack(ModItems.KAKERLAKE.get()), false);
                }
            }
        } else releaseUsing(pStack, pLevel, pLivingEntity, pRemainingUseDuration);
    }

    @Override
    public boolean releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity, int pTimeCharged) {
        super.releaseUsing(pStack, pLevel, pLivingEntity, pTimeCharged);
        if (pLivingEntity instanceof Player pPlayer && (pTimeCharged <= getUseDuration(pStack, pLivingEntity) - 15)) {
            gibRauchStandardEffekte(pPlayer, pStack, pTimeCharged);
            exhaliere(pLevel, pPlayer);
            RandomSource rdm = RandomSource.create();
            float r = (float) rdm.nextInt(9, 11) / 10;
            pLevel.playSound(null, pLivingEntity.getX(), pLivingEntity.getY(), pLivingEntity.getZ(), ModSounds.DSCHOINT.get(), SoundSource.PLAYERS, 1f, r);
        }
        this.stopUsing(pLivingEntity);
        return false;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        super.finishUsingItem(pStack, pLevel, pLivingEntity);
        RandomSource rdm = RandomSource.create();
         float r = (float)rdm.nextInt(9,11)/10;
            pLevel.playSound(null, pLivingEntity.getX(), pLivingEntity.getY(), pLivingEntity.getZ(), ModSounds.ZU_LANGE_GEZOGEN.get(), SoundSource.PLAYERS, 1f, r);
            pLevel.playSound(null, pLivingEntity.getX(), pLivingEntity.getY(), pLivingEntity.getZ(), ModSounds.DSCHOINT.get(), SoundSource.PLAYERS, 2f, r);
            gibZuLangesZiehenEffekte((Player)pLivingEntity, pLevel);
            exhaliere(pLevel,(Player)pLivingEntity);
         this.stopUsing(pLivingEntity);
        return pStack;
        }
    private void stopUsing(LivingEntity pUser) {
        if(pUser instanceof Player player){
            player.stopUsingItem();
            player.getCooldowns().addCooldown(ModItems.DSCHOINT.getId(),2);
        }
    }
////////////////////////////////////////////////////SONSTIGE METHODEN////////////////////////////////////////////////////////////////////
    @Override
    public int getEntityLifespan(ItemStack itemStack, Level level) { return 72000; }
    public int getUseDuration(ItemStack pStack, LivingEntity pEntity) { return 200; }
    @Override
    public ItemUseAnimation getUseAnimation(ItemStack p_41452_) { return ItemUseAnimation.BOW; }
    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) { return slotChanged; }
    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlot armorType, Entity entity) { return true; }
    int ueberzug = 99;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
