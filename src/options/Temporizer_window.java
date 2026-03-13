package options;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import messages.Message;

public class Temporizer_window extends JDialog{

    private JLabel descripcion;
    private messageEvents ms = new messageEvents();
    
    public Temporizer_window(JPanel container){
        setTitle("Configurar cronómetro");
        setSize(680, 380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setLocationRelativeTo(container);
		setModal(true);
		setResizable(false); 

        add(panelOpciones(), BorderLayout.WEST);
        add(panelAnimaciones(), BorderLayout.CENTER);
        add(panelBotones(), BorderLayout.SOUTH);
    }

    private JPanel panelOpciones() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 100)); // MÁS angosto
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel titulo = new JLabel("Elige que tan rápido el contador avanzará");
        titulo.setBorder(new LineBorder(Color.BLACK));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setMaximumSize(new Dimension(280, 28));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(titulo);
        panel.add(Box.createVerticalStrut(10));

        // Radios
        JRadioButton imposible = new JRadioButton("Imposible");
        JRadioButton normal = new JRadioButton("Normal");
        JRadioButton estasLoco = new JRadioButton("Estas loco");
        JRadioButton desgracia = new JRadioButton("Desgracia");

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(imposible);
        grupo.add(normal);
        grupo.add(estasLoco);
        grupo.add(desgracia);

        JPanel radios = new JPanel(new GridLayout(2, 2, 6, 6));
        radios.setMaximumSize(new Dimension(280, 60));
        radios.setAlignmentX(Component.CENTER_ALIGNMENT);
        radios.add(imposible);
        radios.add(estasLoco);
        radios.add(normal);
        radios.add(desgracia);

        panel.add(radios);
        panel.add(Box.createVerticalStrut(10));

        // Descripción como LABEL
        descripcion = new JLabel();
        descripcion.setBorder(new LineBorder(Color.BLACK));
        descripcion.setPreferredSize(new Dimension(280, 70));
        descripcion.setMaximumSize(new Dimension(280, 70));
        descripcion.setMinimumSize(new Dimension(280, 70));
        descripcion.setAlignmentX(Component.CENTER_ALIGNMENT);
        descripcion.setVerticalAlignment(SwingConstants.TOP);
        panel.add(descripcion);

        // Eventos
        imposible.addActionListener(e -> {
            descripcion.setText("Velocidad extrema. ¡Jamás vas a poder con esto!. Aumento del contador en 3 segundos");
            field.Control.setCounter(3);
        });

        normal.addActionListener(e -> {
            descripcion.setText("Velocidad estándar. Es lo más adecuado para ti... creo. Aumento del contador en 1 segundo");
            field.Control.setCounter(1);           
        });

        estasLoco.addActionListener(e -> {
            descripcion.setText("Muy rápido. Solo para jugadores que saben jugar a esto.  Aumento del contador en 2 segundos");
            field.Control.setCounter(2);
        });

        desgracia.addActionListener(e -> {
             descripcion.setText("Lento. ¡Si no puedes con esto desisntala el juego!.  Aumento del contador en 0.5 segundos");
            field.Control.setCounter(5);
        });

         return panel;
    }

    private JPanel panelAnimaciones() {
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.BLACK, 1));
        panel.setLayout(new GridBagLayout());

        JLabel texto = new JLabel("Espacio para poder mostrar animaciones");
        panel.add(texto);

        panel.setSize(new Dimension(100, 100));
        return panel;
    }

    private JPanel panelBotones() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 12));

        JButton aceptar = new JButton("Aceptar");
        JButton cancelar = new JButton("Cancelar");

        Dimension size = new Dimension(120, 32);
        aceptar.setPreferredSize(size);
        cancelar.setPreferredSize(size);

        panel.add(aceptar);
        panel.add(cancelar);

        aceptar.addActionListener(e -> {
            ms.setMessage();
        });

        cancelar.addActionListener(e -> dispose());

        return panel;
    }

    class messageEvents extends Message {
		  
		@Override
		public void setMessage() {
			int o = 
			    messageEvents.showConfirmDialog(null, "¿Empezar partida con el tiempo elejido? "+field.Control.getCounter()+" segundos", 
                "Atención", messageEvents.OK_CANCEL_OPTION, messageEvents.QUESTION_MESSAGE);	
				if(o == 0) {
                    mechanics.Control.getTimer().activateTemporizer();
                    mechanics.Control.getTimer().resetTimers();
					dispose();

				}else {
					dispose(); 
				}
		}
		  
	}
}

