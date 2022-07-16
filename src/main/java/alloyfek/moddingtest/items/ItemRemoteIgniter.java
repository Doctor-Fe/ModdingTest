package alloyfek.moddingtest.items;

import java.util.List;

import alloyfek.moddingtest.ModdingTest;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemRemoteIgniter extends ItemBase {

    public static BlockTNT tnt = (BlockTNT)Blocks.TNT;

    public ItemRemoteIgniter(String modId, String name)
    {
        super(modId, name);
        setMaxStackSize(1);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ModdingTest.logger.info("ItemRemoteIgniter.onItemUse was called.");
        ModdingTest.logger.trace(String.format("%s", pos.toString()));
        IBlockState b = worldIn.getBlockState(pos);
        if (!worldIn.isRemote && b.getBlock() instanceof BlockTNT)
        {
            ModdingTest.logger.trace("Clicked to TNT Block.");
            ItemStack stack = player.getHeldItem(hand);
            NBTTagCompound tag = stack.getTagCompound();
            if (tag != null && tag.hasKey("pos"))
            {
                NBTTagCompound p = tag.getCompoundTag("pos");
                p.setInteger("x", pos.getX());
                p.setInteger("y", pos.getY());
                p.setInteger("z", pos.getZ());
            } else
            {
                ModdingTest.logger.trace("There was no NBTs.");
                NBTTagCompound c = new NBTTagCompound();
                NBTTagCompound p = new NBTTagCompound();
                p.setInteger("x", pos.getX());
                p.setInteger("y", pos.getY());
                p.setInteger("z", pos.getZ());
                c.setTag("pos", p);
                stack.setTagCompound(c);
            }
            ModdingTest.logger.trace("BlockPos was saved.");
            return EnumActionResult.SUCCESS;
        } else
        {
            return EnumActionResult.PASS;
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ModdingTest.logger.info("ItemRemoteIgniter.onItemRightClick: Called.");
        if (!worldIn.isRemote)
        {
            NBTTagCompound i = playerIn.getHeldItem(handIn).getTagCompound();
            if (i != null && i.hasKey("pos"))
            {
                ModdingTest.logger.trace("NBT tag was avaliable.");
                NBTTagCompound c = i.getCompoundTag("pos");
                BlockPos pos = new BlockPos(c.getInteger("x"),c.getInteger("y"),c.getInteger("z"));
                ModdingTest.logger.trace(String.format("Position from NBT: %s", pos.toString()));
                if (worldIn.getBlockState(pos).getBlock() instanceof BlockTNT)
                {
                    ModdingTest.logger.trace(String.format("Block at %s was TNT Block.", pos.toString()));
                    tnt.explode(worldIn, pos, worldIn.getBlockState(pos), playerIn);
                    return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
                } else
                {
                    ModdingTest.logger.trace(String.format("Block at %s was not TNT Block.", pos.toString()));
                    i.removeTag("pos");
                    ModdingTest.logger.trace(String.format("NBT tag was removed."));
                }
            }
        }
        return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        NBTTagCompound c = stack.getTagCompound();
        if (c != null && c.hasKey("pos"))
        {
            NBTTagCompound d = c.getCompoundTag("pos");
            tooltip.add(String.format("Position : (%s, %s, %s)", d.getInteger("x"), d.getInteger("y"), d.getInteger("z")));
        }
    }
}
