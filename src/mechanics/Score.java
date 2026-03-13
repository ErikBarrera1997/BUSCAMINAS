package mechanics;

public class Score {


	

	public static String getDiscover() {
		return field.Control.getDiscover()+"/"+field.Control.getTotalCells();
	}
	
	public static void setDiscover(int discoveredCells) {
		int currentdiscover = field.Control.getDiscover() + discoveredCells;
		field.Control.setDiscover(currentdiscover);
	}

	
}
