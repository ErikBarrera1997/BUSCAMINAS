package effects;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JPanel;

import field.Control;
import field.Generate_field;
import field.Time_interface;
import messages.Message;

@SuppressWarnings("serial")
public class Reset extends Message implements Runnable, Time_interface{

	private JPanel container;
	
	public Reset(JPanel container) {
   	   super();
   	   this.container = container;
    }
	
	private void reveal(int z) {	
		Point p = mechanics.Game.getZOrderCoordinates(z);
		mechanics.Control.getPanel().getComponentAt(p).setBackground(Color.WHITE);
		//mechanics.Control.getPanel().removeAll();	
	}

	private void process() {
		mechanics.Control.getTimer().stop();
		int limit = Control.getSize();//(int) Math.pow(Control.getSize(), 2);
		int increment = 0;
		int i = 0;
		  
		  try {	
			 while(i <= limit) {
				 while(increment < limit*limit) {
					 reveal(increment);	
					 increment += Control.getSize();
				 }
				 
			   Thread.sleep(100);	
			   increment = i;
			   i++;	 //System.out.println(i);
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
		setTimer();
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

	@Override
	public void setTimer() {
		mechanics.Control.getTimer().restartCount();
	}

}
