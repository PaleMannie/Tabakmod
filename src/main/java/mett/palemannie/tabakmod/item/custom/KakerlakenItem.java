package mett.palemannie.tabakmod.item.custom;

import mett.palemannie.tabakmod.sound.ModSounds;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class KakerlakenItem extends Item {
    public KakerlakenItem(Properties pProperties) {
        super(pProperties);
    }
////////////////////////////////////////////////////EIGENE METHODEN/////////////////////////////////////////////////////
    void gibEffekt(Player player){
        player.getFoodData().eat(1, 1);

        player.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 500, 0));
        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 500, 0));
        player.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 250, 0));
        player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0));
        player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 50, 0));
    }

    void exhaliere(Level level, Player player){
        player.playSound(ModSounds.DSCHOINT.get(), 1f, 3f);

        RandomSource rdm = RandomSource.create();
        float r = (float)rdm.nextInt(9,11)/10;
        level.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.PAFFEN.get(), SoundSource.PLAYERS, 1f, r);
        Vec3 MausPos = player.getEyePosition();
        Vec3 SchauWinkel = player.getLookAngle();
        level.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,true,
                MausPos.x, MausPos.y-0.2d, MausPos.z,
                SchauWinkel.x/20, SchauWinkel.y/20, SchauWinkel.z/20);
        if (level instanceof ServerLevel slevel) {
            slevel.sendParticles(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, MausPos.x, MausPos.y-0.2d, MausPos.z, 100, 0.15d, 0d, 0.15d,0.05d);
        }
    }
////////////////////////////////////////////////////NUTZMETHODEN////////////////////////////////////////////////////////
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        return ItemUtils.startUsingInstantly(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity, int pTimeCharged) {
        this.stopUsing(pLivingEntity);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if(pLivingEntity instanceof Player player) {
            gibEffekt(player);
            exhaliere(pLevel, player);
            if(!((Player) pLivingEntity).isCreative()){
                pStack.shrink(1);
            }

        }
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }
    private void stopUsing(LivingEntity pUser) {
        if (pUser instanceof Player player) {
            player.getCooldowns().addCooldown(this, 2);
        }
    }
////////////////////////////////////////////////////SONSTIGE METHODEN///////////////////////////////////////////////////
    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
    return UseAnim.EAT;
}

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) { return slotChanged; }

    @Override
    public int getEntityLifespan(ItemStack itemStack, Level level) {
        return 72000;
    }

    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlot armorType, Entity entity) {
        return true;
    }

    public int getUseDuration(ItemStack pStack) {
        return 20;
    }
}
