package time;

/**
 * Implementa un conteo regresivo. Una vez alcanzado el tiempo 0:0, se detiene.
 */
public class Countdown implements Time_string_manager {

	private int seconds;
	private int minutes;

	private final int initialSeconds;
	private final int initialMinutes;

	private boolean isRunning;

	public Countdown(int seconds, int minutes) {	
		this.minutes = minutes;
		this.seconds = seconds;

		this.initialMinutes = minutes;
		this.initialSeconds = seconds;
		
		this.isRunning = true;
	}
	    
	public String getTime(){

		if(isRunning){
			seconds--;
	    	if(seconds < 0) {
	    		minutes -= 1;
	    	    seconds = 60;
	    	}

	    	if(minutes < 0) {
	    		isRunning = false;
				minutes = 0;
				seconds = 0;							
	    	}
		}

	    return minutes+":"+seconds;
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void reset() {
		minutes = initialMinutes;
		seconds = initialSeconds;
	}

	@Override		
	public String getTimeString(){
       return getTime();
	}
}
