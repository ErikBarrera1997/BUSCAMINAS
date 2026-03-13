package time;

public class Control {

    public static Temporizer temporizerTimer;
	public static Countdown countdownTimer;
    protected static String timeFromTimers = "0";   //Almacena los contadores de los 2 timers

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
}
