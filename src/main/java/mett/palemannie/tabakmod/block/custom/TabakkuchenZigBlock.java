package mett.palemannie.tabakmod.block.custom;

import mett.palemannie.tabakmod.block.ModBlocks;
import mett.palemannie.tabakmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import static mett.palemannie.tabakmod.block.custom.TabakkuchenBlock.BISSE;

public class TabakkuchenZigBlock extends Block {
    public TabakkuchenZigBlock(Properties pProperties) {
        super(pProperties);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static final BooleanProperty LIT = BooleanProperty.create("lit");

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(LIT);
    }

    protected static final VoxelShape KUCHENFORM = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D);
    protected static final VoxelShape ZIGFORM = Block.box(7.5D, 6.0D, 7.5D, 8.5D, 11.0D, 8.5D);
    protected static final VoxelShape SHAPE = Shapes.or(KUCHENFORM, ZIGFORM);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        boolean flag = pState.getValue(LIT);
        if ((itemstack.is(Items.FLINT_AND_STEEL) || itemstack.is(Items.FIRE_CHARGE)) && !flag) {
            pLevel.setBlock(pPos, pState.cycle(LIT), 3);
            if(itemstack.is(Items.FLINT_AND_STEEL)){ pLevel.playSound(null, pPos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS,1f,1f);}
            if(itemstack.is(Items.FIRE_CHARGE)) { pLevel.playSound(null, pPos, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS,1f,1f);}
        }
        if( !(itemstack.is(Items.FLINT_AND_STEEL) || itemstack.is(Items.FIRE_CHARGE)) && flag){
            pLevel.setBlock(pPos, pState.cycle(LIT), 3);
            pLevel.playSound(null, pPos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS,1f,1f);
        }
        if( !(itemstack.is(Items.FLINT_AND_STEEL) || itemstack.is(Items.FIRE_CHARGE)) && !flag){
            pLevel.setBlockAndUpdate(pPos, ModBlocks.TABAKKUCHEN.get().defaultBlockState().setValue(BISSE, 0));
            popResource(pLevel, pPos, new ItemStack(ModItems.ZIGARETTE.get()));
            pPlayer.getFoodData().eat(1, 0.1f);
        }
        return InteractionResult.SUCCESS;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pPos, BlockPos pNeighborPos) {
        return pDirection == Direction.DOWN && !pState.canSurvive(pLevel, pPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pDirection, pNeighborState, pLevel, pPos, pNeighborPos);
    }

    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        return pLevel.getBlockState(pPos.below()).isSolid();
    }

    public int getAnalogOutputSignal(BlockState pState, Level pLevel, BlockPos pPos) {
        return 15;
    }

    public boolean hasAnalogOutputSignal(BlockState pState) {
        return true;
    }
    public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
        return false;
    }

    public ItemStack getCloneItemStack(BlockGetter pLevel, BlockPos pPos, BlockState pState) {
        return new ItemStack(ModBlocks.TABAKKUCHEN.get());
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    void raucheAmbiente(Level level, BlockPos pos, RandomSource rnd){
        float chance = 0.33f;
        double rx=rnd.nextGaussian()/100;
        double rz=rnd.nextGaussian()/100;
        if(chance >= rnd.nextFloat()){
            level.addParticle(ParticleTypes.SMOKE,
                    pos.getX()+0.5d+rx, pos.getY()+0.8d+rz/10, pos.getZ()+0.5d+rz,
                    0d, 0.0005d, 0d);}
    }
    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if(pState.getValue(LIT)) {
            raucheAmbiente(pLevel, pPos, pRandom);
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
