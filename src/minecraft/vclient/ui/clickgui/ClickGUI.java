package vclient.ui.clickgui;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import vclient.VClient;
import vclient.ui.clickgui.comp.ModButton;

public class ClickGUI extends GuiScreen {
	
	ArrayList<ModButton> modButtons = new ArrayList<>();
	
	@Override
	public void initGui() {
		this.modButtons.add(new ModButton(210, 60, 44, mc.fontRendererObj.FONT_HEIGHT + 5, VClient.INSTANCE.hudManager.testMod));
		this.modButtons.add(new ModButton(270, 60, 55, mc.fontRendererObj.FONT_HEIGHT + 5, VClient.INSTANCE.hudManager.targetHud));
		this.modButtons.add(new ModButton(350, 60, 22, mc.fontRendererObj.FONT_HEIGHT + 5, VClient.INSTANCE.hudManager.fps));
		super.initGui();
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		ScaledResolution sr = new ScaledResolution(mc);
		super.drawScreen(mouseX, mouseY, partialTicks);
		
		Gui.drawRect(200, 50, sr.getScaledWidth() - 200, sr.getScaledHeight() - 50, new Color(0, 0, 0, 170).getRGB());
		
		for(ModButton m : modButtons) {
			m.draw();
		}
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
		for(ModButton m : modButtons) {
			m.onClick(mouseX, mouseY, mouseButton);
		}
	}

}
