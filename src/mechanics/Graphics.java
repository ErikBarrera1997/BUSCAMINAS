package mechanics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


public class Graphics {
	
	public static BufferedImage buffer;
    
    public static void loadBufferedImage() {
    	try {
            buffer = ImageIO.read(Graphics.class.getResource("/img/number.png"));
    	}catch(Exception ex) {
    		//Mensaje de error
    		JOptionPane.showMessageDialog(null, "Archivo de imagen no encontrado", "Advertencia", 3);
    	}
    }
    
    /**
     * Dibuja uno de los numeros en number.png
     * @param g El entorno Graphics.
     * @param p Un número que indica cuantas minas se tienen, y de acuerdo a eso se asigna el número.
     * @param x Posición x de la casilla. 
     * @param y Posición y de la casilla. 
     * @return El fragmento de la imagen de acuerdo al número dado por las minas.
     */
    public static Graphics2D drawImage(Graphics2D g, int p, int x, int y){     
        Graphics2D g2d = g;    
        //g.translate(x, y);
        g.setPaint(new Color(242, 242, 242));
        g.fillRect(1, 1, 13, 13); 
        g2d.drawImage(buffer, 0, 0, 15, 15, (p*15)-15, 0, p*15, 15, null);              
        g2d.dispose();
        
       return g2d; 
    }    
}
