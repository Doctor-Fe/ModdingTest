package alloyfek.moddingtest.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

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
}
