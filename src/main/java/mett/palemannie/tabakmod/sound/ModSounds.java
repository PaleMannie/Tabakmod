package mett.palemannie.tabakmod.sound;

import mett.palemannie.tabakmod.TabakMod;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TabakMod.MODID);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static final RegistryObject<SoundEvent> TABAKPRODUKT_ANZUENDEN = registerSoundEvent("tabakprodukt_anzuenden");
    public static final RegistryObject<SoundEvent> PAFFEN = registerSoundEvent("paffen");
    public static final RegistryObject<SoundEvent> FERTIG_GERAUCHT = registerSoundEvent("fertig_geraucht");
    public static final RegistryObject<SoundEvent> ZU_LANGE_GEZOGEN = registerSoundEvent("zu_lange_gezogen");
    public static final RegistryObject<SoundEvent> PFEIFE_LADEN = registerSoundEvent("pfeife_laden");
    public static final RegistryObject<SoundEvent> SCHEISE_GERAUCHT = registerSoundEvent("scheise_geraucht");
    public static final RegistryObject<SoundEvent> DSCHOINT = registerSoundEvent("dschoint");
    public static final RegistryObject<SoundEvent> SLON = registerSoundEvent("slon");
    public static final RegistryObject<SoundEvent> MWTM = registerSoundEvent("mwtm");
    public static final RegistryObject<SoundEvent> SCHEISE_ANZUENDEN = registerSoundEvent("scheise_anzuenden");
    public static final RegistryObject<SoundEvent> SCHEISE_PAFFEN = registerSoundEvent("scheise_paffen");


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath(TabakMod.MODID, name)));
    }

    public static void register(BusGroup eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}