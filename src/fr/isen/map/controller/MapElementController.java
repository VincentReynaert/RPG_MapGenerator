package fr.isen.map.controller;

import fr.isen.map.element.MapElement;
import fr.isen.map.view.MapElementView;

public class MapElementController {
    MapElement element;
    MapElementView elementView;
    public MapElementController(MapElement element){
        this.element = element;
        this.elementView = new MapElementView(this.element);
        this.element.addObserver(elementView);
    }
}
