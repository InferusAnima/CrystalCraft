package com.infr.crystalcraft.proxy;

import com.infr.crystalcraft.blocks.furnace.ContainerCrystalFurnace;
import com.infr.crystalcraft.blocks.furnace.GuiCrystalFurnace;
import com.infr.crystalcraft.blocks.furnace.TileCrystalFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

public class GuiHandler implements IGuiHandler {

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TileCrystalFurnace) {
            return new ContainerCrystalFurnace(player.inventory, (TileCrystalFurnace) te);
        }
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TileCrystalFurnace) {
            TileCrystalFurnace containerTileEntity = (TileCrystalFurnace) te;
            return new GuiCrystalFurnace(containerTileEntity, new ContainerCrystalFurnace(player.inventory, containerTileEntity));
        }
        return null;
    }

}
