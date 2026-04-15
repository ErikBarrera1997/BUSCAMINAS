package mechanics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import file.Init_icons;


public class Graphics {
	
	public static BufferedImage buffer;
    
    public static void loadBufferedImage() {
    	try {
            buffer = ImageIO.read(new File(Init_icons.getIconPath((byte) 5)));
    	}catch(Exception ex) {
    		JOptionPane.showMessageDialog(null, "Archivo de imagen no encontrado", "Advertencia", 3);
    	    //Haz algo para manejar la ausencia del archivo, como cargar una imagen predeterminada o salir del programa.
        }
    }
    
    /**
     * Creates an ImageIcon of a number by cropping it from a sprite sheet.
     * This icon can be set on a JLabel and will be properly repainted.
     * The previous implementation was causing icons to disappear on window minimize.
     * @param p The number to create an icon for (1-8). If p is 0 or less, an empty icon is created.
     * @return An ImageIcon for the given number.
     */
    public static ImageIcon drawImage(int p){
        BufferedImage numberImage = new BufferedImage(15, 15, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = numberImage.createGraphics();

        g2d.setPaint(new Color(242, 242, 242));
        g2d.fillRect(0, 0, 15, 15);

        if (p > 0) {
            g2d.drawImage(buffer, 0, 0, 15, 15, (p * 15) - 15, 0, p * 15, 15, null);
        }
        g2d.dispose();
        return new ImageIcon(numberImage);
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
            ImageIcon originalIcon = new ImageIcon(new File(imagePath).getAbsolutePath());
            Image scaled = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(scaled);
        }catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }    
}
