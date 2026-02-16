package mett.palemannie.tabakmod.item;

import mett.palemannie.tabakmod.TabakMod;
import mett.palemannie.tabakmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TabakMod.MODID);

    public static final RegistryObject<CreativeModeTab> TABAK_TAB = CREATIVE_MODE_TABS.register("tabak_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.TABAKBLAETTER_GETROCKNET.get()))
                    .title(Component.translatable("creativemodetab.tabak_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        
                        output.accept(ModItems.TABAKSAMEN.get());
                        output.accept(ModItems.TABAKBLATT.get());

                        output.accept(ModItems.TROCKENER_TABAK.get());
                        output.accept(ModItems.HELLER_TABAK_BEHANDELT.get());
                        output.accept(ModItems.MITTLERER_TABAK_BEHANDELT.get());
                        output.accept(ModItems.DUNKLER_TABAK_BEHANDELT.get());
                        output.accept(ModItems.HELLER_TABAK.get());
                        output.accept(ModItems.MITTLERER_TABAK.get());
                        output.accept(ModItems.DUNKLER_TABAK.get());

                        output.accept(ModBlocks.TABAKBLAETTER.get());
                        output.accept(ModBlocks.TABAKBLAETTER_TEIL_GETROCKNET.get());
                        output.accept(ModBlocks.TABAKBLAETTER_HALB_GETROCKNET.get());
                        output.accept(ModBlocks.TABAKBLAETTER_FAST_GETROCKNET.get());
                        output.accept(ModBlocks.TABAKBLAETTER_GETROCKNET.get());

                        output.accept(ModBlocks.GETROCKNETER_TABAKBALLEN.get());
                        output.accept(ModBlocks.HELLER_TABAKBALLEN.get());
                        output.accept(ModBlocks.MITTLERER_TABAKBALLEN.get());
                        output.accept(ModBlocks.DUNKLER_TABAKBALLEN.get());

                        output.accept(ModItems.KAUTABAK.get());
                        output.accept(ModItems.KAUTABAKMISCHE.get());
                        output.accept(ModBlocks.TABAKKUCHEN.get());
                        output.accept(ModItems.TABAKEISKREM.get());

                        output.accept(ModItems.ZIGARETTE.get());
                        output.accept(ModItems.ZIGARETTE_MENTHOL.get());
                        output.accept(ModItems.ZIGARETTE_SCHEISE.get());
                        output.accept(ModItems.ZIGARETTE_KAMEL.get());
                        output.accept(ModItems.ZIGARRE.get());
                        output.accept(ModItems.PFEIFE.get());
                        output.accept(ModItems.PFEIFE_LEER.get());
                        output.accept(ModItems.DSCHOINT.get());
                        output.accept(ModItems.KAKERLAKE.get());
                        output.accept(ModItems.ZIGARETTEN.get());
                        output.accept(ModItems.ZIGARREN.get());
                        output.accept(ModItems.SUIZIDZIGARETTE.get());
                        output.accept(ModItems.RAKETENZIGARRE.get());
                        output.accept(ModItems.ZIGARETTENFILTER.get());
                        output.accept(ModItems.ZIGARETTENSTUMMEL.get());
                        output.accept(ModItems.STUMMEL_MENTHOL.get());
                        output.accept(ModItems.STUMMEL_KAMEL.get());
                        output.accept(ModItems.STUMMEL_SCHEISE.get());
                        output.accept(ModItems.ZIGARRENSTUMMEL.get());
                        output.accept(ModItems.ZIGARETTENSCHACHTEL.get());
                        output.accept(ModItems.ZIGARETTENSCHACHTEL_LEER.get());
                        output.accept(ModItems.ZIGARETTENSCHACHTEL_GROSS.get());
                        output.accept(ModItems.ZIGARETTENSCHACHTEL_GROSS_LEER.get());
                        output.accept(ModItems.ZIGARETTENSCHACHTEL_MENTHOL.get());
                        output.accept(ModItems.ZIGARETTENSCHACHTEL_MENTHOL_LEER.get());
                        output.accept(ModItems.ZIGARRENSCHACHTEL.get());
                        output.accept(ModItems.ZIGARRENSCHACHTEL_LEER.get());
                        output.accept(ModItems.DECKBLATT.get());

                        output.accept(ModBlocks.ASCHENBECHER.get());
                        output.accept(ModBlocks.ASCHENBECHER_GROSS.get());

                    }).build());

    public static void register(BusGroup eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}