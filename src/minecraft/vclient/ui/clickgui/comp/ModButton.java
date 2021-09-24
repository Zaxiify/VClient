package vclient.ui.clickgui.comp;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import vclient.hud.mod.HudMod;

public class ModButton {

	public int x, y, w, h;
	public HudMod m;
	
	public ModButton(int x, int y, int w, int h, HudMod m) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.m = m;
	}
	
	public void draw() {
		Gui.drawRect(x, y, x + w, y + h, new Color(0, 0, 0, 170).getRGB());
		
		//SHITTY FUCKING SHIT GOD DAMN IT IVE BEEN STARING AT THIS FOR 5 HOURS ITS 4 AM AUISDHUABUSHFDBFBFKBFBFDJBHJDSFFFFFGvvvvvvvvvvvvvvvvv
		Minecraft.getMinecraft().fontRendererObj.drawString(m.name, x + 2, y + 2, getColor());
	}
	
	public int getColor() {
		if(m.isEnabled()) {
			return new Color(0, 255, 0, 255).getRGB();
		} else {
			return new Color(255, 0, 0, 255).getRGB();
		}
	}
	
	public void onClick(int mouseX, int mouseY, int button) {
		if(mouseX >= x && mouseX <= x + w && mouseY >= y && mouseY <= y + h) {
			if(m.isEnabled()) {
				m.setEnabled(false);
				System.out.println(m.name);
			} else {
				m.setEnabled(true);
				System.out.println(m.name);
			}
			System.out.println(m.name + " was toggled.");
		}
	}
	
	
}
