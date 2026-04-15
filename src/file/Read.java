package file;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import messages.Message;

public class Read extends Message {

	private static final List<String> winPhrases = new ArrayList<>();
	private static final List<String> loosePhrases = new ArrayList<>();

	/**
	 * Save the phrases from the files into the respective lists. If the files cannot be read, it will show a message dialog.
	 * Only execute this method once.
	 */
	public static void getTextFromFile() {
		winPhrases.clear();
		loosePhrases.clear();
		loadFile(Path.of("files", "loose.file"), loosePhrases);
		loadFile(Path.of("files", "win.file"), winPhrases);
	}

	private static void loadFile(Path path, List<String> target) {
		try {
			for (String line : Files.readAllLines(path, StandardCharsets.UTF_8)) {
				String trimmed = line.trim();
				if (!trimmed.isEmpty()) {
					target.add(trimmed);
				}
			}
		} catch (IOException e) {
			//setMessage();
		}
	}

	// Obtiene una frase aleatoria de las ya cargadas.
	public static String getRandomText(boolean option) {
		if(option) {
			if (!winPhrases.isEmpty()) {
				return getRandomIndex(winPhrases);
			}
		}else{
			if (!loosePhrases.isEmpty()) {
				return getRandomIndex(loosePhrases);
			}
		}	
		
		return "¡No hay frases disponibles!";	
	}

	private static String getRandomIndex(List<String> phrases) {
		int index = ThreadLocalRandom.current().nextInt(phrases.size());
		return phrases.get(index);
	} 
	

	@Override
	public void setMessage() {
		Read.showMessageDialog(null, "No se pudo leer el archivo.", "Atención", OK_OPTION);
	}
}
