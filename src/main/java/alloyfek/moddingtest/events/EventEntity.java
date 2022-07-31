package alloyfek.moddingtest.events;

import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.event.entity.ProjectileImpactEvent.Arrow;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;

public class EventEntity {
    @SubscribeEvent
    public void onProjectileImpact(Arrow arrow)
    {
        EntityArrow arrow2 = arrow.getArrow();
        RayTraceResult result = arrow.getRayTraceResult();
        if (arrow.getArrow().isBurning() && !arrow2.world.isRemote && result.entityHit == null)
        {
            BlockPos blockpos = result.getBlockPos().offset(result.sideHit);

            if (arrow2.world.isAirBlock(blockpos))
            {
                arrow2.world.setBlockState(blockpos, Blocks.FIRE.getDefaultState());
            }
        }
        arrow.setResult(Result.DEFAULT);
    }
}
