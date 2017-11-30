package fr.isen.map.element;

import com.Logger.Logger;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class ForestGround extends Ground {

    private int state = 0;
    private String[] images = {"./ForestSnowGround.png","./ForestSnowGroundFootPrints.png"};
    @Override
    public void leave() {
        Logger fgLogger = Logger.getLogger("forest_ground", null);
        state = 1;
        setChanged();
        notifyObservers();
        fgLogger.info("state has foot print = " + state);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                state = 0;
                setChanged();
                notifyObservers();
                fgLogger.info("state has foot print = " + state);
                timer.cancel();
            }
        }, 3 * 1000);

    }
    @Override
    public Boolean enter() {
        return true;
    }

    @Override
    public int getState() {
        return state;
    }

    @Override
    public String getCurrentUrl() {
        return images[state];
    }

}
