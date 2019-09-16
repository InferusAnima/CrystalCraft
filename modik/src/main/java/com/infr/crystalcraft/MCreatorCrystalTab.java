package com.infr.crystalcraft;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

public class MCreatorCrystalTab extends crystalcraft.ModElement {

	public MCreatorCrystalTab(crystalcraft instance) {
		super(instance);
	}

	public static CreativeTabs tab = new CreativeTabs("tabcrystaltab") {

		@SideOnly(Side.CLIENT)
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(MCreatorCrystalIngot.block, (int) (1));
		}

		@SideOnly(Side.CLIENT)
		public boolean hasSearchBar() {
			return true;
		}
	}.setBackgroundImageName("item_search.png");
}
