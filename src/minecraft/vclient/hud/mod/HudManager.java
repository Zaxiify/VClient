package vclient.hud.mod;

import java.util.ArrayList;

import vclient.hud.mod.impl.FPSMod;
import vclient.hud.mod.impl.Keystrokes;
import vclient.hud.mod.impl.PlayerModelHUD;
import vclient.hud.mod.impl.TargetHUD;
import vclient.hud.mod.impl.TimeDisplay;
import vclient.mod.impl.Miniplayer;

public class HudManager {
	
	public ArrayList<HudMod> hudMods = new ArrayList<>();
	
	public FPSMod fps;
	public TargetHUD targetHud;
	public Keystrokes keystrokes;
	public Miniplayer miniPlayer;
	public TimeDisplay timeDisplay;
	
	public HudManager() {
		hudMods.add(fps = new FPSMod());
		hudMods.add(targetHud = new TargetHUD());
		hudMods.add(keystrokes = new Keystrokes());
		hudMods.add(miniPlayer = new Miniplayer());
		hudMods.add(timeDisplay = new TimeDisplay());
	}
	
	public void renderMods() {
		for(HudMod m : hudMods) {
			if(m.isEnabled()) {
			m.draw();
			}	
		}
	}
}
