package alloyfek.moddingtest.blocks;

import alloyfek.moddingtest.ModdingTest;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class TrapBase extends Block {

	public final AxisAlignedBB AA_BB = new AxisAlignedBB(0, 0, 0, 1, 0.25D, 1);

	public TrapBase(Material materialIn) {
		super(materialIn);
	}
	
	public TrapBase(Material materialIn, String registryName, String unlocalizedName)
	{
		this(materialIn);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(ModdingTest.MODID, registryName);
		this.setDefaultState(blockState.getBaseState());
	}

	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state)
	{
		super.onBlockDestroyedByPlayer(worldIn, pos, state);
	}

	@Deprecated
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return AA_BB;
	}
	
	@Deprecated
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return AA_BB;
	}
	
	@Deprecated
	@Override
	public boolean isFullBlock(IBlockState state)
	{
		return false;
	}
	
	@Deprecated
	@Override
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}
	
	@Deprecated
	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
	
	@Deprecated
	@Override
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
	{
		return true;
	}
	
	@Deprecated
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
	{
		return BlockFaceShape.UNDEFINED;
	}
}
