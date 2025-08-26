package mechanics;

import javax.swing.JPanel;

public class Control {

	protected static JPanel panel;
	protected static Temporizer timer;
	protected static Temporizer countdown;

	public static JPanel getPanel() {
		return panel;
	}

	public static void setPanel(JPanel p) {
		panel = p;
	}

	public static Temporizer getTimer() {
		return timer;
	}

	public static void setTimer(Temporizer timer) {
		Control.timer = timer;
	}
	
	
	
		
}
