package vclient.hud.mod;

import java.util.ArrayList;

import vclient.hud.mod.impl.CPSMod;
import vclient.hud.mod.impl.FPSMod;
import vclient.hud.mod.impl.Keystrokes;
import vclient.hud.mod.impl.PlayerModelHUD;
import vclient.hud.mod.impl.TargetHUD;
import vclient.hud.mod.impl.TestMod;

public class HudManager {
	
	public ArrayList<HudMod> hudMods = new ArrayList<>();
	
	public TestMod testMod;
	public FPSMod fps;
	public TargetHUD targetHud;
	public Keystrokes keystrokes;
	public CPSMod cps;
	
	public HudManager() {
		
//		hudMods.add(testMod = new TestMod());
		hudMods.add(fps = new FPSMod());
		hudMods.add(targetHud = new TargetHUD());
		hudMods.add(keystrokes = new Keystrokes());
		hudMods.add(cps = new CPSMod());
		
		
		
	}
	
	public void renderMods() {
		for(HudMod m : hudMods) {
			if(m.isEnabled()) {
			m.draw();
			}	
		}
	}
	
}
