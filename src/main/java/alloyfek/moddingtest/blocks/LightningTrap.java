package alloyfek.moddingtest.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LightningTrap extends TrapBase{
    public LightningTrap(Material material)
    {
        super(material, "lightning_trap", "lightning_trap");
    }

    @Override
    public void onLanded(World worldIn, Entity entityIn) {
        super.onLanded(worldIn, entityIn);
        
		if (!worldIn.isRemote)
		{
            BlockPos pos = entityIn.getPosition();
			worldIn.setBlockToAir(pos);
            worldIn.spawnEntity(new EntityLightningBolt(worldIn, pos.getX(), pos.getY(), pos.getZ(), false));
		}
    }
}
