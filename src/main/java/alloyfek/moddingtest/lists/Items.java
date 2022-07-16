package alloyfek.moddingtest.lists;

import alloyfek.moddingtest.ModdingTest;
import alloyfek.moddingtest.items.Explosive;
import alloyfek.moddingtest.items.ItemRemoteIgniter;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class Items {
	public static final Item FIRETRAP_ITEM = getItemFromBlock(Blocks.FIRETRAP_BLOCK);
	public static final Item AIRTRAP_ITEM = getItemFromBlock(Blocks.AIRTRAP_BLOCK);
	public static final Item EXPLOSIONTRAP_ITEM = getItemFromBlock(Blocks.EXPLOSIONTRAP_BLOCK);
	public static final Item EXPLOSIVE_ITEM = new Explosive(ModdingTest.MODID,  "explosive");
	public static final Item LIGHTNINGTRAP_ITEM = getItemFromBlock(Blocks.LIGHTNING_TRAP);
	public static final Item REMOTE_IGNITER_ITEM = new ItemRemoteIgniter(ModdingTest.MODID, "remote_igniter");

	private static Item getItemFromBlock(Block block)
	{
		return new ItemBlock(block).setRegistryName(block.getRegistryName()).setUnlocalizedName(block.getUnlocalizedName());
	}
}