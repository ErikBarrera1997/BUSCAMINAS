package effects;

import javax.swing.JPanel;
import field.Generate_field;
import mechanics.Score;
import messages.Message;
import file.Read;
import options.Options;

public class Winner extends Message implements Options{

    private JPanel container;

    public Winner(JPanel container) {
        super();
        this.container = container;
    }   

    public void showMessage() {
        setMessage();
    }

    @Override
    public void setMessage() {
        mechanics.Control.getTimer().stop(); 
        int o = 
			Winner.showConfirmDialog(null, "<html><center>Puntuación: " + Score.getScore() + "<br>" + 
            Read.getRandomText(true) + "<br>¿Otra vez quieres jugar?</center></html>", "¡Ganaste!", 
			Reset.OK_CANCEL_OPTION, Reset.QUESTION_MESSAGE);	
		if(o == 0) {
		   	reset();
		}
    }

    @Override
    public void reset() {
        Score.resetElapsedTime();
        Score.resetDiscover();

        mechanics.Control.getPanel().removeAll();
		mechanics.Control.getPanel().repaint();
		mechanics.Control.setPanel(new Generate_field(0, 0));
		container.removeAll();
		container.add(mechanics.Control.getPanel());
        container.revalidate();
		mechanics.Control.getPanel().updateUI();
		mechanics.Control.getTimer().start();

        mechanics.Control.getTimer().resetTimers();
    }

    @Override
    public void end() {
       
    }    
    
}
