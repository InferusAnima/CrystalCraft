package com.infr.crystalcraft;

import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.world.GameType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.Entity;

import java.util.HashMap;

public class MCreatorCreativeChamberEvent extends crystalcraft.ModElement {

	public MCreatorCreativeChamberEvent(crystalcraft instance) {
		super(instance);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorCreativeChamberEvent!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorCreativeChamberEvent!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorCreativeChamberEvent!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorCreativeChamberEvent!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorCreativeChamberEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((entity.isSneaking())) {
			world.playSound(
					(EntityPlayer) null,
					x,
					y,
					z,
					(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("block.end_gateway.spawn")),
					SoundCategory.NEUTRAL, (float) 10, (float) 1);
			world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
			if (world instanceof WorldServer)
				((WorldServer) world).spawnParticle(EnumParticleTypes.CRIT_MAGIC, x, y, z, (int) 1000, 3, 3, 3, 0.1, new int[0]);
			world.addWeatherEffect(new EntityLightningBolt(world, (int) (x + 4), (int) y, (int) z, false));
			world.addWeatherEffect(new EntityLightningBolt(world, (int) x, (int) y, (int) (z + 4), false));
			world.addWeatherEffect(new EntityLightningBolt(world, (int) (x - 4), (int) y, (int) z, false));
			world.addWeatherEffect(new EntityLightningBolt(world, (int) x, (int) y, (int) (z - 4), false));
			/*new MyTimer(1000, new MyTimerEvent() {

				@Override
				public void run() {
      				world.addWeatherEffect(new EntityLightningBolt(world, (int) (x + 4), (int) y, (int) z, false));
				}
			});
			new MyTimer(1000, new MyTimerEvent() {

				@Override
				public void run() {
      				world.addWeatherEffect(new EntityLightningBolt(world, (int) x, (int) y, (int) (z + 4), false));
				}
			});
			new MyTimer(1000, new MyTimerEvent() {

				@Override
				public void run() {
      				world.addWeatherEffect(new EntityLightningBolt(world, (int) (x - 4), (int) y, (int) z, false));
				}
			});
			new MyTimer(1000, new MyTimerEvent() {

				@Override
				public void run() {
      				world.addWeatherEffect(new EntityLightningBolt(world, (int) x, (int) y, (int) (z - 4), false));
				}
			});*/
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).setGameType(GameType.CREATIVE);
		}
	}
}
