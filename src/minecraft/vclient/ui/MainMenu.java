package vclient.ui;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.io.IOException;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiAbout;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import vclient.Client;
import vclient.VClient;
import vclient.fontrenderer.HyperiumFontRenderer;

public class MainMenu extends GuiScreen{
	
	public static boolean darkMode = false;
	
	Point p = MouseInfo.getPointerInfo().getLocation();
    
    int getMouseX = p.x;
    int getMouseY = p.y;
    
    ResourceLocation mainMenu = new ResourceLocation("vclient/dark_mode_main_menu.png");
    
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		
//		DRPC MAIN MENU
		
		Client.getInstance().getDiscordRP().update("Main Menu", "Idle");
		
		
//		NORMAL BACKGROUND WITHOUT PARALLAX
		
//	    mc.getTextureManager().bindTexture(new ResourceLocation(BG));
//		this.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, this.width, this.height, this.width, this.height);
		
//		PARALLAX BACKGROUND
		
		Point p = MouseInfo.getPointerInfo().getLocation();
        
        int getMouseX = p.x;
        int getMouseY = p.y;
        
//		DARK MODE
        
        if(VClient.INSTANCE.darkMode == true) {
        	mainMenu = new ResourceLocation("vclient/dark_mode_main_menu.png");
        } else {
            mainMenu = new ResourceLocation("vclient/main_menu.png");
        }

//		BINDING TEXTURE TO MAIN MENU (mess around with this if you want to change the bg image or change the dark mode t    	hingy)        
        
    	mc.getTextureManager().bindTexture(mainMenu);
        Gui.drawModalRectWithCustomSizedTexture(-21 + (getMouseX / 90), ((getMouseY * -1 / 90)), 0, 0, width + 20, height + 20, width + 21, height + 20);
		
		
		GlStateManager.pushMatrix();
		GlStateManager.translate(width/2f, height/2f, 0);
		GlStateManager.scale(3, 3, 1);
		GlStateManager.translate(-(width/2f), -(height/2f), 0);
		
		GlStateManager.popMatrix();
		super.drawScreen(mouseX, mouseY, partialTicks);
		HyperiumFontRenderer.customFontLight.drawCenteredString(VClient.INSTANCE.DISCORDURL, width/2f + 20, height/2f + 255 - mc.fontRendererObj.FONT_HEIGHT * 2f, 1);
		HyperiumFontRenderer.customFontLight.drawCenteredString(VClient.INSTANCE.YTURL, width/2f + 155, height/2f + 255 - mc.fontRendererObj.FONT_HEIGHT * 2f, 1);
		HyperiumFontRenderer.customFontLight.drawCenteredString(VClient.INSTANCE.DISCORDS, width/2f - 155, height/2f + 255 - mc.fontRendererObj.FONT_HEIGHT * 2f, 1);
		
//		TITLE TEXT - Removed bcuz I replace with img :D
		
//		HyperiumFontRenderer.customFontLight.drawStringScaled(VClient.INSTANCE.NAMEVER, width/2 - 75, height/2 + 255 - mc.fontRendererObj.FONT_HEIGHT * 43, -1, 4);
		
// 		TITLE IMG - Its located in vclient/logo.png
		mc.getTextureManager().bindTexture(new ResourceLocation("vclient/vclient-logo.png"));
		Gui.drawModalRectWithCustomSizedTexture(width/2, height/2, width/2, height/2, width/2, height/2, width/2, height/2);
		
	}
	
	@Override
	public void initGui() {
		this.buttonList.add(new GuiButton(1, 375, height / 2 - 40, "Test Worlds"));
		this.buttonList.add(new GuiButton(2, 375, height / 2 - 15, "Servers"));
		this.buttonList.add(new GuiButton(3, 375, height / 2 + 10, "Options n' Stuff"));
		this.buttonList.add(new GuiButton(4, 375, height / 2 + 35, "About"));
		this.buttonList.add(new GuiButton(5, 10, height / 2 - 245, "Rage Quit"));
		this.labelList.add(new GuiLabel(fontRendererObj, 6, 375, height / 2 + 50, getMouseX, getMouseX, getMouseX));
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
