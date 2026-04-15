package buscaminas_3_1;

import field.Field_window;
import file.Init_icons;
import file.Read;
import mechanics.Graphics;

public class mainClass {

	public static void main(String[] args) {		
		Field_window fw = new Field_window();
        fw.setVisible(true);

		initValues();
	}

	private static void initValues() {
		Read.getTextFromFile();
		Init_icons.initIconsRecord();
		Graphics.loadBufferedImage();
	}

}
