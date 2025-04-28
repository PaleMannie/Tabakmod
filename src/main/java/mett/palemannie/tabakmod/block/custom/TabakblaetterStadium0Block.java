package mett.palemannie.tabakmod.block.custom;

import mett.palemannie.tabakmod.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TabakblaetterStadium0Block extends Block {
    //------------------------------------------------------------------------------------------------------------------
    public TabakblaetterStadium0Block(Properties pProperties) {
        super(pProperties);
    }
    public static final VoxelShape SHAPE = Block.box(0d,0d,0d, 16d, 4d, 16d);
    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        return !pLevel.isEmptyBlock(pPos.below())
                && !pLevel.getBlockState(pPos.below()).is(ModBlocks.TABAKBLAETTER.get())
                && !pLevel.getBlockState(pPos.below()).is(ModBlocks.TABAKBLAETTER_TEIL_GETROCKNET.get())
                && !pLevel.getBlockState(pPos.below()).is(ModBlocks.TABAKBLAETTER_HALB_GETROCKNET.get())
                && !pLevel.getBlockState(pPos.below()).is(ModBlocks.TABAKBLAETTER_FAST_GETROCKNET.get())
                && !pLevel.getBlockState(pPos.below()).is(ModBlocks.TABAKBLAETTER_GETROCKNET.get());
    }
    @Override
    public boolean propagatesSkylightDown(BlockState pState) {
        return true;
    }
    @Override
    protected BlockState updateShape(BlockState p_51213_, LevelReader p_366089_, ScheduledTickAccess p_363263_, BlockPos p_51217_, Direction p_51214_, BlockPos p_51218_, BlockState p_51215_, RandomSource p_363935_){
        return p_51214_ == Direction.DOWN && !p_51213_.canSurvive(p_366089_, p_51217_) ? Blocks.AIR.defaultBlockState() : super.updateShape(p_51213_, p_366089_, p_363263_, p_51217_, p_51214_, p_51218_, p_51215_, p_363935_);
    }
    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }
    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 50;
    }
    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 120; }
    //------------------------------------------------------------------------------------------------------------------

    @Override
    public boolean isRandomlyTicking(BlockState pState) { return true; }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        float chance = 0.05f;
        if(chance >= pRandom.nextFloat() && pLevel.isBrightOutside() && pLevel.canSeeSky(pPos) && !pLevel.isRaining()){
            pLevel.setBlockAndUpdate(pPos, ModBlocks.TABAKBLAETTER_TEIL_GETROCKNET.get().defaultBlockState());
            pLevel.playSound(null, pPos, SoundEvents.LEASH_KNOT_BREAK, SoundSource.BLOCKS,1f,1f);
        }
        super.randomTick(pState, pLevel, pPos, pRandom);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        float chance = 0.2f;
        float px = pRandom.nextFloat();
        float pz = pRandom.nextFloat();
        if(chance >= pRandom.nextFloat() && pLevel.isBrightOutside() && pLevel.canSeeSky(pPos) && !pLevel.isRaining()){
            pLevel.addParticle(ParticleTypes.CRIT, pPos.getX()+px, pPos.getY()+0.15f, pPos.getZ()+pz, 0, 0.2d, 0);
        }
        super.animateTick(pState, pLevel, pPos, pRandom);
    }
}
