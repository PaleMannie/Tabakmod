package mett.palemannie.tabakmod.event;

import mett.palemannie.tabakmod.TabakMod;
import mett.palemannie.tabakmod.entity.client.RaketenZigrrModel;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber(modid = TabakMod.MODID, value = net.neoforged.api.distmarker.Dist.CLIENT)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {

        event.registerLayerDefinition(RaketenZigrrModel.LAYER_LOCATION, RaketenZigrrModel::createBodyLayer);
    }
}
