package alloyfek.moddingtest.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Explosive extends ItemBase {

    public Explosive(String modID, String name) {
        super(modID, name);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if (!worldIn.isRemote)
        {
            BlockPos pos = playerIn.getPosition();
            worldIn.newExplosion(playerIn, pos.getX(), pos.getY(), pos.getZ(), 2F, true, true);
            ItemStack stack = playerIn.getHeldItem(handIn);
            stack.shrink(1);
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
        } else return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }
}
