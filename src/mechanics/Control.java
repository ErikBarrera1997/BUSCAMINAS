package mechanics;

import java.awt.event.ActionListener;
import javax.swing.JPanel;
import time.Countdown;
import time.Temporizer;

public class Control {

	protected static JPanel panel;
	protected static Temporizer temporizerTimer;
	protected static Countdown countdownTimer;
	protected static String timeFromTimers = "0";   //Almacena los contadores de los 2 timers
	public static Time timer;

	public static JPanel getPanel() {
		return panel;
	}

	public static void setPanel(JPanel p) {
		panel = p;
	}

	public static Temporizer getTemporizerTimer() {
		return temporizerTimer;
	}

	public static void setTemporizerTimer(Temporizer t) {
		temporizerTimer = t;
	}
	public static Countdown getCountdownTimer() {
		return countdownTimer;
	}

	public static void setCountdownTimer(Countdown c) {
		countdownTimer = c;
	}

	public static String getTimeFromTimers() {
		return timeFromTimers;
	}

	public static void setTimeFromTimers(String timeFromTimers) {
		Control.timeFromTimers = timeFromTimers;
	}

	public static Time getTimer() {
		return timer;
	}

	public static void setTimer(int mode, int delay, ActionListener actionListener) {
		Control.timer = new Time(mode, delay, actionListener);
	}
}


