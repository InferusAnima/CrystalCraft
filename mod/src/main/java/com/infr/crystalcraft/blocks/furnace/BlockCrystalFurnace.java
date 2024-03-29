package com.infr.crystalcraft.blocks.furnace;

import com.infr.crystalcraft.CrystalCraft;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class BlockCrystalFurnace extends Block implements ITileEntityProvider {


    public static final PropertyDirection FACING = PropertyDirection.create("facing");

    public static final ResourceLocation CRYSTAL_FURNACE = new ResourceLocation(CrystalCraft.MODID, "crystal_furnace");

    public BlockCrystalFurnace() {
        super(Material.IRON);
        setRegistryName(CRYSTAL_FURNACE);
        setHarvestLevel("pickaxe", 1);
        setCreativeTab(CrystalCraft.tabCrystalCraft);
        setTranslationKey(CrystalCraft.MODID + ".crystal_furnace");

        setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileCrystalFurnace();
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        // Only execute on the server
        if (world.isRemote) {
            return true;
        }
        TileEntity te = world.getTileEntity(pos);
        if (!(te instanceof TileCrystalFurnace)) {
            return false;
        }
        player.openGui(CrystalCraft.instance, 0, world, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {

        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));

    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getDirectionFromEntityLiving(pos, placer));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this,new IProperty[] {FACING});
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.byIndex(meta & 7));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getIndex();
    }
}
