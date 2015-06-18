package net.wildbill22.draco_too;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.wildbill22.draco.lib.BALANCE;
import net.wildbill22.draco.lib.LogHelper;
import net.wildbill22.draco_too.blocks.ModBlocks;
import cpw.mods.fml.common.IWorldGenerator;

/**
 * 
 * @author WILLIAM
 *
 */
public class WorldGenDracoAnimus implements IWorldGenerator {

	private void addSurfaceStructures(World world, Random random, int x, int z) {
		int chance = random.nextInt(1000);
		BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(x, z);

		// Eggs with the normal spawn chance from the configuration
		int spawnChance = BALANCE.DRAGON_EGG_SPAWN_CHANCE;
		if (chance < spawnChance) {
			// TODO: Set which biomes you want the egg to appear in
			if (biome == BiomeGenBase.extremeHills || biome == BiomeGenBase.extremeHillsEdge || biome == BiomeGenBase.extremeHillsPlus) {
				if (generateDragonEgg(world, random, x, world.getTopSolidOrLiquidBlock(x, z), z, ModBlocks.myDragonEgg))
					LogHelper.info("WorldGenDracoAnimus: Spawned a Draco Mia Egg at: " + x + "," + world.getTopSolidOrLiquidBlock(x, z) + "," + z); 
			}
		}
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

		switch (world.provider.dimensionId) {
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
		case 1:
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	private void generateEnd(World world, Random random, int x, int z) {
	}

	private void generateNether(World world, Random random, int x, int z) {
	}

	private void generateSurface(World world, Random random, int x, int z) {
		addSurfaceStructures(world, random, x, z);
	}
	
	// Place just one egg
    public boolean generateDragonEgg(World world, Random random, int x, int y, int z, Block eggBlock) {
        for (int l = 0; l < 32; ++l) {
            int chunkX = x + random.nextInt(8) - random.nextInt(8);
            int chunkY = y + random.nextInt(4) - random.nextInt(4);
            int chunkZ = z + random.nextInt(8) - random.nextInt(8);

            if ((world.isAirBlock(chunkX, chunkY, chunkZ) || world.getBlock(chunkX, chunkY, chunkZ) == Blocks.water) 
            		&& eggBlock.canPlaceBlockAt(world, chunkX, chunkY, chunkZ) && !world.isAirBlock(chunkX, chunkY-1, chunkZ)) {
                world.setBlock(chunkX, chunkY, chunkZ, eggBlock);
                return true;
            }
        }
        return false;
    }
}
