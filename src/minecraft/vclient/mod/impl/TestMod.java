package vclient.mod.impl;

import vclient.mod.Category;
import vclient.mod.Mod;

public class TestMod extends Mod {
	
	public TestMod() {
		super("TestMod", "Test Mod", Category.MISC);
	}
	
	@Override
	public void onEnable() {
		super.onEnable();
		
		System.out.println("THIS MOD IS ONNNNN!!");
	}
	
}
