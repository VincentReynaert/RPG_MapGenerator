package fr.isen.map.element;

import com.Logger.Logger;

public class MazeGround extends Ground {
    //region Parameters
    private int state = 0;
    private String[] images = {"./MazeGround.png", "./MazeGroundGlowing.png"};
    //endregion

    //region MapElement Override
    //region EnterLeave
    @Override
    public void leave() {
        Logger lgLogger = Logger.getLogger("laby_ground", null);
        state = 0;
        setChanged();
        notifyObservers();
        lgLogger.info("state isLightning = " + state);
    }

    @Override
    public Boolean enter() {
        Logger lgLogger = Logger.getLogger("laby_ground", null);
        state = 1;
        setChanged();
        notifyObservers();
        lgLogger.info("state isLightning = " + state);
        return true;
    }
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
