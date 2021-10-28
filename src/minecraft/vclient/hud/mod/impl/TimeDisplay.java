package vclient.hud.mod.impl;

import java.awt.Color;

import net.minecraft.client.gui.Gui;
import vclient.Client;
import vclient.hud.mod.HudMod;

public class TimeDisplay extends HudMod{

	public TimeDisplay() {
		super("Time Display", 100, 100);
	}
	
	@Override
	public void draw() {
		//Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
		fr.drawStringWithShadow("§0" + "time thingy" + "§f§0]", getX(), getY(), -1);
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		
		fr.drawStringWithShadow("§0" + mc.getSystemTime() + "§f§0]", getX(), getY(), -1);
		
		super.renderDummy(mouseX, mouseY);
	}
	
	@Override
	public int getWidth() {
		return fr.getStringWidth("§0" + mc.getSystemTime() + "§f§0]");
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}

}
