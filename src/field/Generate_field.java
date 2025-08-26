package field;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mechanics.Generate_Mines;

@SuppressWarnings("serial")
public class Generate_field extends JPanel{
		
   private int size = Control.getSize();
	
   public Generate_field(int x, int y) {
	   this.setLocation(x, y);
	   this.setBackground(Color.yellow);
	   this.setPreferredSize(new Dimension(size*15, size*15));
	   this.setLayout(null);
	   prepareMinedField();
   }
	
   private void prepareMinedField(){       
        
        short cells = 0;
        short x = 0;
        short y = 0;
        short generatedMines = 0;
        
        Control.setMinesInField(new boolean[size * size]);  //Crea el array que va a tener las minas generadas
        Control.setSquareState(new boolean[size * size]);
        JLabel cell;
      
        do{
           cell = new JLabel(); 
           cell.setBackground(Color.GREEN);
           cell.setSize(15, 15);
           cell.setOpaque(true);
           cell.setLocation(x, y);    
           cell.setBorder(BorderFactory.createLineBorder(new Color(19, 97, 42))); 
           cell.setFocusable(true);
           this.add(cell);       
           cell.addMouseListener(new Listener());    
           
                if(Generate_Mines.setMine()){
                   Control.setMinesInField(cells, true);
                   Control.setSquareState(cells, false);   
                   generatedMines++; cell.setBackground(Color.BLACK);
                }else{
                   Control.setMinesInField(cells, false); 
                   Control.setSquareState(cells, true);
                }
                
                cells++;
                x += 15; 
              if(x == (15 * Control.getSize())){ 
                 y += 15; 
                 x = 0;  
              }      
              
        }while(cells < (size * size));  
                 
        Control.setTotalMines(generatedMines);
        Control.setTotalCells((size * size) - generatedMines);

        //System.out.println(Control.getTotalCells());
        //System.out.println(Control.getTotalMines());
    }
   
   
   

}
