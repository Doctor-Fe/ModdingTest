package alloyfek.moddingtest.register;

import alloyfek.moddingtest.lists.Items;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ItemRegister {
	public static void register()
	{
		ForgeRegistries.ITEMS.registerAll(Items.FIRETRAP_ITEM, Items.AIRTRAP_ITEM, Items.EXPLOSIONTRAP_ITEM, Items.EXPLOSIVE_ITEM);
	}
}