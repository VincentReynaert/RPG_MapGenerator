package fr.isen.map.element;

import com.Logger.Logger;

import java.util.Timer;
import java.util.TimerTask;

public class MazeWall extends Wall {
    private Boolean isLightning = false;

    public Boolean getLightning() {
        return isLightning;
    }

    @Override
    public Boolean enter() {

        Logger loLogger = Logger.getLogger("laby_obs", null);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                isLightning = false;
                loLogger.info("isLightning = " + isLightning.toString());
                timer.cancel();
            }
        }, 3 * 1000);

        isLightning = true;
        loLogger.info("isLightning = " + isLightning.toString());
        return false;
    }

    @Override
    public void leave() {}
}
