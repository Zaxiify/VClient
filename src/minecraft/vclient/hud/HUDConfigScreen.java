package vclient.hud;

import net.minecraft.client.gui.GuiScreen;
import vclient.VClient;
import vclient.hud.mod.HudMod;

public class HUDConfigScreen extends GuiScreen {
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		
		this.drawDefaultBackground();
		
		for(HudMod m : VClient.INSTANCE.hudManager.hudMods) {
			m.renderDummy(mouseX, mouseY);
		}
		
		super.drawScreen(mouseX, mouseY, partialTicks);
		
	}
	
}
