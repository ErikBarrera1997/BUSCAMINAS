package effects;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;

import field.Control;
import field.Generate_field;
import messages.Message;

public class Reset extends Message implements Runnable {

	private JPanel container;
	
	public Reset(JPanel container) {
   	   super();
   	   this.container = container;
    }
	
	private void reveal(int z) {	
		Point p = mechanics.Game.getZOrderCoordinates(z);
		Component c = mechanics.Control.getPanel().getComponentAt(p);
		c.setBackground(Color.WHITE);
		
		if (c instanceof JLabel) {
			((JLabel) c).setIcon(null);
		}
	}

	private void process() {
		mechanics.Control.getTimer().stop();
		mechanics.Control.getPanel().setEnabled(false); 
		int limit = Control.getSize();
		  
		  	try {	
			 	for (int i = 0; i < limit; i++) {
			 		int increment = i;
				 	while(increment < limit*limit) {
					 	reveal(increment);	
					 	increment += Control.getSize();
				 	}
				 
			   		Thread.sleep(100);	
			 	}
			
		  	}catch (InterruptedException e) {		
				  e.printStackTrace();
		  	}
		  
	    mechanics.Control.getPanel().removeAll();
		mechanics.Control.getPanel().repaint();
		mechanics.Control.setPanel(new Generate_field(0, 0));
		container.removeAll();
		container.add(mechanics.Control.getPanel());
        container.revalidate();
		mechanics.Control.getPanel().updateUI();
		mechanics.Control.getTimer().start();
	}
	
	@Override
	public void run() {
		setMessage();	  
	}

	@Override
	public void setMessage() {
		int o = 
			Reset.showConfirmDialog(null, "¿Estás seguro de reiniciar la partida?", "Atención", 
					Reset.OK_CANCEL_OPTION, Reset.QUESTION_MESSAGE);	
		if(o == 0) {
		   	process();	  
		}else {
			Reset.showMessageDialog(null, "¡Sabía que no nos ibas a descepcionar!", "Atención", 1, null);
		}
		
	}


}
