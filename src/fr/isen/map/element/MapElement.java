package fr.isen.map.element;

import java.util.Observable;

public abstract class MapElement extends Observable {
    public abstract Boolean enter();
    public abstract void leave();
}
