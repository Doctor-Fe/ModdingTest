package alloyfek.moddingtest.events;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.ProjectileImpactEvent.Arrow;
import net.minecraftforge.event.entity.living.LivingSpawnEvent.CheckSpawn;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;

public class EventEntity {
    @SubscribeEvent
    public void onProjectileImpact(Arrow arrow)
    {
        // TODO 火をつける座標の設定
        if (arrow.getArrow().isBurning())
        {
            World world = arrow.getArrow().getEntityWorld();
            BlockPos pos = arrow.getArrow().getPosition();
            BlockPos offset = pos.offset(arrow.getRayTraceResult().sideHit);
            if (Blocks.FIRE.canPlaceBlockAt(world, pos))
            {
                world.setBlockState(pos, Blocks.FIRE.getDefaultState());
            } else if (Blocks.FIRE.canPlaceBlockAt(world, offset))
            {
                world.setBlockState(offset, Blocks.FIRE.getDefaultState());
            }
        }
        arrow.setResult(Result.DEFAULT);
    }
}
