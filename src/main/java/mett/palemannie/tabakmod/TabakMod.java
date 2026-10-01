package mett.palemannie.tabakmod;

import com.mojang.logging.LogUtils;
import mett.palemannie.tabakmod.block.ModBlocks;
import mett.palemannie.tabakmod.effect.ModEffects;
import mett.palemannie.tabakmod.entity.ModEntities;
import mett.palemannie.tabakmod.entity.client.RaketenZigrrRenderer;
import mett.palemannie.tabakmod.item.ModCreativeModeTabs;
import mett.palemannie.tabakmod.item.ModItems;
import mett.palemannie.tabakmod.loot.ModLootModifiers;
import mett.palemannie.tabakmod.networking.ModMessages;
import mett.palemannie.tabakmod.sound.ModSounds;
import mett.palemannie.tabakmod.villager.ModVillagers;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.common.EventBusSubscriber;
import org.slf4j.Logger;


@Mod(TabakMod.MODID)
public class TabakMod {

    public static final String MODID = "tabakmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public TabakMod(IEventBus modBus, ModContainer container) {

        modBus.addListener(ModMessages::register);

        ModItems.register(modBus);
        ModBlocks.register(modBus);
        ModLootModifiers.register(modBus);
        ModVillagers.register(modBus);
        ModSounds.register(modBus);
        ModEffects.register(modBus);
        ModEntities.register(modBus);
        ModCreativeModeTabs.register(modBus);
    }

    @EventBusSubscriber(modid = MODID, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {

            event.registerEntityRenderer(ModEntities.STUMMEL.get(), ThrownItemRenderer::new);
            event.registerEntityRenderer(ModEntities.STUMMEL_KAMEL.get(), ThrownItemRenderer::new);
            event.registerEntityRenderer(ModEntities.STUMMEL_MENTHOL.get(), ThrownItemRenderer::new);
            event.registerEntityRenderer(ModEntities.STUMMEL_ZIGRR.get(), ThrownItemRenderer::new);
            event.registerEntityRenderer(ModEntities.RAKETENZIGRR.get(), RaketenZigrrRenderer::new);
        }
    }
}
