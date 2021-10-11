package vclient.hud;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiClientSettings;
import net.minecraft.client.gui.GuiScreen;
import vclient.VClient;
import vclient.hud.mod.HudMod;
import vclient.ui.clickgui.ClickGUI;

public class HUDConfigScreen extends GuiScreen {
	
	@Override
	public void initGui() {
		super.initGui();
		this.buttonList.add(new GuiButton(6340, this.width / 2 - 50, this.height / 2 - 10, 115, 20, "Vex Client Settings"));
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		
		this.drawDefaultBackground();
		
		for(HudMod m : VClient.INSTANCE.hudManager.hudMods) {
			m.renderDummy(mouseX, mouseY);
		}
		
		super.drawScreen(mouseX, mouseY, partialTicks);
		
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		super.actionPerformed(button);
		switch(button.id) {
		case 6340:
			mc.displayGuiScreen(new GuiClientSettings());
		}
	}
	
}
