package mett.palemannie.tabakmod.block;

import mett.palemannie.tabakmod.TabakMod;
import mett.palemannie.tabakmod.block.custom.*;
import mett.palemannie.tabakmod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, TabakMod.MODID);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static final RegistryObject<Block> TABAKBLAETTER_GETROCKNET = registerBlock("tabakblaetter_getrocknet",
            () -> new TabakblaetterStadium4Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "tabakblaetter_getrocknet")))
                    .friction(1f).sound(SoundType.VINE).instabreak().noOcclusion().ignitedByLava()));
    public static final RegistryObject<Block> TABAKBLAETTER_FAST_GETROCKNET = registerBlock("tabakblaetter_fast_getrocknet",
            () -> new TabakblaetterStadium3Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "tabakblaetter_fast_getrocknet")))
                    .friction(1f).sound(SoundType.VINE).instabreak().noOcclusion().ignitedByLava()));
    public static final RegistryObject<Block> TABAKBLAETTER_HALB_GETROCKNET = registerBlock("tabakblaetter_halb_getrocknet",
            () -> new TabakblaetterStadium2Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "tabakblaetter_halb_getrocknet")))
                    .friction(1f).sound(SoundType.VINE).instabreak().noOcclusion().ignitedByLava()));
    public static final RegistryObject<Block> TABAKBLAETTER_TEIL_GETROCKNET = registerBlock("tabakblaetter_teil_getrocknet",
            () -> new TabakblaetterStadium1Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "tabakblaetter_teil_getrocknet"))).
                    friction(1f).sound(SoundType.VINE).instabreak().noOcclusion().ignitedByLava()));
    public static final RegistryObject<Block> TABAKBLAETTER = registerBlock("tabakblaetter",
            () -> new TabakblaetterStadium0Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "tabakblaetter"))).
                    friction(1f).sound(SoundType.VINE).instabreak().noOcclusion().ignitedByLava()));

    public static final RegistryObject<Block> GETROCKNETER_TABAKBALLEN = registerBlock("getrockneter_tabakballen",
            () -> new TabakBallenBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "getrockneter_tabakballen")))
                    .strength(0.5F).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> HELLER_TABAKBALLEN = registerBlock("heller_tabakballen",
            () -> new HellerTabakBallenBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "heller_tabakballen")))
                    .strength(0.5F).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> MITTLERER_TABAKBALLEN = registerBlock("mittlerer_tabakballen",
            () -> new MittlererTabakBallenBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "mittlerer_tabakballen")))
                    .strength(0.5F).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> DUNKLER_TABAKBALLEN = registerBlock("dunkler_tabakballen",
            () -> new DunklerTabakBallenBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "dunkler_tabakballen")))
                    .strength(0.5F).sound(SoundType.GRASS)));

    public static final RegistryObject<Block> TABAKPFLANZE = BLOCKS.register("tabakpflanze",
            () -> new TabakPflanzenBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "tabakpflanze")))
                    .randomTicks().noCollision().sound(SoundType.SWEET_BERRY_BUSH).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ASCHENBECHER = registerBlock("aschenbecher_neu",
            () -> new AschenbecherBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "aschenbecher_neu")))
                    .instabreak().noOcclusion().pushReaction(PushReaction.DESTROY).sound(SoundType.STONE)));
    public static final RegistryObject<Block> ASCHENBECHER_GROSS = registerBlock("aschenbecher_gross",
            () -> new AschenbecherGrossBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "aschenbecher_gross")))
                    .instabreak().noOcclusion().pushReaction(PushReaction.DESTROY).sound(SoundType.STONE)));

    public static final RegistryObject<Block> TABAKKUCHEN = registerBlock("tabakkuchen",
            () -> new TabakkuchenBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "tabakkuchen")))
                    .forceSolidOn().strength(0.5F).sound(SoundType.SLIME_BLOCK).pushReaction(PushReaction.DESTROY).noOcclusion()));
    public static final RegistryObject<Block> TABAKKUCHEN_ZIG = registerBlock("tabakkuchen_zig",
            () -> new TabakkuchenZigBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, "tabakkuchen_zig")))
                    .forceSolidOn().strength(0.5F).sound(SoundType.SLIME_BLOCK).pushReaction(PushReaction.DESTROY).noOcclusion()));

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()
             .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TabakMod.MODID, name)))));
    }

    public static void register(BusGroup eventBus) {
        BLOCKS.register(eventBus);
    }

}
