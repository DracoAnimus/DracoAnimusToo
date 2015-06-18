package net.wildbill22.draco_too;

import net.wildbill22.draco_too.blocks.ModBlocks;
import net.wildbill22.draco.entities.dragons.DragonRegistry;
import net.wildbill22.draco_too.items.ModItems;
import net.wildbill22.draco_too.proxies.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
	
/** 
 * @author WILLIAM
 *
 */
@Mod(modid = REFERENCE.MODID, name = REFERENCE.NAME, version = REFERENCE.VERSION, dependencies = "required-after: wildbill22_draco")
public class Core {

	@SidedProxy(clientSide = "net.wildbill22.draco_too.proxies.ClientProxy", serverSide = "net.wildbill22.draco_too.proxies.CommonProxy")
	public static CommonProxy draco_tooProxy;

	@Instance(REFERENCE.MODID)
	public static Core instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		ModItems.preInit();
		ModBlocks.preInit();
		draco_tooProxy.registerRenderer();
	}

	@EventHandler
	public static void Init(FMLInitializationEvent event) {
		ModItems.init();
		ModBlocks.init();
		draco_tooProxy.registerSounds();
		draco_tooProxy.registerSubscriptions();
		// Dragons
		RenderDracoMia daHandler = new RenderDracoMia(new ModelDracoMia(), 0.5F);        // Eagle Dragon
		DragonRegistry.instance().registerDragonRendererCreationHandler(daHandler);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}	
}
