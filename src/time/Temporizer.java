package time;

/**
 * Esta clase implementa un temporizador que cuenta hacia arriba. No tiene limite. 
 * El limite se usará para puntuación en el juego.
 */
public class Temporizer implements Time_string_manager {

	public int count = 0;

	public void count(){
		count++;
	}

	public void reset(){
		count = 0;
	}
	
	@Override		
	public String getTimeString(){
       return String.valueOf(this.count);
	}

}
