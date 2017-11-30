package fr.isen.map.element;

import com.Logger.Logger;

public class ForestWall extends Wall {
    //region Parameters
    private int state = 1;
    private String[] urls = {"./ForestWood.png", "./ForestWoodSnow.png"};
    //endregion

    //region MapElement Override
    //region EnterLeave
    @Override
    public Boolean enter() {
        Logger foLogger = Logger.getLogger("forest_obstable", null);
        state = 0;
        setChanged();
        notifyObservers();
        foLogger.info("state has snow = " + state);
        return false;
    }

    @Override
    public void leave() {
    }
    //endregion

    //region Getters
    @Override
    public int getState() {
        return state;
    }

    @Override
    public String getCurrentUrl() {
        return urls[state];
    }
    //endregion
    //endregion
}
