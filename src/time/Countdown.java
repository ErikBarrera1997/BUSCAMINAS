package time;

/**
 * Implementa un conteo regresivo. Una vez alcanzado el tiempo 0:0, se detiene.
 */
public class Countdown implements Time_string_manager {

	private int seconds;
	private int minutes;

	private final int initialSeconds;
	private final int initialMinutes;

	private boolean activated = false;

	public Countdown(int seconds, int minutes) {	
		this.minutes = minutes;
		this.seconds = seconds;

		this.initialMinutes = minutes;
		this.initialSeconds = seconds;
		
		this.activated = true;
	}
	    
	public String getTime(){

		if(activated){
			seconds--;
	    	if(seconds < 0) {
	    		minutes -= 1;
	    	    seconds = 59;
	    	}

	    	if(minutes < 0) {
	    		activated = false;
				minutes = 0;
				seconds = 0;							
	    	}
		}

	    return minutes+":"+seconds;
	}

	public boolean isActivated() {
		return activated;
	}

	public void reset() {
		minutes = initialMinutes;
		seconds = initialSeconds;
	}

	public void setActivated(boolean status){
		activated = status;
	}

	@Override		
	public String getTimeString(){
       return getTime();
	}
}
