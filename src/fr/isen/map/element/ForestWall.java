package fr.isen.map.element;

import com.Logger.Logger;

public class ForestWall extends Wall {

    private int state = 1;
    private String[] images = {"./ForestWood.png","./ForestWoodSnow.png"};

//    public Boolean getHasSnow() {
//        return hasSnow;
//    }
//
//    private Boolean hasSnow = true;

    @Override
    public Boolean enter() {
        Logger foLogger = Logger.getLogger("forest_obstable", null);
//        hasSnow = false;
        state = 0;
        setChanged();
        notifyObservers();
        foLogger.info("state has snow = " + state);
        return false;
    }

    @Override
    public void leave() {
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
