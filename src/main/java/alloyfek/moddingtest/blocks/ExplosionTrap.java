package alloyfek.moddingtest.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ExplosionTrap extends TrapBase{

    public ExplosionTrap(Material materialIn, String registryName, String unlocalizedName) {
        super(materialIn, registryName, unlocalizedName);
    }

    @Override
    public void onLanded(World worldIn, Entity entityIn) {
        super.onLanded(worldIn, entityIn);
        if (!worldIn.isRemote)
        {
            BlockPos pos = entityIn.getPosition();
            worldIn.setBlockToAir(pos);
            worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 4F, true);
        }
    }
}