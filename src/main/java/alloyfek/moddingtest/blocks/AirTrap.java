package alloyfek.moddingtest.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class AirTrap extends TrapBase{

    public AirTrap(Material materialIn, String registryName, String unlocalizedName) {
        super(materialIn, registryName, unlocalizedName);
    }
    
    @Override
    public void onLanded(World worldIn, Entity entityIn) {
        super.onLanded(worldIn, entityIn);
        entityIn.motionY = 1;
    }
}