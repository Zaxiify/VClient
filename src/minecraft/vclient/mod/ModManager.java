package vclient.mod;

import java.util.ArrayList;

import vclient.mod.impl.*;

public class ModManager {
	
	public TestMod testMod;
	public ToggleSprint toggleSprint;
	public ToggleSneak toggleSneak;

	public ArrayList<Mod> mods;
	
	public ModManager() {
		mods = new ArrayList<>();
		
		//Test
		mods.add(testMod = new TestMod());
		
		//Movement
		mods.add(toggleSprint = new ToggleSprint());
		mods.add(toggleSneak = new ToggleSneak());
		
	}
	
}
