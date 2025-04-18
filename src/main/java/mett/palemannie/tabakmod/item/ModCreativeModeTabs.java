package mett.palemannie.tabakmod.item;

import mett.palemannie.tabakmod.TabakMod;
import mett.palemannie.tabakmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB, TabakMod.MODID);
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }

    public static RegistryObject<CreativeModeTab> TABAK_TAB = CREATIVE_MODE_TAB.register("tabak_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.TABAKBLAETTER_GETROCKNET.get()))
                    .title(Component.translatable("creativemodetab.tabak_tab")).build());

}
