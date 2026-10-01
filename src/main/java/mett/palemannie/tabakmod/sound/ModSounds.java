package mett.palemannie.tabakmod.sound;

import net.minecraft.core.registries.Registries;
import mett.palemannie.tabakmod.TabakMod;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(Registries.SOUND_EVENT, TabakMod.MODID);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static final DeferredHolder<SoundEvent, SoundEvent> TABAKPRODUKT_ANZUENDEN = registerSoundEvent("tabakprodukt_anzuenden");
    public static final DeferredHolder<SoundEvent, SoundEvent> PAFFEN = registerSoundEvent("paffen");
    public static final DeferredHolder<SoundEvent, SoundEvent> FERTIG_GERAUCHT = registerSoundEvent("fertig_geraucht");
    public static final DeferredHolder<SoundEvent, SoundEvent> ZU_LANGE_GEZOGEN = registerSoundEvent("zu_lange_gezogen");
    public static final DeferredHolder<SoundEvent, SoundEvent> PFEIFE_LADEN = registerSoundEvent("pfeife_laden");
    public static final DeferredHolder<SoundEvent, SoundEvent> SCHEISE_GERAUCHT = registerSoundEvent("scheise_geraucht");
    public static final DeferredHolder<SoundEvent, SoundEvent> DSCHOINT = registerSoundEvent("dschoint");
    public static final DeferredHolder<SoundEvent, SoundEvent> SLON = registerSoundEvent("slon");
    public static final DeferredHolder<SoundEvent, SoundEvent> MWTM = registerSoundEvent("mwtm");
    public static final DeferredHolder<SoundEvent, SoundEvent> SCHEISE_ANZUENDEN = registerSoundEvent("scheise_anzuenden");
    public static final DeferredHolder<SoundEvent, SoundEvent> SCHEISE_PAFFEN = registerSoundEvent("scheise_paffen");


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static DeferredHolder<SoundEvent, SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath(TabakMod.MODID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}