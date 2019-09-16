package com.infr.crystalcraft;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.potion.Potion;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.Block;

import java.util.function.Supplier;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

@Mod(modid = crystalcraft.MODID, version = crystalcraft.VERSION)
public class crystalcraft implements IFuelHandler, IWorldGenerator {

	public static final String MODID = "crystalcraft";
	public static final String VERSION = "1.0.0";
	@SidedProxy(clientSide = "com.infr.crystalcraft.ClientProxycrystalcraft", serverSide = "com.infr.crystalcraft.CommonProxycrystalcraft")
	public static CommonProxycrystalcraft proxy;
	@Instance(MODID)
	public static crystalcraft instance;
	public final List<ModElement> elements = new ArrayList<>();
	public final List<Supplier<Block>> blocks = new ArrayList<>();
	public final List<Supplier<Item>> items = new ArrayList<>();
	public final List<Supplier<Biome>> biomes = new ArrayList<>();
	public final List<Supplier<EntityEntry>> entities = new ArrayList<>();
	public final List<Supplier<Potion>> potions = new ArrayList<>();

	public crystalcraft() {
		FluidRegistry.enableUniversalBucket();
		elements.add(new MCreatorCrystalOre(this));
		elements.add(new MCreatorCrystalIngot(this));
		elements.add(new MCreatorCrystalTab(this));
		elements.add(new MCreatorCreativeChamber(this));
		elements.add(new MCreatorCreativeChamberEvent(this));
		elements.add(new MCreatorAquaAuraTier1(this));
		elements.add(new MCreatorAquaAuraTier2(this));
		elements.add(new MCreatorAquaAuraTier3(this));
		elements.add(new MCreatorAquaAuraTier4(this));
		elements.add(new MCreatorAquaAuraTier5(this));
		elements.add(new MCreatorAquaAuraTier6(this));
		elements.add(new MCreatorAquaAuraTier7(this));
		elements.add(new MCreatorAquaAuraTier8(this));
		elements.add(new MCreatorAquaAuraTier9(this));
		elements.add(new MCreatorAquaAuraTier10(this));
		elements.add(new MCreatorAquaAuraTier11(this));
		elements.add(new MCreatorAquaAuraTier12(this));
		elements.add(new MCreatorAquaAuraTier13(this));
		elements.add(new MCreatorAquaAuraTier14(this));
		elements.add(new MCreatorAquaAuraTier15(this));
		elements.add(new MCreatorAquaAuraTier16(this));
		elements.add(new MCreatorAquaAuraTier17(this));
		elements.add(new MCreatorAquaAuraTier18(this));
		elements.add(new MCreatorAquaAuraTier19(this));
		elements.add(new MCreatorAquaAuraTier20(this));
		elements.add(new MCreatorAquaAuraTier21(this));
		elements.add(new MCreatorAquaAuraTier22(this));
		elements.add(new MCreatorAquaAuraTier23(this));
		elements.add(new MCreatorAquaAuraTier24(this));
		elements.add(new MCreatorAquaAuraTier25(this));
		elements.add(new MCreatorCrystal(this));
		elements.add(new MCreatorCrystalChamber(this));
		elements.add(new MCreatorCrystalChamberEvent(this));
		elements.add(new MCreatorCrystalChamberGUI(this));
		elements.add(new MCreatorCrystalChamberGUIOpen(this));
		elements.add(new MCreatorCrystalIngotRec(this));
	}

	@Override
	public int getBurnTime(ItemStack fuel) {
		for (ModElement element : elements) {
			int ret = element.addFuel(fuel);
			if (ret != 0)
				return ret;
		}
		return 0;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator cg, IChunkProvider cp) {
		elements.forEach(element -> element.generateWorld(random, chunkX * 16, chunkZ * 16, world, world.provider.getDimension(), cg, cp));
	}

	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(blocks.stream().map(Supplier::get).toArray(Block[]::new));
	}

	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(items.stream().map(Supplier::get).toArray(Item[]::new));
	}

	@SubscribeEvent
	public void registerBiomes(RegistryEvent.Register<Biome> event) {
		event.getRegistry().registerAll(biomes.stream().map(Supplier::get).toArray(Biome[]::new));
	}

	@SubscribeEvent
	public void registerEntities(RegistryEvent.Register<EntityEntry> event) {
		event.getRegistry().registerAll(entities.stream().map(Supplier::get).toArray(EntityEntry[]::new));
	}

	@SubscribeEvent
	public void registerPotions(RegistryEvent.Register<Potion> event) {
		event.getRegistry().registerAll(potions.stream().map(Supplier::get).toArray(Potion[]::new));
	}

	@SubscribeEvent
	public void registerSounds(RegistryEvent.Register<net.minecraft.util.SoundEvent> event) {
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		elements.forEach(element -> element.registerModels(event));
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
		GameRegistry.registerFuelHandler(this);
		GameRegistry.registerWorldGenerator(this, 5);
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		elements.forEach(element -> element.preInit(event));
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		elements.forEach(element -> element.init(event));
		proxy.init(event);
	}

	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		elements.forEach(element -> element.serverLoad(event));
	}

	public static class GuiHandler implements IGuiHandler {

		@Override
		public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
			if (id == MCreatorCrystalChamberGUI.GUIID)
				return new MCreatorCrystalChamberGUI.GuiContainerMod(world, x, y, z, player);
			return null;
		}

		@Override
		public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
			if (id == MCreatorCrystalChamberGUI.GUIID)
				return new MCreatorCrystalChamberGUI.GuiWindow(world, x, y, z, player);
			return null;
		}
	}

	public static class ModElement {

		public static crystalcraft instance;

		public ModElement(crystalcraft instance) {
			this.instance = instance;
		}

		public void init(FMLInitializationEvent event) {
		}

		public void preInit(FMLPreInitializationEvent event) {
		}

		public void generateWorld(Random random, int posX, int posZ, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
		}

		public void serverLoad(FMLServerStartingEvent event) {
		}

		public void registerModels(ModelRegistryEvent event) {
		}

		public int addFuel(ItemStack fuel) {
			return 0;
		}
	}
}
