package alloyfek.moddingtest;

import org.apache.logging.log4j.Logger;

import alloyfek.moddingtest.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModdingTest.MODID, name = ModdingTest.NAME, version = ModdingTest.VERSION)
public class ModdingTest
{
    public static final String MODID = "moddingtest";
    public static final String NAME = "Modding Test";
    public static final String VERSION = "1.0.1.1";
    
    public static Logger logger;

    @SidedProxy(clientSide = "alloyfek.moddingtest.proxy.ClientProxy", serverSide = "alloyfek.moddingtest.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Instance(ModdingTest.MODID)
    public static ModdingTest moddingtest;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        logger.info("ModdingTest.preInit was called.");
        proxy.register();
    }

    /*@EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }*/
}
