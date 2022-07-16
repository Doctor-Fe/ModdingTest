package alloyfek.moddingtest.register;

import alloyfek.moddingtest.events.EventEntity;
import alloyfek.moddingtest.events.EventLootTable;
import net.minecraftforge.common.MinecraftForge;

public class EventRegister {
    public static void register()
    {
        MinecraftForge.EVENT_BUS.register(new EventLootTable());
        MinecraftForge.EVENT_BUS.register(new EventEntity());
    }
}