package mett.palemannie.tabakmod.effect;

import mett.palemannie.tabakmod.networking.ModMessages;
import mett.palemannie.tabakmod.networking.packets.KauSoundC2SPacket;
import mett.palemannie.tabakmod.networking.packets.SpuckenC2SPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class SpuckenEffect extends MobEffect {
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public SpuckenEffect(MobEffectCategory mobEffectCategory, int colour){
        super(mobEffectCategory, colour);
    }
    int basis = 80;
    int counter = basis;
    void resetCounter(int c){
        c = counter = basis;
    }
    int basis2 = 25;
    int counter2 = basis2;
    void resetCounter2(int c) { c = counter2 = basis2; }

    @Override
    public boolean applyEffectTick(ServerLevel sLevel, LivingEntity pLivingEntity, int pAmplifier) {
        if(!pLivingEntity.level().isClientSide()) {
            counter--;
            counter2--;
            if ((counter % basis == 0)) {
                pLivingEntity.playSound(SoundEvents.SLIME_ATTACK, 0.5f, 1f);
                ModMessages.sendToServer(new SpuckenC2SPacket());
                resetCounter(counter);
            }
            if ((counter2 % basis2 == 0)) {
                ModMessages.sendToServer(new KauSoundC2SPacket());
                resetCounter2(counter2);
            }
        }
        //super.applyEffectTick(sLevel, pLivingEntity, pAmplifier);
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int p_297908_, int p_301085_) { return true; }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
