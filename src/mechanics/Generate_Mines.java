package mechanics;

import java.util.Random;

import field.Control;

public class Generate_Mines {

	public static boolean setMine( ){ 
	   Random r = new Random();   
	   byte c = (byte) r.nextInt( 100 );
	      if( c < Control.getPercent()){  //Probabilidad de colocar la mina.
	          return true;   
	      }
	      
	  return false;   
	}
	
}
