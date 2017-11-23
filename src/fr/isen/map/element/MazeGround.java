package fr.isen.map.element;

import com.Logger.Logger;

public class MazeGround extends Ground{
    public Boolean getLightning() {
        return isLightning;
    }

    private Boolean isLightning = false;

    @Override
    public void leave() {
        Logger lgLogger = Logger.getLogger("laby_ground",null);
        isLightning = false;
        lgLogger.info("isLightning = "+isLightning.toString());
    }

    @Override
    public Boolean enter() {
        Logger lgLogger = Logger.getLogger("laby_ground",null);
        isLightning = true;
        lgLogger.info("isLightning = "+isLightning.toString());
        return true;
    }
}
