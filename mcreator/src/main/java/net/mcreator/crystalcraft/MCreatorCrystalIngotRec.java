package net.mcreator.crystalcraft;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

public class MCreatorCrystalIngotRec extends crystalcraft.ModElement {

	public MCreatorCrystalIngotRec(crystalcraft instance) {
		super(instance);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(MCreatorCrystalOre.block, (int) (1)), new ItemStack(MCreatorCrystalIngot.block, (int) (1)), 1F);
	}
}
