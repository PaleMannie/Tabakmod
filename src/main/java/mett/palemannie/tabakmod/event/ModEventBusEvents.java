package mett.palemannie.tabakmod.event;

import mett.palemannie.tabakmod.TabakMod;
import mett.palemannie.tabakmod.entity.client.RaketenZigrrModel;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TabakMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(RaketenZigrrModel.LAYER_LOCATION, RaketenZigrrModel::createBodyLayer);
    }
}
