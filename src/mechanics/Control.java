package mechanics;

import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class Control {

	protected static JPanel panel;
	public static Time timer;

	public static JPanel getPanel() {
		return panel;
	}

	public static void setPanel(JPanel p) {
		panel = p;
	}

	public static Time getTimer() {
		return timer;
	}

	/**
	 * Initializes the timer Thread 
	 * @param mode
	 * @param delay
	 * @param actionListener
	 */
	public static void setTimer(int delay, ActionListener actionListener) {
		Control.timer = new Time(delay, actionListener);
	}
}


