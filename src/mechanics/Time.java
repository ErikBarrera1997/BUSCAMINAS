package mechanics;

import java.awt.event.ActionListener;
import time.Custom_timer;
import time.Time_string_manager;

public class Time extends Custom_timer implements Time_string_manager{

    public Time(int mode, int delayMillis, ActionListener listener) {
        super(delayMillis, listener);
        setTimeMode(mode);
    }

    public void setTimeMode(int mode){
        if(mode == 1) setTimerByTemporizer();
        else if(mode == 2) setTimerByCountdown();
    } 

    @Override
    public String getTimeString(){
        return mechanics.Control.getTimeFromTimers();
    }

    @Override
    public void onTick() {
        System.out.println("Tick: " + mechanics.Control.getTimeFromTimers());
        if(mechanics.Control.getTemporizerTimer() != null) {
           mechanics.Control.getTemporizerTimer().count();
           mechanics.Control.setTimeFromTimers(mechanics.Control.getTemporizerTimer().getTimeString());
        }
        else if(mechanics.Control.getCountdownTimer() != null) {
            System.out.println("Tick: " + mechanics.Control.getCountdownTimer().getTimeString());
           mechanics.Control.setTimeFromTimers(mechanics.Control.getCountdownTimer().getTimeString());
        }
    }


}
