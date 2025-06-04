package mett.palemannie.tabakmod.packetierung;

import mett.palemannie.tabakmod.entity.custom.SpuckeEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;

public class ServerAbspieler {

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void handliereSpucken(ServerPlayer player){

        ServerLevel sevel = player.serverLevel();
        RandomSource rdm = RandomSource.create();
        Level lvl = player.level();

        //Entität
        SpuckeEntity spucke = new SpuckeEntity(lvl, player);
        float re = rdm.nextInt(4500,5000)/10000f;
        float ye = player.getYRot();
        float xe = player.getXRot();
        float ze = 0f;
        spucke.shootFromRotation(player, xe, ye, ze, re, 1f);
        sevel.addFreshEntity(spucke);

        //Ton
        double posX = player.getX();
        double posY = player.getY();
        double posZ = player.getZ();
        float r = 0.8f + lvl.random.nextFloat() * 0.3f;
        lvl.playSound(null, posX, posY, posZ, SoundEvents.LLAMA_SPIT, SoundSource.BLOCKS, 1f, r);
    }

    public static void spieleKauSoundsAb(ServerPlayer player){

        Level lvl = player.level();

        lvl.playSound(null, player.getX(), player.getEyeY(), player.getZ(), SoundEvents.SLIME_JUMP, SoundSource.BLOCKS, 0.5f, RandomSource.create().nextInt(8,12)/10f);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
