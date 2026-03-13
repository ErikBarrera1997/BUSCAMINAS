package time;

/**
 * Esta clase implementa un temporizador que cuenta hacia arriba. No tiene limite. 
 * El limite se usará para puntuación en el juego.
 */
public class Temporizer implements Time_string_manager {

	private int count = 0;
	private int increment; //valor por defecto.
	private boolean activated = false;

	public Temporizer(int increment) {
		this.increment = increment;
	}

	public int getCount(){
		count += increment;
		return count;
	}

	public boolean isActivated(){
		return activated;
	}

	public void setActivated(boolean status){
		activated = status;
	}

	public void setIncrement(int increment) {
		this.increment = increment;
	}

	public void reset(){
		count = 0;
	}
	
	@Override		
	public String getTimeString(){
       return String.valueOf(getCount());
	}

}
