package mett.palemannie.tabakmod.block.custom;

import mett.palemannie.tabakmod.block.ModBlocks;
import mett.palemannie.tabakmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AschenbecherBlock extends Block {
    public AschenbecherBlock(Properties pProperties) {
        super(pProperties);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static final VoxelShape SHAPE = Block.box(5.5d,0d,5.5d, 10.5d, 1.25d, 10.5d);
    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) { return SHAPE; }
    public static final IntegerProperty WELCHEZIG = IntegerProperty.create("welchezig", 0, 2);
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(WELCHEZIG);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack stack = pPlayer.getItemInHand(pHand);

        if(!pLevel.isClientSide && (pHand == InteractionHand.MAIN_HAND || pHand == InteractionHand.OFF_HAND)){
            if(stack.is(ModItems.ZIGARETTE.get()) && (pState.getValue(WELCHEZIG) == 0 || pState.getValue(WELCHEZIG) == 2)){
                pLevel.setBlockAndUpdate(pPos, ModBlocks.ASCHENBECHER.get().defaultBlockState().setValue(WELCHEZIG, 1));

                if(!pPlayer.isCreative()) {
                    stack.shrink(1);
                }
                if(pState.getValue(WELCHEZIG) == 2){
                    popResource(pLevel, pPos, new ItemStack(ModItems.ZIGARRE.get()));
                }

            return InteractionResult.SUCCESS;
            }

            if(stack.is(ModItems.ZIGARRE.get()) && (pState.getValue(WELCHEZIG) == 0 || pState.getValue(WELCHEZIG) == 1)){
                pLevel.setBlockAndUpdate(pPos, ModBlocks.ASCHENBECHER.get().defaultBlockState().setValue(WELCHEZIG, 2));
                if(!pPlayer.isCreative()) {
                    stack.shrink(1);
                }
                if(pState.getValue(WELCHEZIG) == 1){
                    popResource(pLevel, pPos, new ItemStack(ModItems.ZIGARETTE.get()));
                }
                return InteractionResult.SUCCESS;
            }

            if(stack.isEmpty() && pState.getValue(WELCHEZIG) == 1){
                pLevel.setBlockAndUpdate(pPos, ModBlocks.ASCHENBECHER.get().defaultBlockState().setValue(WELCHEZIG, 0));
                popResource(pLevel, pPos, new ItemStack(ModItems.ZIGARETTE.get()));
            }
            if(stack.isEmpty() && pState.getValue(WELCHEZIG) == 2){
                pLevel.setBlockAndUpdate(pPos, ModBlocks.ASCHENBECHER.get().defaultBlockState().setValue(WELCHEZIG, 0));
                popResource(pLevel, pPos, new ItemStack(ModItems.ZIGARRE.get()));
            }
        }
        return InteractionResult.PASS;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    void raucheAmbiente(Level level, BlockPos pos, RandomSource rnd){
        float chance = 0.33f;
        double rx=rnd.nextGaussian()/100;
        double rz=rnd.nextGaussian()/100;
        if(chance >= rnd.nextFloat()){
        level.addParticle(ParticleTypes.SMOKE,
                pos.getX()+0.5d+rx, pos.getY()+0.1d, pos.getZ()+0.5d+rz,
                0d, 0.0005d, 0d);}
    }
    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if(pState.getValue(WELCHEZIG) == 1 || pState.getValue(WELCHEZIG) == 2){
            raucheAmbiente(pLevel, pPos, pRandom);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        return !pLevel.isEmptyBlock(pPos.below());
    }

    @Override
    protected BlockState updateShape(BlockState p_51213_, LevelReader p_366089_, ScheduledTickAccess p_363263_, BlockPos p_51217_, Direction p_51214_, BlockPos p_51218_, BlockState p_51215_, RandomSource p_363935_){
        return p_51214_ == Direction.DOWN && !p_51213_.canSurvive(p_366089_, p_51217_) ? Blocks.AIR.defaultBlockState() : super.updateShape(p_51213_, p_366089_, p_363263_, p_51217_, p_51214_, p_51218_, p_51215_, p_363935_);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}