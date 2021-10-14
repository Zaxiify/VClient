package vclient.ui;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.io.IOException;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiAbout;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import vclient.VClient;
import vclient.fontrenderer.HyperiumFontRenderer;

public class MainMenu extends GuiScreen{
	
	boolean darkMode = false;
	
	Point p = MouseInfo.getPointerInfo().getLocation();
    
    int getMouseX = p.x;
    int getMouseY = p.y;
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		
//	    mc.getTextureManager().bindTexture(new ResourceLocation(BG));
//		this.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, this.width, this.height, this.width, this.height);
		Point p = MouseInfo.getPointerInfo().getLocation();
        
        int getMouseX = p.x;
        int getMouseY = p.y;
    	
    	mc.getTextureManager().bindTexture(new ResourceLocation("vclient/main_menu.png"));
        Gui.drawModalRectWithCustomSizedTexture(-21 + (getMouseX / 90), ((getMouseY * -1 / 90)), 0, 0, width + 20, height + 20, width + 21, height + 20);
		
		if(darkMode == true) {
			ResourceLocation BG = new ResourceLocation("vclient/dark_mode_main_menu.png");
		} else {
			ResourceLocation BG = new ResourceLocation("vclient/main_menu.png");
		}
		GlStateManager.pushMatrix();
		GlStateManager.translate(width/2f, height/2f, 0);
		GlStateManager.scale(3, 3, 1);
		GlStateManager.translate(-(width/2f), -(height/2f), 0);
		
		GlStateManager.popMatrix();
		super.drawScreen(mouseX, mouseY, partialTicks);
		HyperiumFontRenderer.customFontLight.drawCenteredString(VClient.INSTANCE.DISCORDURL, width/2f + 20, height/2f + 255 - mc.fontRendererObj.FONT_HEIGHT * 2f, 1);
		HyperiumFontRenderer.customFontLight.drawCenteredString(VClient.INSTANCE.YTURL, width/2f + 155, height/2f + 255 - mc.fontRendererObj.FONT_HEIGHT * 2f, 1);
		HyperiumFontRenderer.customFontLight.drawCenteredString(VClient.INSTANCE.DISCORDS, width/2f - 155, height/2f + 255 - mc.fontRendererObj.FONT_HEIGHT * 2f, 1);
		HyperiumFontRenderer.customFontLight.drawStringScaled(VClient.INSTANCE.NAMEVER, width/2 - 445, height/2 + 255 - mc.fontRendererObj.FONT_HEIGHT * 43, -1, 2.5);
		
	}
	
	@Override
	public void initGui() {
		this.buttonList.add(new GuiButton(1, 10, height / 2 - 40, "Test Worlds"));
		this.buttonList.add(new GuiButton(2, 10, height / 2 - 15, "Servers"));
		this.buttonList.add(new GuiButton(3, 10, height / 2 + 10, "Options n' Stuff"));
		this.buttonList.add(new GuiButton(4, 10, height / 2 + 35, "About"));
		this.buttonList.add(new GuiButton(5, 10, height / 2 - 245, "Rage Quit"));
		super.initGui();
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if(button.id == 1) {
			mc.displayGuiScreen(new GuiSelectWorld(this));
		}
		if(button.id == 2) {
			mc.displayGuiScreen(new GuiMultiplayer(this));
		}
		if(button.id == 3) {
			mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
		}
		if(button.id == 4) {
			mc.displayGuiScreen(new GuiAbout());
		}
		if(button.id == 5) {
			mc.shutdown();
		}
		super.actionPerformed(button);
	}
	
}
