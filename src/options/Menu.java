package options;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import effects.Over;
import effects.Reset;

@SuppressWarnings("serial")
public class Menu extends JMenuBar implements Options{

	JPanel panel; //CONTENEDOR DEL JMENU
	
	public Menu(JPanel panel) {
		super();
		this.panel = panel;
		setMenuItems();
	}

	private void setMenuItems() {
		
		JMenu jm2 = new JMenu("Partida");
		JMenuItem jmi = new JMenuItem("Generación de minas");
		jmi.addActionListener(
				new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		             
		            }
		         }	
		);
		jm2.add(jmi);
		jm2.add(new JMenuItem("Tamaño de campo"));
		add(jm2);
		
		
		JMenu jm = new JMenu("Opciones");
		JMenuItem jmReset = new JMenuItem("Reiniciar partida");
		jmReset.addActionListener(
				new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                reset();
		                
		            }
		         }	
		);
		JMenuItem jmSurrender = new JMenuItem("¡Me rindo!");
		jmSurrender.addActionListener(
				new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                end();
		                
		            }
		         }	
		);
		
		JMenu jm3 = new JMenu("Modos");
		JMenuItem jmMode = new JMenuItem("Clásico");
		jmMode.addActionListener(
				new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                
		            }
		         }	
		);
		JMenuItem jmMode2 = new JMenuItem("Contrarrelog");
		jmMode2.addActionListener(
				new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                Custom_time_window t = new Custom_time_window(panel);
		                t.setVisible(true);
		                
		            }
		         }	
		);
		JMenuItem jmMode3 = new JMenuItem("Lugares peligrosos");
		jmMode3.addActionListener(
				new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		               // Places m = new Places();
		               // m.setVisible(true);
		                
		            }
		         }	
		);
		
		jm.add(jmSurrender);
		jm.add(jmReset);
		
		jm3.add(jmMode);
		jm3.add(jmMode2);
		jm3.add(jmMode3);
		
		add(jm3);
		add(jm);
		
	}
	
	@Override
	public void reset() {
		Thread t = new Thread(new Reset(panel));
        t.start();
		
	}

	@Override
	public void end() {
		Thread t = new Thread(new Over());
        t.start();
		
	}
	
	
}
