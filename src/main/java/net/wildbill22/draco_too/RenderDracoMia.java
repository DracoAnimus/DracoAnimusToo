package net.wildbill22.draco_too;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.wildbill22.draco.entities.dragons.DragonRegistry.IDragonRendererCreationHandler;

public class RenderDracoMia extends RendererLivingEntity  implements IDragonRendererCreationHandler {
	protected ResourceLocation dragonTexture;
	
	public RenderDracoMia(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		this.renderManager = RenderManager.instance;
		setEntityTexture();
	}

	private void setEntityTexture() {
		// TODO: Set this to your texture
		dragonTexture = new ResourceLocation(REFERENCE.MODID + ":textures/models/dracoMia.png");
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity) {
		return dragonTexture;
	}

	@Override
	public String getKey() {
		return EntityDracoMia.name;
	}
}