package net.wildbill22.draco_too.items;

import net.minecraft.item.Item;
import net.wildbill22.draco.Creative_Tab;
import net.wildbill22.draco.entities.dragons.DragonRegistry;
import net.wildbill22.draco.entities.dragons.DragonRegistry.IDragonEggHandler;
import net.wildbill22.draco_too.REFERENCE;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems extends Item {
	// All items in the mod:
	public static Item myDragonEgg;
	public static Item myDragonStaff;

	public static void preInit() {		
		// Weapons
		myDragonStaff = new ItemMyDragonStaff(net.wildbill22.draco.items.weapons.ModWeapons.STAFF);
		GameRegistry.registerItem(myDragonStaff, ItemMyDragonStaff.name);

		// Dragon Food - only dragons can eat this food! Register foods before eggs!
		// In wiki: Food points, Saturation ration. Potion has: id, seconds effect lasts, level (0 - X, depends on potion)
//		GameRegistry.registerItem(villagerHeart = new ItemModFood("villagerHeart", 4, 0.6f, false), "villagerHeart");
		// Poison, like potatoes

		// Eggs created after food has been registered (else null pointer exception)
		myDragonEgg = new ItemMyDragonEgg();
		GameRegistry.registerItem(myDragonEgg, ItemMyDragonEgg.name);

		// Dragon Egg Registry
		DragonRegistry.instance().registerDragonEgg((IDragonEggHandler) myDragonEgg);		
	}

	public static void init() {
		// Mod items
	}
	
	/**
	 * Makes a item and sets most of its properties
	 * @param unlocalizedname
	 * @param texturename
	 */
	public ModItems(String unlocalizedname, String texturename){
		super();
		
		this.setCreativeTab(Creative_Tab.TabDraco_Animus);
		this.setUnlocalizedName(REFERENCE.Unlocalized_Path + unlocalizedname);
		this.setTextureName(REFERENCE.Texture_Path + texturename);
	}
	
	/**
	 * Makes a item and sets most of its properties
	 * Use this one when you want to use registerIcons
	 * @param unlocalizedname
	 */
	public ModItems(String unlocalizedname) {
		super();		

		this.setCreativeTab(Creative_Tab.TabDraco_Animus);
		this.setUnlocalizedName(REFERENCE.Unlocalized_Path + unlocalizedname);
	}	
}
