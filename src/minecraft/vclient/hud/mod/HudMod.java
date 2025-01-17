package vclient.hud.mod;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import vclient.VClient;
import vclient.hud.DraggableComponent;
import vclient.setting.Setting;

public class HudMod {
	
	public Minecraft mc = Minecraft.getMinecraft();
	public FontRenderer fr = mc.fontRendererObj;
	
	public ArrayList<Setting> settings;
	
	public String name;
	public boolean enabled;
	public DraggableComponent drag;	
	
	//�
	
	public int x, y;
	
	public HudMod(String name, int x, int y) {
		this.name = name;
		try {
			//this.x = (int) VClient.INSTANCE.config.config.get(name.toLowerCase() + " x");
			//this.y = (int) VClient.INSTANCE.config.config.get(name.toLowerCase() + " y");
			this.setEnabled((boolean) VClient.INSTANCE.config.config.get(name.toLowerCase() + " enabled"));
		} catch (NullPointerException e) {
			this.x = x;
			this.y = y;
			this.enabled = false;
			System.err.println("Mods not loaded. Please check any dirty code. If that doesn't work, idk. Go ask zaxify or something.");
		}
		
		settings = new ArrayList<Setting>();
		drag = new DraggableComponent(this.x, this.y, getWidth(), getHeight(), new Color(0, 0, 0, 0).getRGB());
	}
	
	public void addSettings(Setting...sets) {
		this.settings.add((Setting) Arrays.asList(sets));
	}
	
	public int getWidth() {
		return 50;

	}
	
	public int getHeight() {
		return 50;
	}
	
	public void draw() {
	}
	
	public void renderDummy(int mouseX, int mouseY) {
		drag.draw(mouseX, mouseY);
	}
	
	public int getX() {
		return drag.getxPosition();
	}
	
	public int getY() {
		return drag.getyPosition();
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public void toggle() {
		this.setEnabled(enabled);
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
}
