package net.wildbill22.draco_too.proxies;

import net.wildbill22.draco.lib.LogHelper;
import net.wildbill22.draco_too.EntityDracoMia;
import net.wildbill22.draco_too.ModelDracoMia;
import net.wildbill22.draco_too.RenderDracoMia;
import cpw.mods.fml.client.registry.RenderingRegistry;

/** 
 * @author WILLIAM
 *
 */
public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderer(){
		// Dragons (not needed normally for player dragons)
		RenderingRegistry.registerEntityRenderingHandler(EntityDracoMia.class, 
				new RenderDracoMia(new ModelDracoMia(), 0.5F));		
	}
	
	@Override
	public void registerTileEntitySpecialRenderer(){		
	}

	@Override
	public void registerSounds() {}
	
	@Override
	public void registerSubscriptions() {
		super.registerSubscriptions();
		LogHelper.info("ClientProxy: Registering subscriptions");
	}
}
