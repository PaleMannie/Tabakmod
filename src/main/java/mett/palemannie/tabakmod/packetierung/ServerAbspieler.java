package mett.palemannie.tabakmod.packetierung;

import mett.palemannie.tabakmod.entity.custom.SpuckeEntity;
import mett.palemannie.tabakmod.item.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class ServerAbspieler {
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void handliereSpucken(ServerPlayer player){

        ServerLevel sevel = player.serverLevel();
        RandomSource rdm = RandomSource.create();

        //Entität
        SpuckeEntity spucke = new SpuckeEntity(sevel, player, ModItems.SPUCKE.get().getDefaultInstance());
        float re = (float)rdm.nextInt(4500,5000)/10000;
        float ye = player.getYRot();
        float xe = player.getXRot();
        float ze = 0f;
        spucke.shootFromRotation(player, xe, ye, ze, re, 1f);
        sevel.addFreshEntity(spucke);

        //Ton
        Level lvl = player.level();

        double posX = player.getX();
        double posY = player.getY();
        double posZ = player.getZ();
        float r = 0.8f + lvl.random.nextFloat() * 0.3f;

        lvl.playSound(null, posX, posY, posZ, SoundEvents.LLAMA_SPIT, SoundSource.BLOCKS, 1f, r);

        //Partikel
        Vec3 vec3 = player.getViewVector(1f);
        Vec3 MausPos = player.getEyePosition();
        Vec3 SchauWinkel = player.getLookAngle();

        double x = player.getX() + vec3.x/4;
        double y = MausPos.y + vec3.y/4;
        double z = player.getZ() + vec3.z/4;

        if(lvl instanceof ServerLevel slevel) {
            slevel.sendParticles(ParticleTypes.SPIT, x, y, z, 3, 0d, 0d, 0d,0.15d);
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
