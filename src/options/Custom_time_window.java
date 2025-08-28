package options;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import effects.Reset;
import messages.Message;

@SuppressWarnings("serial")
public class Custom_time_window extends JDialog{
      
	  private JPanel panel;
	  private JLabel image;
	  private JTextField timeInput;
	  private JButton accept;
	  private JButton cancel;
	  
	  private messageEvents ms = new messageEvents();
	  
	  public Custom_time_window(JPanel container) {
		  super();
		  setTitle("Contrarrelog");
		  setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		  setSize(250, 150);
		  setLocationRelativeTo(container);
		  setLayout(null); // Panel izquierdo y derecho lado a lado
		  setModal(true);
		  initComponents();
	  }
	  
	  private void initComponents() {
		  panel = new JPanel();
		  panel.setLayout(new BorderLayout());
		  panel.setBounds(0, 0, this.getWidth(), this.getHeight());
		  panel.setBackground(Color.GRAY);
	      panel.setLayout(null);
	      panel.setOpaque(true);
	      add(panel);
	      
	      image = new JLabel();
	      image.setBounds(20, 20, 25, 25);
	      image.setBackground(Color.BLACK);
	      image.setOpaque(true);
	      panel.add(image);
	      
	      timeInput = new JTextField();
	      timeInput.setBounds(image.getX()+30, image.getY(), 100, 20);
	      timeInput.setBackground(Color.WHITE);
	      timeInput.setOpaque(true);
	      panel.add(timeInput);
	      
	      //timeOutput = new JLabel("00:00");
	      //timeOutput.setBounds(timeInput.getX()+120, timeInput.getY(), 50, 20);
	      //timeOutput.setBackground(Color.WHITE);
	      //timeOutput.setOpaque(true);
	      //setTextListener();
	      //panel.add(timeOutput);
      
	      accept = new JButton("Aceptar");
	      accept.setBounds(25, 70, 90, 30);
	      accept.addActionListener(setAcceptButtonEvent());
	      panel.add(accept);
	      
	      cancel = new JButton("Mejor no");
	      cancel.setBounds(120, 70, 90, 30);
	      panel.add(cancel);
	      //Mechanics.timeFormat("59");      

	  }
	  
	  private ActionListener setAcceptButtonEvent() {
		  return new ActionListener() {
			   @Override
			   public void actionPerformed(ActionEvent e) {
			        ms.setMessage();       
	           }
	      };			         	
	  }
	  
	  class messageEvents extends Message {
		  
		@Override
		public void setMessage() {
			int o = 
			    messageEvents.showConfirmDialog(null, "¿Empezar partida con el tiempo elejido?: "+
			    Time_formatter.timeFormat(timeInput.getText()), "Atención", Reset.OK_CANCEL_OPTION, Reset.QUESTION_MESSAGE);	
				if(o == 0) {
				     
				}
		}
		  
	  }
	 
	  

	  
	  
}
