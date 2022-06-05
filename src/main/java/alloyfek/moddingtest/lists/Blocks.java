package alloyfek.moddingtest.lists;

import alloyfek.moddingtest.blocks.AirTrap;
import alloyfek.moddingtest.blocks.FireTrap;
import alloyfek.moddingtest.blocks.LightningTrap;
import alloyfek.moddingtest.blocks.ExplosionTrap;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Blocks {
	public static final Block FIRETRAP_BLOCK = new FireTrap(Material.PISTON);
	public static final Block AIRTRAP_BLOCK = new AirTrap(Material.PISTON);
	public static final Block EXPLOSIONTRAP_BLOCK = new ExplosionTrap(Material.PISTON);
	public static final Block LIGHTNING_TRAP = new LightningTrap(Material.PISTON);
}