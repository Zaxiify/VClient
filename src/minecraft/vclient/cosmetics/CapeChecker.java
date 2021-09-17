package vclient.cosmetics;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;

public class CapeChecker {
	
	public static boolean ownsCape(AbstractClientPlayer entitylivingbaseIn) {
		if(entitylivingbaseIn.getName().equals("_everythingg")) {
			return true;
		} else if(entitylivingbaseIn.getName().equals("utxc")) {
			return true;
		} else if(entitylivingbaseIn.getName().equals("bblc")) {
			return true;
		} else if(entitylivingbaseIn.getName().equals("V_XV")) {
			return true;
		} else if(entitylivingbaseIn.getName().equals("nova_xx")) {
			return true;
		}
		
		
		
		
		
		else return false;
	}
	
}
