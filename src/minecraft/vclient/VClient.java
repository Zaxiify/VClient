package vclient;

import org.lwjgl.opengl.Display;

import net.minecraft.client.Minecraft;
import vclient.event.EventManager;
import vclient.event.EventTarget;
import vclient.event.impl.ClientTick;
import vclient.hud.HUDConfigScreen;
import vclient.hud.mod.HudManager;
import vclient.mod.ModManager;
import vclient.ui.clickgui.ClickGUI;
import vclient.util.SessionChanger;
import vclient.util.config.Config;

public class VClient {
	
	public String NAME = "Vex Client", VERSION = "1.0", AUTHOR = "Zaxify", NAMEVER = NAME+ " " + VERSION;
	public String DISCORDURL = "DISCORD: dsc.gg/javacraft";
	public String YTURL = "YOUTUBE : bit.ly/2VJjMqA";
	public String DISCORDS = "SUPPORT: zaxify#1234 ON DISCORD";
	public static VClient INSTANCE = new VClient();
	public Minecraft mc = Minecraft.getMinecraft();
	
	public EventManager eventManager;
	public Config config;
	public ModManager modManager;
	public HudManager hudManager;
	
	public void startup() {
		eventManager = new EventManager();
		config = new Config();
		modManager = new ModManager();
		hudManager = new HudManager();
		
		//§
		
		// SET "username" TO SOMEONE WHO YOU WANT TO TEST AS!!!! also uncomment it you dumbass
		SessionChanger.getInstance().setUserOffline("ncai");
		
		config.loadModConfig();
		
		Display.setTitle("Vex Client v1.0 | MC 1.8.8");
		
		System.out.println("Starting " + NAMEVER + " by " + AUTHOR);
		
		eventManager.register(this);
		
		/* icon */
		String icon16x16 = "iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAMAAAAoLQ9TAAAABGdBTUEAALGPC/xhBQAAACBjSFJNAAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAABVlBMVEUAAAD///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////8yE6ggAAAAcXRSTlMAAAAAAAQHAAAADiUFDhsBCigjDgUuFzNQAxJIPhohNARcYwlCTBsDARFSGQKQZgWGyIZLDANZSg23VFPZQQcKAj+JMM1ErJEAGat+0jrNWQKR5c0lymkAT/u8CYSvHQMNBxbGkRaBcz8ZBCAWCyMeBlp80EoAAAABYktHRAH/Ai3eAAAACXBIWXMAAA7DAAAOwwHHb6hkAAAAB3RJTUUH5QoLBR4EwguGHAAAALFJREFUGNNjYCAIGFnZ2BkZOTgZ4QJc3DyMTLx8/IyMAoJCwowMjCKiYoxM4hKSjIxS0jKyQAFGOXkFRkUlRmUVVTV1DaBORk0tbR1dPX0DQyNjE5BJjKZm5haWVtY2tnb2DmABRkcnZxdXN3cPmEWMnl7ePr5+/nCLmQMCg4JDQsOArgkHCzIyRkRGRcfExsUnJDJCRJKSU1hS09IzMrOgAuzZOYyMuXn5BUyMhP3KAACmhxj15RWzZQAAACV0RVh0ZGF0ZTpjcmVhdGUAMjAyMS0xMC0xMVQwNTozMDowNCswMDowMCefkqcAAAAldEVYdGRhdGU6bW9kaWZ5ADIwMjEtMTAtMTFUMDU6MzA6MDQrMDA6MDBWwiobAAAAAElFTkSuQmCC";
		String icon32x32 = "iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAABGdBTUEAALGPC/xhBQAAACBjSFJNAAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAA7DAAAOwwHHb6hkAAAAB3RJTUUH5QoLBR4k+WWm1AAAAxVJREFUWMPt1j1vXFUQBuDnrDexTVgnJMGJ+AjBCQgEQggKRANUCCkUNDSUVPAzIEg0/AF+AhRUlCChSGmgAEtIgMBEAjsf2CTEcT5Ygy/FzN3cXNZrryWEEBlppbtz7pl5z/vOzD3ctv+7lfqhqqqmr4JSyg5CjmedVvJp7MNky/+PWbf1/270sIJlbLQ3JKhdydQf9TttthrgO4LRCfxZL9d7uvVDbriB+zLoFVzbJOhDOIglLIw44AN4Er8n4F8zx7foDyRo2KVE2cN+lCEydHAMj+LwFgz3hKxPJwP3YA7rm0mwjgs4ggOJ+Hrrnd3J0oHaMaJYl3EW32euy5mjqvd0m0HytCtJ3d5MslhVVTNJD/fijqRzmETdBHoJp0aB7A7xXc3foTzpeVFstc3ieEo1qJFMPo1X8BT2JJuf4suqqq4OAzIMQJXUH8MUfsQvjfUjydB5rDaS78VbeB3ncn1PxprBaVxusXlrETYWlhNcfdomvXPpr7CWvulM/obonjP4GJ+lDOsJcFsSyMAX8SAex3zKIpnp5f9aglczeYUP8J4ovg7uFLWyPixRuw2bLJzJzcdrFlKSuTzxSgY9iDfF9Pwc7+JsKUUpZaOUslpK6ZdSqvSNBtCwRdGCh/Fs+mZEYe7KdXhOFF0f76d827ZRANbElNufAGZFWx5Kqn/K954XLfcNPmmxuDMAjQDzok4exjPJxl152sVk4rF89+uUZSzrbLG+INppFi/jEdFaq6LHJ4UsRKtuGNO2AnBNFFYvqX4p/SuivSo3h1Rv3OQjATRkOC16+368mL5zog2vi0EFTwh5BlZV1S2/nTAA3+ErMfun0rck6mBDDJu+qJMTdeKWTWFiGJDtALghplpT358bzx/l+hpewwvYnYk6YmYcFZPwb/k2m4QDGTLQKdF2R4cAuIi3cVJ880+I78WCqKHfxGzoy5vQuAwQU/FD8QX8AV/UANPm8Y7omAlxtZsTF5BJN7+wVXtGbGtiJAszYuotiZoYBGvouk9c1+qOuJDMXWkBHg/AOPZvXe9v23/X/gKNa/zIc/xaKwAAACV0RVh0ZGF0ZTpjcmVhdGUAMjAyMS0xMC0xMVQwNTozMDozNiswMDowMD6PhG0AAAAldEVYdGRhdGU6bW9kaWZ5ADIwMjEtMTAtMTFUMDU6MzA6MzYrMDA6MDBP0jzRAAAAAElFTkSuQmCC";

		/** actually setting the icon */
		Minecraft.getMinecraft().setWindowIcon(icon16x16, icon32x32);
		
	}
		
	public void shutdown() {
		System.out.println("Shutting down " + NAMEVER);
		config.saveModConfig();
		eventManager.unregister(this);
	}
	
	@EventTarget
	public void onTick(ClientTick event) {
		if(mc.gameSettings.keyBindSprint.isPressed()) {
			modManager.toggleSprint.toggle();
		}
		if(mc.gameSettings.HUD_CONFIG.isPressed()) {
			mc.displayGuiScreen(new HUDConfigScreen());
		}
		if(mc.gameSettings.CLICK_GUI.isPressed()) {
			mc.displayGuiScreen(new ClickGUI());
		}
	}
	
}
