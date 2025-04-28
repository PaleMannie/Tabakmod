package mett.palemannie.tabakmod.block.custom;

import com.mojang.serialization.MapCodec;
import mett.palemannie.tabakmod.block.ModBlocks;
import mett.palemannie.tabakmod.effect.ModEffects;
import mett.palemannie.tabakmod.item.ModItems;
import mett.palemannie.tabakmod.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import static mett.palemannie.tabakmod.block.custom.TabakkuchenZigBlock.LIT;

public class TabakkuchenBlock extends Block {

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static final MapCodec<TabakkuchenBlock> CODEC = simpleCodec(TabakkuchenBlock::new);

    public TabakkuchenBlock(Properties pProperties) {
        super(pProperties);
    }
    public static final int MAX_BISSE = 13;
    public static final IntegerProperty BISSE = /*BlockStateProperties.BITES; */ IntegerProperty.create("bisse", 0, MAX_BISSE);
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(BISSE);
    }
    public MapCodec<TabakkuchenBlock> codec() {
        return CODEC;
    }

    /// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected InteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {
        Item itemStack = pStack.getItem();
        if(itemStack.equals(ModItems.ZIGARETTE.get()) && pState.getValue(BISSE) == 0){
            if(!pPlayer.isCreative()){
                pStack.shrink(1);
            }
            pLevel.setBlockAndUpdate(pPos, ModBlocks.TABAKKUCHEN_ZIG.get().defaultBlockState().setValue(LIT, false));
            pLevel.playSound(null, pPos, ModSounds.PFEIFE_LADEN.get(), SoundSource.BLOCKS, 2f, 1f);
            return InteractionResult.SUCCESS;

        }
        return InteractionResult.TRY_WITH_EMPTY_HAND;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        if (pLevel.isClientSide) {
            if (eat(pLevel, pPos, pState, pPlayer, pPlayer.getUsedItemHand()).consumesAction()) {
                return InteractionResult.SUCCESS;
            }

            if (pPlayer.getItemInHand(InteractionHand.MAIN_HAND).isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }
        return eat(pLevel, pPos, pState, pPlayer, pPlayer.getUsedItemHand());
    }

    protected static InteractionResult eat(LevelAccessor pLevel, BlockPos pPos, BlockState pState, Player pPlayer, InteractionHand pHand) {
        ItemStack stack = pPlayer.getItemInHand(pHand);
        if (!pPlayer.canEat(false)) {
            return InteractionResult.PASS;
        } else {
            if(!stack.is(ModItems.ZIGARETTE.get())){
            pPlayer.getFoodData().eat(1, 0.1F);
            int i = pState.getValue(BISSE);
            pLevel.gameEvent(pPlayer, GameEvent.EAT, pPos);
            if (i < 13) {
                pLevel.setBlock(pPos, pState.setValue(BISSE, Integer.valueOf(i + 1)), 3);
            } else {
                pLevel.removeBlock(pPos, false);
                pLevel.gameEvent(pPlayer, GameEvent.BLOCK_DESTROY, pPos);
            }
            pPlayer.addEffect(new MobEffectInstance(ModEffects.SPUCKEN.getHolder().get(), 400, 0));
            pPlayer.addEffect(new MobEffectInstance(MobEffects.HASTE, 400, 0));
            pPlayer.addEffect(new MobEffectInstance(MobEffects.NAUSEA, 150, 0));
            return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.SUCCESS;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        return pLevel.getBlockState(pPos.below()).isSolid();
    }
    public boolean hasAnalogOutputSignal(BlockState pState) {
        return true;
    }

    @Override
    protected boolean isPathfindable(BlockState p_60475_, PathComputationType p_60478_) {
        return false;
    }

    public int getAnalogOutputSignal(BlockState pBlockState, Level pLevel, BlockPos pPos) {
        return getOutputSignal(pBlockState.getValue(BISSE));
    }

    public static int getOutputSignal(int pEaten) {
        return (15 - pEaten);
    }

    protected static final VoxelShape[] SHAPE_BY_BITE = new VoxelShape[]{
            Block.box(1.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D),
            Block.box(1.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D),
            Block.box(3.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D),
            Block.box(3.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D),
            Block.box(5.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D),
            Block.box(5.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D),
            Block.box(7.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D),
            Block.box(7.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D),
            Block.box(9.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D),
            Block.box(9.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D),
            Block.box(11.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D),
            Block.box(11.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D),
            Block.box(13.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D),
            Block.box(13.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D)};

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE_BY_BITE[pState.getValue(BISSE)];
    }

    @Override
    protected BlockState updateShape(BlockState p_51213_, LevelReader p_366089_, ScheduledTickAccess p_363263_, BlockPos p_51217_, Direction p_51214_, BlockPos p_51218_, BlockState p_51215_, RandomSource p_363935_){
        return p_51214_ == Direction.DOWN && !p_51213_.canSurvive(p_366089_, p_51217_) ? Blocks.AIR.defaultBlockState() : super.updateShape(p_51213_, p_366089_, p_363263_, p_51217_, p_51214_, p_51218_, p_51215_, p_363935_);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
