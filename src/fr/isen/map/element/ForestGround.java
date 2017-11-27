package fr.isen.map.element;

import com.Logger.Logger;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class ForestGround extends Ground {

//    public Boolean getValue() {
//        return hasFootPrint;
//    }
//
//    private Boolean hasFootPrint = false;

    private int state = 0;
    private String[] images = {"./ForestSnowGround.png","./ForestSnowGroundFooPrints.png"};
    @Override
    public void leave() {
        Logger fgLogger = Logger.getLogger("forest_ground", null);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
//                hasFootPrint = false;
                state = 0;
                setChanged();
                notifyObservers();
                fgLogger.info("state has foot print = " + state);
                timer.cancel();
            }
        }, 3 * 1000);

    }

    @Override
    public int getState() {
        return state;
    }

    @Override
    public String getCurrentImage() {
        return images[state];
    }

    @Override
    public Boolean enter() {
        Logger fgLogger = Logger.getLogger("forest_ground", null);
//        hasFootPrint = true;
        state = 1;
        setChanged();
        notifyObservers();
        fgLogger.info("state has foot print = " + state);
        return true;
    }
}
