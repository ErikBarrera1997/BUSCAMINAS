package mechanics;

public class Score {

	private static int elapsedTime = 0;
	private static int discoveredCells;

	public static String getDiscover() {
		return discoveredCells+"/"+field.Control.getTotalCells();
	}
	
	public static void setDiscover(int discoveredCells) {
		Score.discoveredCells += discoveredCells;
	}

	//public static int getElapsedTime() {
	//	return elapsedTime;
	//}

	/**
	 * Verify the elapsed time (ONLY THE SECONDS ELAPSED).
	 * @param elapsedTime
	 */
	public static void setElapsedTime(int elapsedTime) {
		Score.elapsedTime += elapsedTime;
	}

	public static void resetElapsedTime() {
		Score.elapsedTime = 0;
	}

	public static void resetDiscover() {
		Score.discoveredCells = 0;
	}
	
	public static int getScore(){
		return (int) ((discoveredCells*3) - (elapsedTime*0.5));
	}

	public static Boolean isWin() {
		return (discoveredCells == field.Control.getTotalCells());
	}	 
}
