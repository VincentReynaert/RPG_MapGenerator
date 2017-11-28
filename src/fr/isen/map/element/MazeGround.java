package fr.isen.map.element;

import com.Logger.Logger;

public class MazeGround extends Ground {
//    public Boolean getLightning() {
//        return isLightning;
//    }
//
//    private Boolean isLightning = false;

    private int state = 0;
    private String[] images = {"./MazeGround.png", "./MazeGroundGlowing.png"};


    @Override
    public int getState() {
        return state;
    }

    @Override
    public String getCurrentUrl() {
        return images[state];
    }
    @Override
    public void leave() {
        Logger lgLogger = Logger.getLogger("laby_ground", null);
//        isLightning = false;
        state = 0;
        setChanged();
        notifyObservers();
        lgLogger.info("state isLightning = " + state);
    }

    @Override
    public Boolean enter() {
        Logger lgLogger = Logger.getLogger("laby_ground", null);
//        isLightning = true;
        state = 1;
        setChanged();
        notifyObservers();
        lgLogger.info("state isLightning = " + state);
        return true;
    }
}
