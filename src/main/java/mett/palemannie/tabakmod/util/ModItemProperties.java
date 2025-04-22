package mett.palemannie.tabakmod.util;

import mett.palemannie.tabakmod.TabakMod;
import mett.palemannie.tabakmod.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ModItemProperties {
    public static void addCustomItemProperties(){
        bringTabakproduktZumGluehenBeimZiehen(ModItems.PFEIFE.get());
        bringTabakproduktZumGluehenBeimZiehen(ModItems.ZIGARETTE.get());
        bringTabakproduktZumGluehenBeimZiehen(ModItems.ZIGARRE.get());
        bringTabakproduktZumGluehenBeimZiehen(ModItems.ZIGARETTE_MENTHOL.get());
        bringTabakproduktZumGluehenBeimZiehen(ModItems.DSCHOINT.get());
        bringTabakproduktZumGluehenBeimZiehen(ModItems.ZIGARETTE_SCHEISE.get());
    }
    private static void bringTabakproduktZumGluehenBeimZiehen(Item item) {
        ItemProperties.register(item, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID,"am_ziehen"), (itemStack, level, entity, i) -> {
            return entity != null && entity.isUsingItem() && entity.getUseItem() == itemStack ? 1.0F : 0.0F;
        });
    }

}
