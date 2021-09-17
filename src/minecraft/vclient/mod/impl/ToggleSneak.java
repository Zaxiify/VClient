package vclient.mod.impl;

import vclient.event.EventTarget;
import vclient.event.impl.EventUpdate;
import vclient.mod.Category;
import vclient.mod.Mod;

public class ToggleSneak extends Mod {
	
	public ToggleSneak() {
		super("ToggleSneak", "Toggle your crouching status", Category.MOVEMENT);
	}
	
	@EventTarget
	public void onUpdate(EventUpdate event) {
		if(this.isEnabled()) {
			mc.thePlayer.setSneaking(true);
		}
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
		
		mc.thePlayer.setSneaking(false);
	}
	
}
