package fr.isen.map.element;

import com.Logger.Logger;

public class ForestWall extends Wall {
    public Boolean getHasSnow() {
        return hasSnow;
    }

    private Boolean hasSnow = true;

    @Override
    public Boolean enter() {
        Logger foLogger = Logger.getLogger("forest_obstable", null);
        hasSnow = false;
        foLogger.info("hasSnow = " + hasSnow.toString());
        return false;
    }

    @Override
    public void leave() {
    }
}
