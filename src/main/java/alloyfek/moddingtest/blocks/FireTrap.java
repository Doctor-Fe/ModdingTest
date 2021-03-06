package alloyfek.moddingtest.blocks;

import java.util.Random;

import alloyfek.moddingtest.utils.BlockGen;
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

    public FireTrap(Material materialIn) {
        super(materialIn, "fire_trap", "fire_trap");
		fireRange = 5;
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
			BlockGen.spreadBlock(worldIn, new Random(center.hashCode() ^ entityin.hashCode()),Blocks.FIRE, center, fireRange / 3, 85);
			BlockGen.spreadBlock(worldIn, new Random(center.hashCode() ^ entityin.hashCode()),Blocks.FIRE, center, fireRange, 40);
			entityin.setFire(5);
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
