package net.minecraft.client.gui;

import java.awt.Color;
import java.io.IOException;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.ResourceLocation;
import optifine.Config;
import optifine.GuiAnimationSettingsOF;
import optifine.GuiDetailSettingsOF;
import optifine.GuiOptionButtonOF;
import optifine.GuiOptionSliderOF;
import optifine.GuiOtherSettingsOF;
import optifine.GuiPerformanceSettingsOF;
import optifine.GuiQualitySettingsOF;
import optifine.Lang;
import optifine.TooltipManager;
import shadersmod.client.GuiShaders;

public class GuiAbout extends GuiScreen
{
    private GuiScreen parentGuiScreen;
    protected String screenTitle = "About Vex Client";

    /**
     * Adds the buttons (and other controls) to the screen in question. Called when the GUI is displayed and when the
     * window resizes, the buttonList is cleared beforehand.
     */
    public void initGui()
    {
        this.screenTitle = I18n.format("About Vex Client ", new Object[0]);
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 370, I18n.format("gui.done", new Object[0])));
    }

    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
    protected void actionPerformed(GuiButton button) throws IOException
    {
        if (button.enabled)
        { 
            if (button.id == 200)
            {
                this.mc.displayGuiScreen(this.parentGuiScreen);
            }
        }
    }

    /**
     * Draws the screen and all the components in it. Args : mouseX, mouseY, renderPartialTicks
     */
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
    	Gui.drawRect(this.width, this.height, this.width, this.height, new Color(215, 215, 215, 255).getRGB());
    	mc.getTextureManager().bindTexture(new ResourceLocation("vclient/about_bg.png"));
		this.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, this.width, this.height, this.width, this.height);
        this.drawCenteredString(this.fontRendererObj, this.screenTitle, this.width / 2, 15, 16777215);
        String s = "Optifine installed, but not detected. Please relaunch or reinstall.";
        String s1 = "HD_U";

        if (s1.equals("HD"))
        {
            s = "OptiFine HD H8 included!";
        }

        if (s1.equals("HD_U"))
        {
            s = "Optifine HD H8 Ultra included!";
        }

        if (s1.equals("L"))
        {
            s = "OptiFine H8 Light included!";
        }

        this.drawString(this.fontRendererObj, s, this.width - 950, this.height - 20, -1);
        String s2 = "";
        int playWidth = this.width - 543; 
        int madeWidth = this.width - 520;
        int playHeight = this.height - 300;
        int madeHeight = this.height - 450;
        int thxHeight = this.height - 42069;
        int thxWidth = this.width - 42069;
        
        int i = this.fontRendererObj.getStringWidth(s2);
        
        this.drawString(this.fontRendererObj, "§b" + s2, this.width - 85, this.height - 20, -1);
        this.drawString(this.fontRendererObj, "§bMade by Zaxify", madeWidth, madeHeight, -1);
        this.drawString(this.fontRendererObj, "Playtested by Downrest", playWidth, playHeight, new Color(255, 0, 0, 0).getRGB());
        this.drawString(this.fontRendererObj, "Special thanks to:", playWidth, playHeight, new Color(255, 0, 0, 0).getRGB());
        this.drawString(this.fontRendererObj, "Downrest", this.width + 50, madeHeight, new Color(0, 255, 0, 0).getRGB());
        
        
        
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    public static int getButtonWidth(GuiButton p_getButtonWidth_0_)
    {
        return p_getButtonWidth_0_.width;
    }

    public static int getButtonHeight(GuiButton p_getButtonHeight_0_)
    {
        return p_getButtonHeight_0_.height;
    }

    public static void drawGradientRect(GuiScreen p_drawGradientRect_0_, int p_drawGradientRect_1_, int p_drawGradientRect_2_, int p_drawGradientRect_3_, int p_drawGradientRect_4_, int p_drawGradientRect_5_, int p_drawGradientRect_6_)
    {
        p_drawGradientRect_0_.drawGradientRect(p_drawGradientRect_1_, p_drawGradientRect_2_, p_drawGradientRect_3_, p_drawGradientRect_4_, p_drawGradientRect_5_, p_drawGradientRect_6_);
    }
}
