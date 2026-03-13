package time;

import javax.swing.Timer;
import java.awt.event.ActionListener;


/**
 * Establece el tipo de conteo, desde las dos opciones disponibles.
 */
public abstract class Custom_timer implements Time_manager{

    private final Timer timer;

    public Custom_timer(int delayMillis, ActionListener listener) {
        timer = new Timer(delayMillis, listener); 
    }

    protected abstract void onTick();

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public boolean isRunning() {
        return timer.isRunning();
    }

    @Override
    public void setTimerByTemporizer(int counter) {
        time.Control.setTemporizerTimer(new Temporizer(counter));
    }

    @Override
    public void setTimerByCountdown(int seconds, int minutes) {
        time.Control.setCountdownTimer(new Countdown(seconds, minutes));
        System.out.println(seconds+":"+minutes);
    }


}
