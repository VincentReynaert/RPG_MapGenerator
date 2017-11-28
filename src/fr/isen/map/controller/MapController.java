package fr.isen.map.controller;

import fr.isen.map.RPGWorlManager;
import fr.isen.map.element.MapElement;
import fr.isen.map.view.MapElementView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapController {
    private RPGWorlManager rpgWorlManager;

    private Map<Integer, MapElementView> mapElementViews;

    public Map<Integer, MapElementView> getMapElementViews() {
        return mapElementViews;
    }

    public MapController(RPGWorlManager rpgWorlManager) {
        this.rpgWorlManager = rpgWorlManager;
        this.mapElementViews = new HashMap<>();
        int i = 0;
        for (List<MapElement> elements : rpgWorlManager.getRpg_map().getElements()) {
            for (MapElement element : elements) {
                mapElementViews.put(i, new MapElementView(element));
                element.addObserver(mapElementViews.get(i));
                i++;
            }
        }
    }
}
