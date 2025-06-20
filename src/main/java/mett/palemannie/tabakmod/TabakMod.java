package mett.palemannie.tabakmod;

import com.mojang.logging.LogUtils;
import mett.palemannie.tabakmod.block.ModBlocks;
import mett.palemannie.tabakmod.effect.ModEffects;
import mett.palemannie.tabakmod.entity.ModEntities;
import mett.palemannie.tabakmod.entity.client.RaketenZigrrRenderer;
import mett.palemannie.tabakmod.entity.client.SpuckeRenderer;
import mett.palemannie.tabakmod.item.ModCreativeModeTabs;
import mett.palemannie.tabakmod.item.ModItems;
import mett.palemannie.tabakmod.loot.ModLootModifiers;
import mett.palemannie.tabakmod.networking.ModMessages;
import mett.palemannie.tabakmod.sound.ModSounds;
import mett.palemannie.tabakmod.util.TabakmodConfig;
import mett.palemannie.tabakmod.villager.ModVillagers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


@Mod(TabakMod.MODID)
public class TabakMod {
    public static final String MODID = "tabakmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public TabakMod(FMLJavaModLoadingContext context) {

        /*IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);*/

        var modBusGroup = context.getModBusGroup();
        FMLCommonSetupEvent.getBus(modBusGroup).addListener(TabakMod::commonSetup);


        ModItems.register(modBusGroup);
        ModBlocks.register(modBusGroup);
        ModLootModifiers.register(modBusGroup);
        ModVillagers.register(modBusGroup);
        ModSounds.register(modBusGroup);
        ModEffects.register(modBusGroup);
        ModEntities.register(modBusGroup);
        ModCreativeModeTabs.register(modBusGroup);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, TabakmodConfig.COMMON_SPEC);

    }

    private static void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork( ()-> {
            ModMessages.register();
        });
        event.enqueueWork( ()-> {
            ComposterBlock.add(0.3f, ModItems.TABAKBLATT.get());
            ComposterBlock.add(0.2f, ModItems.TABAKSAMEN.get());

        });
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            EntityRenderers.register(ModEntities.SPUCKE.get(), SpuckeRenderer::new);
            EntityRenderers.register(ModEntities.STUMMEL.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.STUMMEL_KAMEL.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.STUMMEL_MENTHOL.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.STUMMEL_ZIGRR.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.RAKETENZIGRR.get(), RaketenZigrrRenderer::new);
        }
    }
}
