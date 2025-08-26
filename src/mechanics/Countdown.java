package mechanics;

import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Countdown extends Timer{

	private int seconds;
	private int minutes;
	
	    public Countdown(int delay, ActionListener listener, int seconds, int minutes) {
		    super(delay, listener);		
		    this.minutes = minutes;
		    this.seconds = seconds;
	    }
	    
	    public String getTime(){
	    	seconds -= this.getDelay();
	    	if(seconds < 0) {
	    		minutes -= 1;
	    		seconds = 60;
	    	}
	    	if(minutes < 0) {
	    		//this.notify();
	    		this.stop();
	    	}
	    	
	       return minutes+":"+seconds;
	    }
	    
	    public void restartCount() {
	    	

	    }
	
	 
}
