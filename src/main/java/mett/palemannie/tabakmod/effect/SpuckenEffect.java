package mett.palemannie.tabakmod.effect;

import mett.palemannie.spittingimage.network.ServerPlayHandler;
import mett.palemannie.tabakmod.packetierung.ServerAbspieler;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class SpuckenEffect extends MobEffect {
    public SpuckenEffect(MobEffectCategory category, int colour) {
        super(category, colour);
    }

    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
        if (entity instanceof ServerPlayer player) {
            // MobEffect instances are shared: keep the cadence individual to each player.
            if (player.tickCount % 80 == 0) {
                ServerPlayHandler.handleSpitting(player);
            }
            if (player.tickCount % 25 == 0) {
                ServerAbspieler.spieleKauSoundsAb(player);
            }
        }
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
