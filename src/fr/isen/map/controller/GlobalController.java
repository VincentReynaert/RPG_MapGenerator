package fr.isen.map.controller;

import fr.isen.map.RPGWorlManager;
import fr.isen.map.element.MapElement;
import fr.isen.map.view.MapElementView;

import java.util.List;
import java.util.Map;

public class GlobalController {
    private RPGWorlManager rpgWorlManager;
    private Map<MapElement,MapElementView> mapElementViews;

    public GlobalController(RPGWorlManager rpgWorlManager) {
        this.rpgWorlManager = rpgWorlManager;
        for (List<MapElement> elements : rpgWorlManager.getRpg_map().getElements()) {
            for (MapElement element :elements) {
                mapElementViews.put(element, new MapElementView(element));
                element.addObserver(mapElementViews.get(element));
            }
        }
    }
}
