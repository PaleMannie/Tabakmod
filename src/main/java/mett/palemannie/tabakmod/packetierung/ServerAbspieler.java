package mett.palemannie.tabakmod.packetierung;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;

public class ServerAbspieler {

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void spieleKauSoundsAb(ServerPlayer player){

        Level lvl = player.level();

        lvl.playSound(null, player.getX(), player.getEyeY(), player.getZ(), SoundEvents.SLIME_JUMP, SoundSource.BLOCKS, 0.5f, RandomSource.create().nextInt(8,12)/10f);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
