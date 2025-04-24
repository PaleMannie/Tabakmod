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
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
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
    /*public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
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
    }*/

    @Override
    protected InteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {
        boolean islit = pState.getValue(LIT);
        //Anzünden der Zigarette
        if((pStack.is(Items.FLINT_AND_STEEL)||pStack.is(Items.FIRE_CHARGE)) && !islit){
            pLevel.setBlock(pPos, pState.cycle(LIT), 3);
            if(pStack.is(Items.FLINT_AND_STEEL)){ pLevel.playSound(null, pPos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS,1f,1f);}
            if(pStack.is(Items.FIRE_CHARGE)) { pLevel.playSound(null, pPos, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS,1f,1f);}
        }
        //Löschen der Zigarette (außer Zündquellen)
        if( !(pStack.is(Items.FLINT_AND_STEEL) || pStack.is(Items.FIRE_CHARGE)) && islit){
            pLevel.setBlock(pPos, pState.cycle(LIT), 3);
            pLevel.playSound(null, pPos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS,1f,1f);
        }
        //Herausnehmen der Zigarette
        if( !(pStack.is(Items.FLINT_AND_STEEL) || pStack.is(Items.FIRE_CHARGE)) && !islit){
            pLevel.setBlockAndUpdate(pPos, ModBlocks.TABAKKUCHEN.get().defaultBlockState().setValue(BISSE, 0));
            popResource(pLevel, pPos, new ItemStack(ModItems.ZIGARETTE.get()));
            pPlayer.getFoodData().eat(1, 0.1f);
        }


        return InteractionResult.SUCCESS;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        boolean islit = pState.getValue(LIT);
        if(!islit){
            pLevel.setBlockAndUpdate(pPos, ModBlocks.TABAKKUCHEN.get().defaultBlockState().setValue(BISSE, 0));
            popResource(pLevel, pPos, new ItemStack(ModItems.ZIGARETTE.get()));
            pPlayer.getFoodData().eat(1, 0.1f);
        } else {
            pLevel.setBlock(pPos, pState.cycle(LIT), 3);
            pLevel.playSound(null, pPos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS,1f,1f);
        }

        return InteractionResult.SUCCESS;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    protected BlockState updateShape(BlockState p_51213_, LevelReader p_366089_, ScheduledTickAccess p_363263_, BlockPos p_51217_, Direction p_51214_, BlockPos p_51218_, BlockState p_51215_, RandomSource p_363935_){
        return p_51214_ == Direction.DOWN && !p_51213_.canSurvive(p_366089_, p_51217_) ? Blocks.AIR.defaultBlockState() : super.updateShape(p_51213_, p_366089_, p_363263_, p_51217_, p_51214_, p_51218_, p_51215_, p_363935_);
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

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
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
