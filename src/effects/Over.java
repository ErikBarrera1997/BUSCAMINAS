package effects;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;

import javax.swing.JLabel;

import field.Control;
import messages.Message;

public class Over extends Message implements Runnable {

     public Over() {
    	 super();
     }
	
	 public void reveal(int z) {	
		  Point p = mechanics.Game.getZOrderCoordinates(z);
		  Component c = mechanics.Control.getPanel().getComponentAt(p);
		  c.setBackground(Color.BLACK);
		  
		  if (c instanceof JLabel) {
			  ((JLabel) c).setIcon(null);
		  }
	 }

	 @Override
	 public void run() {
		  mechanics.Control.getTimer().stop();	
		  mechanics.Control.getPanel().setEnabled(false);	 
		  int limit = Control.getSize();
		  int totalLimit = limit*limit;
		  
		  try {	
			 for (int i = 0; i < limit; i++) {
				 int increment = i;
				 while(increment < totalLimit) {
					 reveal(increment);	
					 Control.setSquareState(increment, false);
					 increment += Control.getSize();
				 }
				 
			   Thread.sleep(100);	
			 }
			
		  }catch(InterruptedException e) {		
			  Thread.currentThread().interrupt();
		  }
		  
		  setMessage();
	 }

	 @Override
	 public void setMessage() {
	      Over.showMessageDialog(null, "Eres la desgracia del mundo!", 
		  "Fin de partida", 3);		
	 }


	 
	
}
