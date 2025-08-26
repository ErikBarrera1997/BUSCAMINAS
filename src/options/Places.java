package options;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Places extends JDialog{

	private JPanel left;
	private JPanel right;
	private JLabel flag;
	private JTextArea desc;
	
	
	public Places() {
		 super();
		 setTitle("Interfaz con dos JPanels");
	     setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	     setSize(600, 400);
	     setLocationRelativeTo(null);
	     setLayout(new GridLayout(1, 2)); // Panel izquierdo y derecho lado a lado
	     setModal(true);
	     initComponents();
	}
	
	private void initComponents() {
		
		left = new JPanel();
		left.setLayout(new BorderLayout());
		left.setBackground(Color.GRAY);
		left.setLayout(null);
		left.setOpaque(true);

        flag = new JLabel("Texto del Panel Izquierdo");
        flag.setBackground(Color.WHITE);
        flag.setBounds(0, 10, 100, 50);
        left.add(flag);
        
        
        
        desc = new JTextArea();
        desc.setLineWrap(true);
        desc.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(desc);

        desc.add(flag, BorderLayout.NORTH);
        //desc.add(scroll, BorderLayout.CENTER);

        // Panel derecho
        right = new JPanel();
        right.setLayout(new BorderLayout());

        

        // Agregar ambos paneles al JFrame
        add(left);
        add(right);
		
	}
	
}
