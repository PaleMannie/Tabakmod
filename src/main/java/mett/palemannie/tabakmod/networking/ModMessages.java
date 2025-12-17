package mett.palemannie.tabakmod.networking;

import mett.palemannie.tabakmod.TabakMod;
import mett.palemannie.tabakmod.networking.packets.KauSoundC2SPacket;
import mett.palemannie.tabakmod.networking.packets.SpuckenC2SPacket;
import net.minecraft.resources.Identifier;
import net.minecraftforge.network.*;

public class ModMessages {
    private static int PacketID = 0;
    private static int id(){
        return PacketID++;
    }
    final static int version = 1;

    private static final SimpleChannel INSTANCE = ChannelBuilder.named(Identifier.fromNamespaceAndPath(TabakMod.MODID, "messages"))
            .networkProtocolVersion(version)
            .clientAcceptedVersions(((status, version1) -> true))
            .serverAcceptedVersions(((status, version1) -> true))
            .simpleChannel();

    public static void register(){
        INSTANCE.messageBuilder(SpuckenC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(SpuckenC2SPacket::new)
                .encoder(SpuckenC2SPacket::encode)
                .consumerMainThread(SpuckenC2SPacket::handle)
                .add();

        INSTANCE.messageBuilder(KauSoundC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(KauSoundC2SPacket::new)
                .encoder(KauSoundC2SPacket::encode)
                .consumerMainThread(KauSoundC2SPacket::handle)
                .add();
    }

    public static void sendToServer(Object message){
        INSTANCE.send(message, PacketDistributor.SERVER.noArg());
    }

}