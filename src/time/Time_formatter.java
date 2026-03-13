package time;

public class Time_formatter {
      
	/**
	* Devuelve el formato en minutos (##:##). 
	* @param input Cadena de texto que especif[ica los segundos. SOLAMENTE es para motivos visuales.
	* @return Una cadena con el formato ##:##
	*/
	public static String timeFormat(String input) {	
		System.out.println(input);
		  
		if(input != null) {
			double d = Double.parseDouble(input); 
			int e = (int)Math.floor(d/60); 
			int de = (int) ((d >= 60)?(int)Math.floor(((d/60) - e) * 100): d); 
			  
			String eS = String.valueOf(e);
			String deS = String.valueOf(de);
			  
			if(e <= 9) 
				 eS = "0"+eS; 
			  if(de <= 9) 
			     deS = "0"+deS;
			  
			return eS+":"+deS;		  
		  }else {
			  return "0";
		  }
		  
	  }
	  
	  /**
	   * Convierte una cadena de text (que es representada con los segundos TOTALES) para separarlos en minutos y segundos correspondientes.
	   * @param input La cadena de texto que simboliza los segundos totales para su posterior separacion en minutos y segundos.
	   * @return Devuelve un array con dos datos: los minutos y lo segundos.
	   */
	public static void setTime(String input) {
		double d = Double.parseDouble(input); 
		int e = (int)Math.floor(d/60); 
		int de = (int) ((d >= 60)?(int)Math.floor(((d/60) - e) * 100): d); 

		field.Control.setMinutes(e);
		field.Control.setSeconds(de);	 System.out.println(e+":"+de); 
	}
}
