package mett.palemannie.tabakmod.block;

import mett.palemannie.tabakmod.TabakMod;
import mett.palemannie.tabakmod.block.custom.*;
import mett.palemannie.tabakmod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(Registries.BLOCK, TabakMod.MODID);

    private static <T extends Block> DeferredHolder<Block, T> registerBlock(String name, Supplier<T> block) {
        DeferredHolder<Block, T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static final DeferredHolder<Block, Block> TABAKBLAETTER_GETROCKNET = registerBlock("tabakblaetter_getrocknet",
            () -> new TabakblaetterStadium4Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK,
                            Identifier.fromNamespaceAndPath(TabakMod.MODID, "tabakblaetter_getrocknet")))
                    .friction(1f).sound(SoundType.VINE).instabreak().noOcclusion().ignitedByLava().pushReaction(PushReaction.POPPED)));

    public static final DeferredHolder<Block, Block> TABAKBLAETTER_FAST_GETROCKNET = registerBlock("tabakblaetter_fast_getrocknet",
            () -> new TabakblaetterStadium3Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK,
                            Identifier.fromNamespaceAndPath(TabakMod.MODID, "tabakblaetter_fast_getrocknet")))
                    .friction(1f).sound(SoundType.VINE).instabreak().noOcclusion().ignitedByLava().pushReaction(PushReaction.POPPED)));

    public static final DeferredHolder<Block, Block> TABAKBLAETTER_HALB_GETROCKNET = registerBlock("tabakblaetter_halb_getrocknet",
            () -> new TabakblaetterStadium2Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK,
                            Identifier.fromNamespaceAndPath(TabakMod.MODID, "tabakblaetter_halb_getrocknet")))
                    .friction(1f).sound(SoundType.VINE).instabreak().noOcclusion().ignitedByLava().pushReaction(PushReaction.POPPED)));

    public static final DeferredHolder<Block, Block> TABAKBLAETTER_TEIL_GETROCKNET = registerBlock("tabakblaetter_teil_getrocknet",
            () -> new TabakblaetterStadium1Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK,
                            Identifier.fromNamespaceAndPath(TabakMod.MODID, "tabakblaetter_teil_getrocknet"))).
                    friction(1f).sound(SoundType.VINE).instabreak().noOcclusion().ignitedByLava().pushReaction(PushReaction.POPPED)));

    public static final DeferredHolder<Block, Block> TABAKBLAETTER = registerBlock("tabakblaetter",
            () -> new TabakblaetterStadium0Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK,
                            Identifier.fromNamespaceAndPath(TabakMod.MODID, "tabakblaetter"))).
                    friction(1f).sound(SoundType.VINE).instabreak().noOcclusion().ignitedByLava().pushReaction(PushReaction.POPPED)));


    public static final DeferredHolder<Block, Block> GETROCKNETER_TABAKBALLEN = registerBlock("getrockneter_tabakballen",
            () -> new TabakBallenBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK,
                            Identifier.fromNamespaceAndPath(TabakMod.MODID, "getrockneter_tabakballen")))
                    .strength(0.5F).sound(SoundType.GRASS)));

    public static final DeferredHolder<Block, Block> HELLER_TABAKBALLEN = registerBlock("heller_tabakballen",
            () -> new HellerTabakBallenBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK,
                            Identifier.fromNamespaceAndPath(TabakMod.MODID, "heller_tabakballen")))
                    .strength(0.5F).sound(SoundType.GRASS)));

    public static final DeferredHolder<Block, Block> MITTLERER_TABAKBALLEN = registerBlock("mittlerer_tabakballen",
            () -> new MittlererTabakBallenBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK,
                            Identifier.fromNamespaceAndPath(TabakMod.MODID, "mittlerer_tabakballen")))
                    .strength(0.5F).sound(SoundType.GRASS)));

    public static final DeferredHolder<Block, Block> DUNKLER_TABAKBALLEN = registerBlock("dunkler_tabakballen",
            () -> new DunklerTabakBallenBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK,
                            Identifier.fromNamespaceAndPath(TabakMod.MODID, "dunkler_tabakballen")))
                    .strength(0.5F).sound(SoundType.GRASS)));

    public static final DeferredHolder<Block, Block> TABAKPFLANZE = BLOCKS.register("tabakpflanze",
            () -> new TabakPflanzenBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK,
                            Identifier.fromNamespaceAndPath(TabakMod.MODID, "tabakpflanze")))
                    .randomTicks().noCollision().sound(SoundType.SWEET_BERRY_BUSH).pushReaction(PushReaction.POPPED)));


    public static final DeferredHolder<Block, Block> ASCHENBECHER = registerBlock("aschenbecher_neu",
            () -> new AschenbecherBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK,
                            Identifier.fromNamespaceAndPath(TabakMod.MODID, "aschenbecher_neu")))
                    .instabreak().noOcclusion().pushReaction(PushReaction.POPPED).sound(SoundType.STONE)));

    public static final DeferredHolder<Block, Block> ASCHENBECHER_GROSS = registerBlock("aschenbecher_gross",
            () -> new AschenbecherGrossBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK,
                            Identifier.fromNamespaceAndPath(TabakMod.MODID, "aschenbecher_gross")))
                    .instabreak().noOcclusion().pushReaction(PushReaction.POPPED).sound(SoundType.STONE)));


    public static final DeferredHolder<Block, Block> TABAKKUCHEN = registerBlock("tabakkuchen",
            () -> new TabakkuchenBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK,
                            Identifier.fromNamespaceAndPath(TabakMod.MODID, "tabakkuchen")))
                    .forceSolidOn().strength(0.5F).sound(SoundType.SLIME_BLOCK).pushReaction(PushReaction.POPPED).noOcclusion()));
    public static final DeferredHolder<Block, Block> TABAKKUCHEN_ZIG = registerBlock("tabakkuchen_zig",
            () -> new TabakkuchenZigBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK,
                            Identifier.fromNamespaceAndPath(TabakMod.MODID, "tabakkuchen_zig")))
                    .forceSolidOn().strength(0.5F).sound(SoundType.SLIME_BLOCK).pushReaction(PushReaction.POPPED).noOcclusion()));

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static <T extends Block> void registerBlockItem(String name, DeferredHolder<Block, T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()
             .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TabakMod.MODID, name)))));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
