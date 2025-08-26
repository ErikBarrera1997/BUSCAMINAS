package field;

public class Control {

	/**
	 * Variables de control 
     */	
	protected int fieldWindowWidth ;
	protected int fieldWindowHeigth ;
	protected static double percent = 8.00;
	protected static int totalCells;
	protected static int totalMines;
	protected static int size = 36; //Tamanio del campo minado (un solo lado)
	protected static int time;
	protected static int discover;
	
	protected static boolean[] minesInField;
	protected static boolean[] squareState;
	
	public int getFieldWindowWidth() {
		return fieldWindowWidth;
	}
	
	public void setFieldWindowWidth(int fieldWindowWidth) {
		this.fieldWindowWidth = fieldWindowWidth;
	}
	
	public int getFieldWindowHeigth() {
		return fieldWindowHeigth;
	}
	
	public void setFieldWindowHeigth(int fieldWindowHeigth) {
		this.fieldWindowHeigth = fieldWindowHeigth;
	}
	
	public static double getPercent() {
		return percent;
	}
	
	public void setPercent(double percent) {
		Control.percent = percent;
	}
	
	//Inicializa el array que va a guardar las minas totales del campo generadas.
	public static void setMinesInField(boolean[] minesInField) {
		Control.minesInField = minesInField;
	}

	public static void setSquareState(boolean[] squareState) {
		Control.squareState = squareState;
	}

	public static boolean getMinesInField(int index) {
		return minesInField[index];
	}

	public static void setMinesInField(int index, boolean b) {
		Control.minesInField[index] = b;
	}

	public static boolean[] getSquareState() {
		return squareState;
	}

	
	public static boolean getSquareState(int index) {
		return squareState[index];
	}
	

	public static void setSquareState(int index, boolean b) {
		squareState[index] =  b;
	}
	
	public static int getTotalCells() {
		return totalCells;
	}
	
	public static void setTotalCells(int cell) {
		totalCells = cell;
	}
	
	public static int getTotalMines() {
		return totalMines;
	}
	
	public static void setTotalMines(int cell) {
		totalMines = cell;
	}

	public static int getSize() {
		return size;
	}

	public static void setSize(int size) {
		Control.size = size;
	}

	public static int getTime() {
		return time;
	}

	public static void setTime(int time) {
		Control.time = time;
	}

	public static int getDiscover() {
		return discover;
	}

	public static void setDiscover(int discover) {
		Control.discover = discover;
	}
	
	
	
}
