package fr.isen.map.element;

import com.Logger.Logger;

import java.util.Timer;
import java.util.TimerTask;

public class ForestGround extends Ground {

    public Boolean getHasFootPrint() {
        return hasFootPrint;
    }

    private Boolean hasFootPrint = false;

    @Override
    public void leave() {
        Logger fgLogger = Logger.getLogger("forest_ground", null);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                hasFootPrint = false;
                fgLogger.info("hasFootPrint = " + hasFootPrint.toString());
                timer.cancel();
            }
        }, 3 * 1000);

    }

    @Override
    public Boolean enter() {
        Logger fgLogger = Logger.getLogger("forest_ground", null);
        hasFootPrint = true;
        fgLogger.info("hasFootPrint = " + hasFootPrint.toString());
        return true;
    }
}
