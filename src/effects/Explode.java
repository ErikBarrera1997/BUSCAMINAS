package effects;

import java.awt.Component;

import javax.swing.ImageIcon;

import field.Control;
import file.Init_icons;
import mechanics.Game;
import mechanics.Graphics;
import messages.Message;

@SuppressWarnings("serial")
public class Explode extends Message implements Runnable{

	@Override
	public void run() {
		  
		  int limit = Control.getSize();//(int) Math.pow(Control.getSize(), 2);
		  int totalLimit = limit*limit;
		  final String imagePath = Init_icons.getIconPath((byte) 4);
		  
		  try {	
			  // mechanics.Control.getPanel().getComponentAt(p).setBackground(Color.BLACK);
			   for(int k = 0; k < totalLimit; k++) {
				   field.Control.setSquareState(k, false);					  
				   if(field.Control.getMinesInField(k)) {
					  Component c = mechanics.Control.getPanel().getComponentAt(Game.getZOrderCoordinates(k));	
					  field.Control.setSquareState(k, true);	
					  
					  if(c instanceof javax.swing.JLabel) {
					     ImageIcon i = Graphics.scaledImage(imagePath, 15, 15);
						 ((javax.swing.JLabel) c).setIcon(i);
					  }
						
					  Thread.sleep(5);		
				   }
			   }
			  	 
		  }catch (InterruptedException e) {		
			   Thread.currentThread().interrupt();
		  }
		  
		  setMessage();
	}

	@Override 
	public void setMessage() {
		Explode.showMessageDialog(null, "¡MORISTE!", "Fin de partida", 3); //esto debe de ser aleatorioooo		
	}

}
