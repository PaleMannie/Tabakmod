package mett.palemannie.tabakmod.networking;

import mett.palemannie.tabakmod.networking.packets.KauSoundC2SPacket;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

public class ModMessages {
    public static void register(RegisterPayloadHandlersEvent event) {

        PayloadRegistrar registrar = event.registrar("1");

        registrar.playToServer(KauSoundC2SPacket.TYPE, KauSoundC2SPacket.STREAM_CODEC, KauSoundC2SPacket::handle);
    }
}
