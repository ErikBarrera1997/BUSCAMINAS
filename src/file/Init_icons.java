package file;

import java.util.HashMap;
import java.util.Map;

public class Init_icons {

	private static Map<Byte, Icons> ICONS = new HashMap<>();;
 
	public static void initIconsRecord() {
	     ICONS.put((byte) 1, new Icons("clock", "/img/clock.png"));
	     ICONS.put((byte) 2, new Icons("cuestion", "/img/cuestion.png"));
	     ICONS.put((byte) 3, new Icons("flag", "/img/flag.png"));
	     ICONS.put((byte) 4, new Icons("mine", "/img/mine.png"));
	     ICONS.put((byte) 5, new Icons("number", "/img/number.png"));
	     ICONS.put((byte) 6, new Icons("skull", "/img/skull.png"));
	     ICONS.put((byte) 7, new Icons("star", "/img/star.png"));
	}
	
	public static String getIconPath(Byte key) {
		return ICONS.get(key).path();
	}
	
}
