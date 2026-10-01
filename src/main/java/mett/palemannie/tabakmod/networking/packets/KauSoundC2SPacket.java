package mett.palemannie.tabakmod.networking.packets;

import io.netty.buffer.ByteBuf;
import mett.palemannie.tabakmod.TabakMod;
import mett.palemannie.tabakmod.packetierung.ServerAbspieler;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record KauSoundC2SPacket() implements CustomPacketPayload {
    public static final Type<KauSoundC2SPacket> TYPE = new Type<>(Identifier.fromNamespaceAndPath(TabakMod.MODID, "kau_sound"));
    public static final StreamCodec<ByteBuf, KauSoundC2SPacket> STREAM_CODEC = StreamCodec.unit(new KauSoundC2SPacket());

    @Override
    public Type<KauSoundC2SPacket> type() { return TYPE; }

    public static void handle(KauSoundC2SPacket payload, IPayloadContext context) {
        if (context.player() instanceof ServerPlayer player && !player.isSpectator()) {
            ServerAbspieler.spieleKauSoundsAb(player);
        }
    }
}
