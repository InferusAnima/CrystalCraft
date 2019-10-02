package com.infr.crystalcraft.proxy;

import com.infr.crystalcraft.CrystalCraft;
import com.infr.crystalcraft.ModBlocks;
import com.infr.crystalcraft.blocks.furnace.BlockCrystalFurnace;
import com.infr.crystalcraft.blocks.furnace.TileCrystalFurnace;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {
    }

    public void init(FMLInitializationEvent e) {

        NetworkRegistry.INSTANCE.registerGuiHandler(CrystalCraft.instance, new GuiHandler());

    }

    public void postInit(FMLPostInitializationEvent e) {
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new BlockCrystalFurnace());
        GameRegistry.registerTileEntity(TileCrystalFurnace.class, CrystalCraft.MODID + "_crystal_furnace");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(ModBlocks.blockCrystalFurnace).setRegistryName(BlockCrystalFurnace.CRYSTAL_FURNACE));
    }
}

