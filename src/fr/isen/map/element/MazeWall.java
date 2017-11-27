package fr.isen.map.element;

import com.Logger.Logger;

import java.util.Timer;
import java.util.TimerTask;

public class MazeWall extends Wall {
//    private Boolean isLightning = false;
//
//    public Boolean getLightning() {
//        return isLightning;
//    }

    private int state = 0;
    private String[] images = {"./MazeWall.png", "./MazeWallGlowing.png"};


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

        Logger loLogger = Logger.getLogger("laby_obs", null);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
//                isLightning = false;
                state = 0;
                setChanged();
                notifyObservers();
                loLogger.info("state isLightning = " + state);
                timer.cancel();
            }
        }, 3 * 1000);

//        isLightning = true;
        state = 0;
        setChanged();
        notifyObservers();
        loLogger.info("state isLightning = " + state);
        return false;
    }

    @Override
    public void leave() {}
}
