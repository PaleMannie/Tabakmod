package mett.palemannie.tabakmod.item.custom;

import mett.palemannie.tabakmod.item.ModItems;
import mett.palemannie.tabakmod.sound.ModSounds;
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


public class ScheisZigarettenItem extends Item {
    public ScheisZigarettenItem(Properties pProperties) { super(pProperties); }
////////////////////////////////////////////////EIGENE METHODEN////////////////////////////////////////////////////////////////////////
    void paffe(Level level, Player player){
            RandomSource rdm = RandomSource.create();
            float r = (float)rdm.nextInt(2,18)/10;
            level.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.PAFFEN.get(), SoundSource.PLAYERS, 1f, r);
        Vec3 MausPos = player.getEyePosition();
        Vec3 SchauWinkel = player.getLookAngle();
        level.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE,
                MausPos.x, MausPos.y-0.15d, MausPos.z,
                SchauWinkel.x/10, SchauWinkel.y/10, SchauWinkel.z/10);
        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,4,2));
        player.addEffect(new MobEffectInstance(MobEffects.HARM,1,0));
    }
    void exhaliere(Level level, Player player){
            RandomSource rdm = RandomSource.create();
            float r = (float)rdm.nextInt(7,13)/10;
            level.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.PAFFEN.get(), SoundSource.PLAYERS, 1f, r);
        Vec3 MausPos = player.getEyePosition();
        Vec3 SchauWinkel = player.getLookAngle();
        level.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,
                MausPos.x, MausPos.y-0.2d, MausPos.z,
                SchauWinkel.x/20, SchauWinkel.y/20, SchauWinkel.z/20);
        if (level instanceof ServerLevel slevel) {
            slevel.sendParticles(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, MausPos.x, MausPos.y-0.2d, MausPos.z, 5, 0.15d, 0d, 0.15d,0.02d);
            }
        }
    void gibRauchStandardEffekte(Player player){
        player.addEffect(new MobEffectInstance(MobEffects.HARM,1,0));
        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,100,3));
        player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS,100,0));
        player.addEffect(new MobEffectInstance(MobEffects.DARKNESS,100,0));
    }

    void gibZuLangesZiehenEffekte(Player player){
        player.addEffect(new MobEffectInstance(MobEffects.HARM,1,2));
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
            if (pLivingEntity instanceof Player pPlayer && (pRemainingUseDuration <= getUseDuration(pStack, pLivingEntity) - 12)) {
                paffe(pLevel, pPlayer);

                pStack.hurtAndBreak(1, pPlayer, EquipmentSlot.MAINHAND);

                if (pStack.getDamageValue() >= pStack.getMaxDamage() - 1) {
                    gibRauchStandardEffekte(pPlayer);
                    gibZuLangesZiehenEffekte(pPlayer);
                    RandomSource rdm = RandomSource.create();
                    float r = (float) rdm.nextInt(8, 12) / 10;
                    pPlayer.playSound(ModSounds.SCHEISE_GERAUCHT.get(), 1f, r);
                    exhaliere(pLevel, pPlayer);
                    pPlayer.drop(new ItemStack(ModItems.ZIGARETTENSTUMMEL.get()), false);
                }
            }
        } else releaseUsing(pStack, pLevel, pLivingEntity, pRemainingUseDuration);
    }

    @Override
    public boolean releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity, int pTimeCharged) {
        super.releaseUsing(pStack, pLevel, pLivingEntity, pTimeCharged);
        if(pLivingEntity instanceof Player pPlayer && (pTimeCharged <= getUseDuration(pStack, pLivingEntity) - 12)) {
            gibRauchStandardEffekte(pPlayer);
            exhaliere(pLevel, pPlayer);
            RandomSource rdm = RandomSource.create();
            float r = (float) rdm.nextInt(8, 12) / 10;
            pLevel.playSound(null, pLivingEntity.getX(), pLivingEntity.getY(), pLivingEntity.getZ(), ModSounds.SCHEISE_GERAUCHT.get(), SoundSource.PLAYERS, 1f, r);
        }
        this.stopUsing(pLivingEntity);
        return false;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        super.finishUsingItem(pStack, pLevel, pLivingEntity);
        RandomSource rdm = RandomSource.create();
         float r = (float)rdm.nextInt(8,12)/10;
         pLevel.playSound(null, pLivingEntity.getX(), pLivingEntity.getY(), pLivingEntity.getZ(), ModSounds.SCHEISE_GERAUCHT.get(), SoundSource.PLAYERS, 2f, r);
             gibZuLangesZiehenEffekte((Player)pLivingEntity);
             exhaliere(pLevel,(Player)pLivingEntity);
         this.stopUsing(pLivingEntity);
        return pStack;
        }
    private void stopUsing(LivingEntity pUser) {
        if(pUser instanceof Player player){
            player.stopUsingItem();
            player.getCooldowns().addCooldown(ModItems.ZIGARETTE_SCHEISE.getId(), 2);
        }
    }
////////////////////////////////////////////////////SONSTIGE METHODEN////////////////////////////////////////////////////////////////////
    @Override
    public int getEntityLifespan(ItemStack itemStack, Level level) { return 72000; }
    public int getUseDuration(ItemStack pStack, LivingEntity pEntity) { return 51; }
    public ItemUseAnimation getUseAnimation(ItemStack pStack) { return ItemUseAnimation.BOW; }
    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) { return slotChanged; }
    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlot armorType, Entity entity) { return true; }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
