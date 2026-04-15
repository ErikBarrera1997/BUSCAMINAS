package field;

import javax.swing.JPanel;

public class Control {

	/**
	 * Variables de control 
     */	
	protected int fieldWindowWidth ;
	protected int fieldWindowHeigth ;
	protected static double percent = 10.00;
	protected static int totalCells;
	protected static int totalMines;
	protected static int size = 36; //Tamanio del campo minado (un solo lado)
	private static int seconds = 0;
	private static int minutes = 1;
	private static int counter = 1; //valor por defecto del incremento del temporizador.
	private static JPanel container;
	
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
	
	public static int getSeconds() {
		return seconds;
	}

	public static void setSeconds(int seconds) {
		Control.seconds = seconds;
	}

	public static int getMinutes() {
		return minutes;
	}	

	public static void setMinutes(int minutes) {
		Control.minutes = minutes;
	}	

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Control.counter = counter;
	}

	public static JPanel getContainer() {
		return container;
	}

	public static void setContainer(JPanel container) {		
		Control.container = container;
	}
	
}
