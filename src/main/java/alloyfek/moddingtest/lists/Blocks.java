package alloyfek.moddingtest.lists;

import alloyfek.moddingtest.blocks.AirTrap;
import alloyfek.moddingtest.blocks.FireTrap;
import alloyfek.moddingtest.blocks.ExplosionTrap;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Blocks {
	public static final Block FIRETRAP_BLOCK = new FireTrap(Material.PISTON, "fire_trap", "fire_trap");
	public static final Block AIRTRAP_BLOCK = new AirTrap(Material.PISTON, "air_trap", "air_trap");
	public static final Block EXPLOSIONTRAP_BLOCK = new ExplosionTrap(Material.PISTON, "explosion_trap", "explosion_trap");

}