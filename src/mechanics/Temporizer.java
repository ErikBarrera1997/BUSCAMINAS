package mechanics;

import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Temporizer extends Timer {

	public int count = 0;
	
	    public Temporizer(int delay) {
		    super(delay, null);		
	    }
	    
	    public Temporizer(int delay, ActionListener listener) {
		    super(delay, listener);		
	    }

	    public String getTimeString(){
	        return String.valueOf(count += 1000/this.getDelay());
	    }
	    
	    public int getTime(){
	        return count += 1000/this.getDelay();
	    }
	    
	    public void restartCount() {
	    	count = 0;
	    	this.restart();
	    }
	
	
}
