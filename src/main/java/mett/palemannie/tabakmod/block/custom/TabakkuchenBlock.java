package mett.palemannie.tabakmod.block.custom;

import mett.palemannie.tabakmod.block.ModBlocks;
import mett.palemannie.tabakmod.effect.ModEffects;
import mett.palemannie.tabakmod.item.ModItems;
import mett.palemannie.tabakmod.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
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
    public TabakkuchenBlock(Properties pProperties) {
        super(pProperties);
    }
    public static final int MAX_BISSE = 13;
    public static final IntegerProperty BISSE = IntegerProperty.create("bisse", 0, MAX_BISSE);
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(BISSE);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack stack = pPlayer.getItemInHand(pHand);

        if(!pLevel.isClientSide && stack.is(ModItems.ZIGARETTE.get()) && (pHand == InteractionHand.MAIN_HAND || pHand == InteractionHand.OFF_HAND) && pState.getValue(BISSE) == 0){
            if(!pPlayer.isCreative()){
                stack.shrink(1);
            }
            pLevel.setBlockAndUpdate(pPos, ModBlocks.TABAKKUCHEN_ZIG.get().defaultBlockState().setValue(LIT, false));
            pLevel.playSound(null, pPos, ModSounds.PFEIFE_LADEN.get(), SoundSource.BLOCKS, 2f, 1f);
            return InteractionResult.FAIL;

        }
        if (pLevel.isClientSide) {
            if (eat(pLevel, pPos, pState, pPlayer, pHand).consumesAction()) {
                return InteractionResult.SUCCESS;
            }

            if (stack.isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }

        return eat(pLevel, pPos, pState, pPlayer, pHand);
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
            pPlayer.addEffect(new MobEffectInstance(ModEffects.SPUCKEN.get(), 400, 0));
            pPlayer.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 400, 0));
            pPlayer.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 150, 0));
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
    public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
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

    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        return pFacing == Direction.DOWN && !pState.canSurvive(pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
