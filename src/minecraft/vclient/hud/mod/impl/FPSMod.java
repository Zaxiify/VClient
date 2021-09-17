package vclient.hud.mod.impl;

import java.awt.Color;

import net.minecraft.client.gui.Gui;
import vclient.hud.mod.HudMod;

public class FPSMod extends HudMod{

	public FPSMod() {
		super("FPS", 100, 100);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw() {
		//Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
		fr.drawStringWithShadow("�0[�6FPS: �f" + mc.getDebugFPS() + "�0]", getX(), getY(), -1);
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		
		fr.drawStringWithShadow("�0[�6FPS: �f" + mc.getDebugFPS() + "�0]", getX(), getY(), -1);
		
		super.renderDummy(mouseX, mouseY);
	}
	
	@Override
	public int getWidth() {
		return fr.getStringWidth("�0[�6FPS: �f" + mc.getDebugFPS() + "�0]");
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}

}
