package alloyfek.moddingtest.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class AirTrap extends TrapBase{

    public AirTrap(Material materialIn) {
        super(materialIn, "air_trap", "air_trap");
    }
    
    @Override
    public void onLanded(World worldIn, Entity entityIn) {
        super.onLanded(worldIn, entityIn);
        entityIn.motionY = 1;
    }
}