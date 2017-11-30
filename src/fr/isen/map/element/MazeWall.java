package fr.isen.map.element;

import com.Logger.Logger;

import java.util.Timer;
import java.util.TimerTask;

public class MazeWall extends Wall {
    //region Parameters
    private int state = 0;
    private String[] images = {"./MazeWall.png", "./MazeWallGlowing.png"};
    //endregion

    //region MapElement Override
    //region EnterLeave
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
        state = 1;
        setChanged();
        notifyObservers();
        loLogger.info("state isLightning = " + state);
        return false;
    }

    @Override
    public void leave() {}
    //endregion

    //region Getters
    @Override
    public int getState() {
        return state;
    }

    @Override
    public String getCurrentUrl() {
        return images[state];
    }
    //endregion
    //endregion
}
