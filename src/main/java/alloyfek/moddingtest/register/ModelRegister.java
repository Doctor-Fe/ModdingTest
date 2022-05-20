package alloyfek.moddingtest.register;

import alloyfek.moddingtest.lists.Items;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class ModelRegister {
    public static void register()
    {
        ModelLoader.setCustomModelResourceLocation(Items.FIRETRAP_ITEM, 0, new ModelResourceLocation(Items.FIRETRAP_ITEM.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Items.AIRTRAP_ITEM, 0, new ModelResourceLocation(Items.AIRTRAP_ITEM.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Items.EXPLOSIONTRAP_ITEM, 0, new ModelResourceLocation(Items.EXPLOSIONTRAP_ITEM.getRegistryName(), "inventory"));
    }
}
