package mett.palemannie.tabakmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
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

public class AschenbecherGrossBlock extends Block {
    public AschenbecherGrossBlock(Properties pProperties) {
        super(pProperties);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static final VoxelShape SHAPE = Block.box(2.75d,0d,2.75d, 13.25d, 1d, 13.25d);
    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) { return SHAPE; }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    void raucheAmbiente(Level level, BlockPos pos, RandomSource rnd){
        float chance = 0.25f;
        double rx=rnd.nextGaussian()/10;
        double rz=rnd.nextGaussian()/10;
        if(chance >= rnd.nextFloat()){
        level.addParticle(ParticleTypes.SMOKE,
                pos.getX()+0.5d+rx, pos.getY()+0.1d, pos.getZ()+0.5d+rz,
                0d, 0.0001d, 0d);}
    }
    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
            raucheAmbiente(pLevel, pPos,pRandom);
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