package com.infr.crystalcraft;

  import com.infr.crystalcraft.proxy.CommonProxy;
  import net.minecraft.creativetab.CreativeTabs;
  import net.minecraft.init.Blocks;
  import net.minecraft.item.ItemStack;
  import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = CrystalCraft.MODID, name = CrystalCraft.NAME, version = CrystalCraft.VERSION, dependencies = "required-after:forge@[14.23.5.2768,)", useMetadata = true)
public class CrystalCraft
{
    public static final String MODID = "crystalcraft";
    public static final String NAME = "Crystal Craft";
    public static final String VERSION = "1.0";

    @SidedProxy(clientSide = "com.infr.crystalcraft.proxy.ClientProxy", serverSide = "com.infr.crystalcraft.proxy.ServerProxy")
    public static CommonProxy proxy;

    public static CreativeTabs tabCrystalCraft = new CreativeTabs("crystalcraft") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.blockCrystalFurnace);
        }
    };

    @Mod.Instance
    public static CrystalCraft instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
        //logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getLocalizedName());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);

    }


}
