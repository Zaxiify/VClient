package vclient.installer;

public class FeedbackHandler {
	
	//Called from the JS
	public void close() {
		Installer.getInstance().stopTheApplication();
	}

}