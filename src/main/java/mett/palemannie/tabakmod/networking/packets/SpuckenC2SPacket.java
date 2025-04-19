package mett.palemannie.tabakmod.networking.packets;

import mett.palemannie.tabakmod.packetierung.ServerAbspieler;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.network.CustomPayloadEvent;

public class SpuckenC2SPacket {
    public SpuckenC2SPacket(){
    }
    public SpuckenC2SPacket(FriendlyByteBuf buf){
    }
    public void encode(FriendlyByteBuf buf){
    }

    public boolean handle(CustomPayloadEvent.Context context){
        context.enqueueWork(()-> {
            ServerPlayer player = context.getSender();

            if(player == null) return;
            if(player.isSpectator()) return;

            ServerAbspieler.handliereSpucken(player);

        });
        return true;
    }
}