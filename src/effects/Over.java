package effects;

import java.awt.Color;
import java.awt.Point;


import field.Control;
import field.Time_interface;
import messages.Message;

@SuppressWarnings("serial")
public class Over extends Message implements Runnable, Time_interface{

     public Over() {
    	 super();
     }
	
	 public void reveal(int z) {	
		  Point p = mechanics.Game.getZOrderCoordinates(z);
		  mechanics.Control.getPanel().getComponentAt(p).setBackground(Color.BLACK);	
	 }

	 @Override
	 public void run() {		 
		  setTimer();
		  int limit = Control.getSize();//(int) Math.pow(Control.getSize(), 2);
		  int increment = 0;
		  int i = 0;
		  
		  try {	
			 while(i <= limit) {
				 while(increment < limit*limit) {
					 reveal(increment);	
					 Control.setSquareState(increment, false);
					 //System.out.println(increment);
					 increment += Control.getSize();
				 }
				 
			   Thread.sleep(100);	
			   increment = i;
			   i++;	 //System.out.println(i);
			 }
			
		  }catch (InterruptedException e) {		
			  e.printStackTrace();
		  }
		  
		  setMessage();
	 }

	 @Override
	 public void setMessage() {
	      Over.showMessageDialog(null, "Eres la desgracia del mundo!", "Fin de partida", 3);		
	 }

	@Override
	public void setTimer() {
		  mechanics.Control.getTimer().stop();	
	} 
	 
	
}
