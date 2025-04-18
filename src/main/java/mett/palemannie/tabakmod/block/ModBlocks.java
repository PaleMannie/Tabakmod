package mett.palemannie.tabakmod.block;

import mett.palemannie.tabakmod.TabakMod;
import mett.palemannie.tabakmod.block.custom.*;
import mett.palemannie.tabakmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
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
            () -> new TabakblaetterStadium4Block(BlockBehaviour.Properties.of().friction(1f).mapColor(DyeColor.byId(5191959))
                    .sound(SoundType.VINE).instabreak().noOcclusion().ignitedByLava()));
    public static final RegistryObject<Block> TABAKBLAETTER_FAST_GETROCKNET = registerBlock("tabakblaetter_fast_getrocknet",
            () -> new TabakblaetterStadium3Block(BlockBehaviour.Properties.of().friction(1f).mapColor(DyeColor.byId(6377774))
                    .sound(SoundType.VINE).instabreak().noOcclusion().ignitedByLava()));
    public static final RegistryObject<Block> TABAKBLAETTER_HALB_GETROCKNET = registerBlock("tabakblaetter_halb_getrocknet",
            () -> new TabakblaetterStadium2Block(BlockBehaviour.Properties.of().friction(1f).mapColor(DyeColor.byId(8349469))
                    .sound(SoundType.VINE).instabreak().noOcclusion().ignitedByLava()));
    public static final RegistryObject<Block> TABAKBLAETTER_TEIL_GETROCKNET = registerBlock("tabakblaetter_teil_getrocknet",
            () -> new TabakblaetterStadium1Block(BlockBehaviour.Properties.of().friction(1f).mapColor(DyeColor.byId(6054919))
                    .sound(SoundType.VINE).instabreak().noOcclusion().ignitedByLava()));
    public static final RegistryObject<Block> TABAKBLAETTER = registerBlock("tabakblaetter",
            () -> new TabakblaetterStadium0Block(BlockBehaviour.Properties.of().friction(1f).mapColor(DyeColor.byId(5800511))
                    .sound(SoundType.VINE).instabreak().noOcclusion().ignitedByLava()));

    public static final RegistryObject<Block> GETROCKNETER_TABAKBALLEN = registerBlock("getrockneter_tabakballen",
            () -> new TabakBallenBlock(BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.GRASS)
                    .mapColor(DyeColor.byId(5191959))));
    public static final RegistryObject<Block> HELLER_TABAKBALLEN = registerBlock("heller_tabakballen",
            () -> new HellerTabakBallenBlock(BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.GRASS)
                    .mapColor(DyeColor.byId(10508571))));
    public static final RegistryObject<Block> MITTLERER_TABAKBALLEN = registerBlock("mittlerer_tabakballen",
            () -> new MittlererTabakBallenBlock(BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.GRASS)
                    .mapColor(DyeColor.byId(6368528))));
    public static final RegistryObject<Block> DUNKLER_TABAKBALLEN = registerBlock("dunkler_tabakballen",
            () -> new DunklerTabakBallenBlock(BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.GRASS)
                    .mapColor(DyeColor.byId(3280129))));

    public static final RegistryObject<Block> TABAKPFLANZE = BLOCKS.register("tabakpflanze",
            () -> new TabakPflanzenBlock(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH)));
    public static final RegistryObject<Block> ASCHENBECHER = registerBlock("aschenbecher_neu",
            () -> new AschenbecherBlock(BlockBehaviour.Properties.copy(Blocks.FLOWER_POT).sound(SoundType.STONE).instabreak().noOcclusion()));
    public static final RegistryObject<Block> ASCHENBECHER_GROSS = registerBlock("aschenbecher_gross",
            () -> new AschenbecherGrossBlock(BlockBehaviour.Properties.copy(Blocks.FLOWER_POT).sound(SoundType.STONE).instabreak().noOcclusion()));

    public static final RegistryObject<Block> TABAKKUCHEN = registerBlock("tabakkuchen",
            () -> new TabakkuchenBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).strength(0.5f).noOcclusion().sound(SoundType.SLIME_BLOCK)));
    public static final RegistryObject<Block> TABAKKUCHEN_ZIG = registerBlock("tabakkuchen_zig",
            () -> new TabakkuchenZigBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).strength(0.5f).noOcclusion().sound(SoundType.SLIME_BLOCK)));

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
