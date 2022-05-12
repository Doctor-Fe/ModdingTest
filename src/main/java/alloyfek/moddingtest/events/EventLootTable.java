package alloyfek.moddingtest.events;

import alloyfek.moddingtest.lists.Items;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraft.world.storage.loot.functions.SetCount;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventLootTable{
    @SubscribeEvent
    public void onLootTableLoaded(LootTableLoadEvent event)
    {
        LootTable table = event.getTable();
        LootPool pool = table.getPool("main");
        if (pool != null && event.getName().equals(LootTableList.ENTITIES_COW))
        {
            pool.addEntry(new LootEntryItem(Items.AIRTRAP_ITEM, 15, 3, new LootFunction[] {
                new SetCount(new LootCondition[0], new RandomValueRange(1, 3))
        }, new LootCondition[0], "moddingtest:test"));
        }
    }
}