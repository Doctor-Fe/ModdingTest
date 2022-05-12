package alloyfek.moddingtest.register;

import alloyfek.moddingtest.lists.Blocks;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BlockRegister{

	public static void register() {
		ForgeRegistries.BLOCKS.registerAll(Blocks.FIRETRAP_BLOCK, Blocks.AIRTRAP_BLOCK, Blocks.EXPLOSIONTRAP_BLOCK);
	}
}
