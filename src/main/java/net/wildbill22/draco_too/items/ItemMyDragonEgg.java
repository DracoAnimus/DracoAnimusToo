package net.wildbill22.draco_too.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.wildbill22.draco.items.dragoneggs.ItemDragonEgg;
import net.wildbill22.draco_too.EntityDracoMia;
import net.wildbill22.draco_too.REFERENCE;

public class ItemMyDragonEgg extends ItemDragonEgg {
	// This name must be unique from all other dragons
	// TODO: Set this to match the texture name
	public static final String name = "myDragonEgg";

	public ItemMyDragonEgg() {
		super(name, REFERENCE.MODID);
		String dragonName = EntityDracoMia.name;
		
		// TODO: Add whatever dragon abilities you want and which foods it can eat here
		Abilities.addAbility(dragonName, Abilities.EAGLEDRAGON);
		this.addDragonFood(dragonName, Items.beef);
		this.addDragonFood(dragonName, Items.cooked_beef);
		this.addDragonFood(dragonName, Items.porkchop);
		this.addDragonFood(dragonName, Items.cooked_porkchop);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add(StatCollector.translateToLocal("egg.wildbill22_draco_putThisEgg"));
		list.add(StatCollector.translateToLocal("egg.wildbill22_draco_youWillGetStaff")); 
		// TODO: Enter the text for this in the lang file
		list.add(StatCollector.translateToLocal("egg.wildbill22_draco_too_intoMyDragon"));
	}
	
	@Override
	public String getEggName() {
		return name;
	}

	@Override
	public Item getEggItem() {
		return ModItems.myDragonEgg;
	}

	@Override
	public ItemStack getStaffItemStack() {
		return new ItemStack(ModItems.myDragonStaff);
	}
}
