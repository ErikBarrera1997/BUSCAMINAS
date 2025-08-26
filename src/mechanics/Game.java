package mechanics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;

import field.Control;

public class Game {
	
	
	public void isMined() {
		
	}
	
	
	private static void paintCells(JPanel p, int z) {
		Point point = getZOrderCoordinates(z);
		int mine = detect(z);

		if(mine > 0) {
	        p.getComponentAt(point).paint(Graphics.drawImage((Graphics2D) p.getComponentAt(point).getGraphics(), 
	        		mine, (int)point.getX(), (int)point.getY()));	
		}else {
			p.getComponentAt(point).setBackground(Color.WHITE); 
		}
		
	}
	
	public static void dig(JPanel p, int z) {
		Point ZPoint;
	    int sense;
	    int tZ;

	    if(Control.getSquareState(z)) {
		   List<Integer> ls = new ArrayList<>();
		   ls.add(z);
		   Control.setSquareState(z, false);
		
		   //Detección de ceros solamente
		   if(detect(z) == 0) {
		   int c = 0; 	
		      while(c < ls.size()) {
			      tZ = ls.get(c); 
			      ZPoint = getZOrderCoordinates(tZ);
		          sense = getSenseOfZOrder(ZPoint.getX(), ZPoint.getY());
		          int[] l = getPointsAroundZPoint(tZ, sense);

		          filter(l, sense);
		         
			      for(int i = 0; i < l.length; i++) {
				      int n = l[i];
				      
				      if(n >= 0) {
				         int d = detect(n); 
			             if(d == 0) { //&& !specialDetect(n) haz que no detecte las diagonales
				           if(!ls.contains(n))	
				               ls.add(n);					
			             }
			          }
			      }
		
		        c++;	
		      }

		   Iterator<Integer> it = ls.iterator(); //Todos los ceros
		     while(it.hasNext()) {
			      tZ = it.next();
			      ZPoint = getZOrderCoordinates(tZ);
			      sense = getSenseOfZOrder(ZPoint.getX(), ZPoint.getY());
			      int[] l = getPointsAroundZPoint(tZ, sense);
			      //int d = 0;
			 
			      int k;
			      for(int i = 0; i < l.length; i++) {				  
				      k = l[i];
				      Control.setSquareState(k, false);
				      paintCells(p, k);				         
		          }
			      
			     // d++;
			      //Control.setDiscover(d);
		     }
		     
		   }else {
			   paintCells(p, z);
			   Control.setSquareState(z, false);
		   }
			 		
		}else if(Control.getMinesInField(z)){
			 System.out.println("KABOOOOOOOOOOOOOOOOOOOOOOOOOOOOM!!!!!");
		}else {
			 System.out.println("Ya escarbaste aqui!!!!!");
		}	  
	   
	}
	
	
	
	/**
	 * Remueve los índices que representan las diagonales del conjunto de casillas circundantes.
	 * @param l Un array con los puntos circundantes.
	 * @param sense El tipo de casilla dentro del campo.
	 */
	private static void filter(int[] l, int sense) {
		 
		 int[][] objetives = {
			        {3},       // 0
			        {1},       // 1
			        {2},       // 2
			        {0},       // 3
			        {3, 5},    // 4
			        {0, 2},    // 5
			        {1, 5},    // 6
			        {0, 4}     // 7
		 };
   
	     int[] def = {0, 2, 6, 8};
	     int[] indexObjetive = (sense >= 0 && sense < objetives.length)? objetives[sense]: def;

	     for(int idx : indexObjetive) {
			  l[idx] = -1;
	     }
			
	}
		
	public static int detect(int z) { 
		//z -= 1;
		int mines = 0;
		Point ZPoint = getZOrderCoordinates(z);
	    int sense = getSenseOfZOrder(ZPoint.getX(), ZPoint.getY());
	    int[] l = getPointsAroundZPoint(z, sense);
	    
	    for(int i = 0; i < l.length; i++) {
	    	mines += (Control.getMinesInField(l[i]))? 1: 0;
	    }    
	   
	  return mines; 
	}
	
	public static int[] getPointsAroundZPoint(int z, int sense) {
		int size = Control.getSize();

	    int[][] increments = {
	        {z, z+1, z+size, z+(size+1)},                  // 0
	        {z-size, z-(size-1), z, z+1},                  // 1
	        {z-1, z, z+(size-1), z+(size)},                  // 2
	        {z-(size+1), z-size, z-1, z},                     // 3
	        {z-1, z, z+1, z+(size-1), z+(size), z+(size+1)},           // 4
	        {z-(size+1), z-size, z-(size-1), z-1, z, z+1},    // 5
	        {z+(size*-1), z+((size*-1)+1), z, z+1, z+size, z+(size+1)},     // 6
	        {z-(size+1), z-size, z-1, z, z+(size-1), z+size}      // 7
	    };

	    int[] defIncrements = {z-(size+1), z-size, z-(size-1), z-1, z, z+1, z+(size-1), z+size, z+(size+1)};
	    int[] zPoints = (sense >= 0 && sense < increments.length) ? increments[sense] : defIncrements;
	    
	   return zPoints; 	
	}
	
	

	//OPTIMIZA ESTOOOOOOOOOOOOOOOOOOOOOO
	public static int getSenseOfZOrder(double x, double y){
       
       int limit = (Control.getSize() *15) - 15;
       int sense;
       
       if(x == 0 && y == 0){
    	   sense = 0;             //Esquina superior izquierda.   impares 
       }else if(x == 0 && y == limit){
    	   sense = 1;       //Esquina inferior izquierda.  impares
       }else if(x == limit && y == 0){
    	   sense = 2;       //Esquina superior derecha    pares 
       }else if(x == limit && y == limit){
    	   sense = 3;       //Esquina inferior derecha.  pares
       }else if(x != 0 && x != limit && y == 0){
    	   sense = 4;         //Arriba.  impares
       }else if(x != 0 && x != limit && y == limit){
    	   sense = 5;       //Abajo.  pares y 0
       }else if(x == 0 && y != 0 && y != limit){
    	   sense = 6;       //Izquierda. impares
       }else if(x == limit && y != 0 && y != limit){
    	   sense = 7;      //Derecha. pares
       }else{
    	   sense = 8;    //Recuadro. pares
       }     
    
      return sense; 
   }
	
	public static int getZOrderFromCoordinates(int x, int y) {
		int limit = 15 * Control.getSize(); 
		int increment = limit/15; 
		int Xposition = 0; 
		int Yposition = 0;
		
		int i = 0;
		while(Xposition <= x) {
			Xposition += 15;
			i++;
		}

		int i2 = 0;
		while(Yposition <= y) {
			Yposition += 15;	
			i2++;
		}
		
		i2--;
		int totalIncrement = i2 * increment;

      return (i + totalIncrement);		
	}
	
	public static Point getZOrderCoordinates(int z) {
	   	int k = -1;
	   	int x;
	   	int y;
	   	double min = Math.floor(z/Control.getSize());
	   	int limit = (int) (min * Control.getSize());

	   	for(int i = limit; i <= z; i++) {
	   		k++;     		
	   	}
	   	 
	   	x = k * 15;
	   	min = Math.ceil(z/Control.getSize()); 
	   	y = (int) (min * 15);
	   	 
	   return new Point(x,y); 
    }
	
	
}
