package alloyfek.moddingtest.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FireTrap extends TrapBase{

	public int fireRange;

    public FireTrap(Material materialIn, String registryName, String unlocalizedName) {
        super(materialIn, registryName, unlocalizedName);
		fireRange = 3;
		setLightLevel(10);
    }

	@Override
	public void onLanded(World worldIn, Entity entityin)
	{
		super.onLanded(worldIn, entityin);
		if (!worldIn.isRemote)
		{
			BlockPos center = entityin.getPosition();
			worldIn.setBlockToAir(center);
			worldIn.playSound(null, center, SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.AMBIENT, 1F, 1F);
			Random rnd = new Random(center.hashCode() ^ entityin.hashCode());
			rnd.setSeed(rnd.nextLong());
			for (int x = -fireRange; x <= fireRange; x++)
			{
				for (int y = -fireRange; y <= fireRange; y++)
				{
					for (int z = -fireRange; z <= fireRange; z++)
					{
						BlockPos pos = new BlockPos(x, y, z);
						if (pos.getDistance(0, 0, 0) <= fireRange)
						{
							pos = pos.add(center);
							if (worldIn.isAirBlock(pos) && Blocks.FIRE.canPlaceBlockAt(worldIn, pos) && rnd.nextDouble(100) < 40D)
							{
								worldIn.setBlockState(pos, Blocks.FIRE.getDefaultState());
							}
						}
					}
				}
			}
			entityin.setFire(10);
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		super.randomDisplayTick(stateIn, worldIn, pos, rand);

		double x = (double)pos.getX() + 0.5D;
		double y = (double)pos.getY() + 0.25D;
		double z = (double)pos.getZ() + 0.5D;
		
		for (int i = 0; i < rand.nextInt(4) + 4; i++)
		{
			worldIn.spawnParticle(EnumParticleTypes.FLAME, x + rand.nextDouble() * 0.8 - 0.4, y, z + rand.nextDouble() * 0.8 - 0.4, 0, rand.nextDouble() * 0.05, 0);
		}
	}
}
