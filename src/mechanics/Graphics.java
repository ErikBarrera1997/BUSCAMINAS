package mechanics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import file.Init_icons;


public class Graphics {
	
	public static BufferedImage buffer;
    
    public static void loadBufferedImage() {
    	try {
            buffer = ImageIO.read(Graphics.class.getResource(Init_icons.getIconPath((byte) 5)));
    	}catch(Exception ex) {
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
    
    /**
     * Establece a escala una imagen.
     * @param i El archivo de imagen.
     * @param width El ancho a escalar.
     * @param height El alto a escalar.
     * @return Un archivo de imagen escalado.
     */
    public static ImageIcon scaledImage(String imagePath, int width, int height){     
    	try {
            ImageIcon originalIcon = new ImageIcon(Graphics.class.getResource(imagePath));
            Image scaled = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(scaled);
        }catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }    
}
