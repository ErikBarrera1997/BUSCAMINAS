package time;

import javax.swing.Timer;
import java.awt.event.ActionListener;


/**
 * Establece el tipo de conteo, desde las dos opciones disponibles.
 */
public abstract class Custom_timer implements Time_manager{

    private final Timer timer;
    Temporizer timeModeTemporizer;
    Countdown timeModeCountdown;

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
    public void setTimerByTemporizer() {
        timeModeTemporizer = new Temporizer();
        mechanics.Control.setTemporizerTimer(timeModeTemporizer);
    }

    @Override
    public void setTimerByCountdown() {
        timeModeCountdown = new Countdown(3, 0);
        mechanics.Control.setCountdownTimer(timeModeCountdown);
    }


}
