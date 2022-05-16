package alloyfek.moddingtest.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FireTrap extends TrapBase{

    public FireTrap(Material materialIn, String registryName, String unlocalizedName) {
        super(materialIn, registryName, unlocalizedName);
    }

	@Override
	public void onLanded(World worldin, Entity entityin)
	{
		super.onLanded(worldin, entityin);
		entityin.setFire(10);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		super.randomDisplayTick(stateIn, worldIn, pos, rand);

		double x = (double)pos.getX() + 0.5D;
		double y = (double)pos.getY() + 0.25D;
		double z = (double)pos.getZ() + 0.5D;
		
		for (int i = 0; i < rand.nextInt(12) + 4; i++)
		{
			worldIn.spawnParticle(EnumParticleTypes.FLAME, x + rand.nextDouble() * 0.8 - 0.4, y, z + rand.nextDouble() * 0.8 - 0.4, 0, rand.nextDouble() * 0.05, 0);
		}
	}
}
