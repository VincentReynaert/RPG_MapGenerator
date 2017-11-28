package fr.isen.map.element;

import java.awt.*;
import java.util.Observable;

public abstract class MapElement extends Observable {
    public abstract Boolean enter();
    public abstract void leave();
    public abstract int getState();
    public abstract String getCurrentUrl();
}
