package field;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import file.Init_icons;
import mechanics.Graphics;
import mechanics.Score;
import mechanics.Temporizer;

@SuppressWarnings("serial")
public class Field_window extends JFrame implements ActionListener, Time_interface{

	private JLabel lblUser;
    private JLabel lblChronometer;
    private JLabel lblMines;
    //private JLabel lblMessage;
    //private JLabel lblCells;
	
	public Field_window(){
     
		 setTitle("Buscaminas 3.1");
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     setSize(600, 650);
	     setLocationRelativeTo(null); // Centra la ventana
	     setLayout(null);
	     setResizable(false);
	     initFiles(); 
	     initComponents();       
    }
	
	private void initComponents() {

	     JPanel upperPanel = new JPanel(new GridLayout(1, 3));
	     lblUser = new JLabel("Usuario: jugador1", SwingConstants.CENTER);
	     lblChronometer = new JLabel("0", SwingConstants.CENTER);
	     lblMines = new JLabel("Minas encontradas: ", SwingConstants.CENTER);
	     upperPanel.add(lblUser);
	     upperPanel.add(lblChronometer);
	     upperPanel.add(lblMines);
         upperPanel.setBackground(Color.PINK);
         upperPanel.setBounds(0, 0, this.getWidth(), 20);
         add(upperPanel);
        
         JPanel lowrPanel = new JPanel();
         lowrPanel.setBackground(Color.BLACK);
         lowrPanel.setOpaque(true);
         lowrPanel.setBounds(0, upperPanel.getY()+20, this.getWidth(), 550);
         add(lowrPanel);
        
         setJMenuBar(new options.Menu(lowrPanel));
        
         JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
         //lblMessage = new JLabel("Null", SwingConstants.CENTER);
	     //lblCells = new JLabel("0", SwingConstants.CENTER);
	     upperPanel.add(lblUser);
	     upperPanel.add(lblChronometer);
	     upperPanel.add(lblMines);
         bottomPanel.setBackground(Color.YELLOW);
         bottomPanel.setOpaque(true);
         bottomPanel.setBounds(0, lowrPanel.getY()+550, this.getWidth(), 20);
         add(bottomPanel);
        
         JLabel message = new JLabel();
         message.setHorizontalAlignment(SwingConstants.CENTER);
         message.setBorder(new LineBorder(Color.BLACK, 2)); 
         message.setBackground(Color.CYAN);
         message.setOpaque(true);
         bottomPanel.add(message);
         
         JLabel discover = new JLabel();
         discover.setHorizontalAlignment(SwingConstants.CENTER);
         discover.setBorder(new LineBorder(Color.BLACK, 2)); 
         discover.setBackground(Color.PINK);
         discover.setOpaque(true);
         bottomPanel.add(discover);
        
         mechanics.Control.setPanel(new Generate_field(0, upperPanel.getY() + 1));
         lowrPanel.add(mechanics.Control.getPanel());      
         discover.setText(Score.getDiscover());
         setTimer();
	}
	
	private void initFiles() {
		 Init_icons.initIconsRecord();
		 Graphics.loadBufferedImage();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 lblChronometer.setText(mechanics.Control.getTimer().getTimeString());
	}

	@Override
	public void setTimer() {
		 mechanics.Control.setTimer(new Temporizer(1000, (ActionListener) this));
	     mechanics.Control.getTimer().start();
	}
	
	
}
