package net.wildbill22.draco_too.items;

import net.wildbill22.draco.items.weapons.staffs.ItemDragonStaff;
import net.wildbill22.draco_too.EntityDracoMia;
import net.wildbill22.draco_too.REFERENCE;

public class ItemMyDragonStaff extends ItemDragonStaff {
	// TODO: Set this to the texture name for the staff
	public static final String name = "myDragonStaff";
	
	public ItemMyDragonStaff(ToolMaterial material) {
		super(material, name, REFERENCE.MODID);
		
		// TODO: Set the name of the dragon that you will see in game and add the staff abilities you want
		abilities.addChangeForm(EntityDracoMia.name, "My dragon");
		abilities.addSoundWaveEntities();
		abilities.addPickUpMobs();
	}
	
	// Used to find if egg is in hoard
	@Override
	public String getEggName() {
		return ItemMyDragonEgg.name;
	}
}