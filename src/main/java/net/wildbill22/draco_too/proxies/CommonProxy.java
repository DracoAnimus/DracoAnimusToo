package net.wildbill22.draco_too.proxies;

import net.wildbill22.draco.lib.LogHelper;

/**
 * 
 * @author WILLIAM
 *
 */
public class CommonProxy {
	public void registerRenderer(){}
	
	public void registerTileEntitySpecialRenderer(){}
	
	public void registerSounds() {}
	
	public void registerSubscriptions() {
		LogHelper.info("CommonProxy: Registering subscriptions");
	}
}
