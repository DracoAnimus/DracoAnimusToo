package net.wildbill22.draco_too.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.wildbill22.draco.Creative_Tab;
import net.wildbill22.draco_too.REFERENCE;

public class ModBlocks extends Block {
 	// Eggs
 	public static Block myDragonEgg;
	
	public static void preInit() {			
		// Eggs
		myDragonEgg = new BlockMyDragonEgg();
		GameRegistry.registerBlock(myDragonEgg, BlockMyDragonEgg.name);		
	}

	public static void init() {
	}

	/**
	 * Makes a block and sets most of its properties
	 * @param unlocalizedname
	 * @param texturename
	 * @param material
	 */
	public ModBlocks(String unlocalizedname, String texturename, Material material){
		super(material);
		
		setBlockName(unlocalizedname);
		setBlockTextureName(REFERENCE.MODID + ":" + unlocalizedname);
		setCreativeTab(Creative_Tab.TabDraco_Animus);
	}
}
