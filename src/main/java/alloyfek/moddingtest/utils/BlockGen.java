package alloyfek.moddingtest.utils;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockGen {
	public static void spreadBlock(World worldIn, Random rnd, Block block, BlockPos center, int range, double probability)
	{
		rnd.setSeed(rnd.nextLong());
		for (int x = -range; x <= range; x++)
		{
			for (int y = -range; y <= range; y++)
			{
				for (int z = -range; z <= range; z++)
				{
					BlockPos pos = new BlockPos(x, y, z);
					if (pos.getDistance(0, 0, 0) <= range)
					{
						pos = pos.add(center);
						if (worldIn.isAirBlock(pos) && block.canPlaceBlockAt(worldIn, pos) && rnd.nextDouble() * 100 < probability)
						{
							worldIn.setBlockState(pos, block.getDefaultState());
						}
					}
				}
			}
		}
	}

	public static void replaceAdjacentAirBlock(World worldIn, Random rnd, Block block, BlockPos center, int range, double probability)
	{
		rnd.setSeed(rnd.nextLong());
		for (int x = -range; x <= range; x++)
		{
			for (int y = -range; y <= range; y++)
			{
				for (int z = -range; z <= range; z++)
				{
					BlockPos pos = new BlockPos(x, y, z);
					if (pos.getDistance(0, 0, 0) <= range)
					{
						pos = pos.add(center);
						if (isAnySideAir(worldIn, pos) && block.canPlaceBlockAt(worldIn, pos) && rnd.nextDouble() * 100 < probability)
						{
							worldIn.setBlockState(pos, block.getDefaultState());
						}
					}
				}
			}
		}
	}

    public static boolean isAnySideAir(World worldIn, BlockPos pos)
    {
        return worldIn.isAirBlock(pos.offset(EnumFacing.DOWN))  || worldIn.isAirBlock(pos.offset(EnumFacing.EAST)) ||
               worldIn.isAirBlock(pos.offset(EnumFacing.UP))    || worldIn.isAirBlock(pos.offset(EnumFacing.WEST)) ||
               worldIn.isAirBlock(pos.offset(EnumFacing.SOUTH)) || worldIn.isAirBlock(pos.offset(EnumFacing.NORTH))  ;
    }
}
