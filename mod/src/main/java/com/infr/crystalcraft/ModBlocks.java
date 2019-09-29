package com.infr.crystalcraft;

import com.infr.crystalcraft.blocks.furnace.BlockCrystalFurnace;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

    @GameRegistry.ObjectHolder("crystalcraft:crystal_furnace")
    public static BlockCrystalFurnace blockCrystalFurnace;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        blockCrystalFurnace.initModel();
    }

}
