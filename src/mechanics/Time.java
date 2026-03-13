package mechanics;

import java.awt.event.ActionListener;
import time.Custom_timer;

/**
 * Hilo principal del temporizador. Se encarga de actualizar el tiempo cada vez que se activa el timer.
 * Desde aqui se controla el tiempo de ambos contadores, el temporizador y el conteo regresivo.
 */
public class Time extends Custom_timer {

    public Time(int delayMillis, ActionListener listener) {
        super(delayMillis, listener);
        setTimerByCountdown(0,1); //luego estableces un estandar para el contador.
        setTimerByTemporizer(field.Control.getCounter());
    }
    
    @Override
    public void onTick() {
        if(time.Control.getTemporizerTimer().isActivated()) {
           time.Control.setTimeFromTimers(time.Control.getTemporizerTimer().getTimeString());
        }
        else if(time.Control.getCountdownTimer().isActivated()) {
           time.Control.setTimeFromTimers(time.Control.getCountdownTimer().getTimeString());
        }
    }

    public void resetTimers() {
        time.Control.getTemporizerTimer().reset();
        time.Control.getCountdownTimer().reset();
    }

    public void activateTemporizer() {
        time.Control.getTemporizerTimer().setActivated(true);
        time.Control.getCountdownTimer().setActivated(false);
        time.Control.getTemporizerTimer().setIncrement(field.Control.getCounter());
    }

    public void activateCountdown() {
        time.Control.getTemporizerTimer().setActivated(false);
        time.Control.getCountdownTimer().setActivated(true);    
    }

}
