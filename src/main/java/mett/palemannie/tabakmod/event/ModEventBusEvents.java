package mett.palemannie.tabakmod.event;

import mett.palemannie.tabakmod.TabakMod;
import mett.palemannie.tabakmod.entity.client.RaketenZigrrModel;
import mett.palemannie.tabakmod.entity.client.SpuckeModel;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TabakMod.MODID/*, bus = Mod.EventBusSubscriber.Bus.MOD*/)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {

        event.registerLayerDefinition(RaketenZigrrModel.LAYER_LOCATION, RaketenZigrrModel::createBodyLayer);
        event.registerLayerDefinition(SpuckeModel.LAYER_LOCATION, SpuckeModel::createBodyLayer);
    }
}
