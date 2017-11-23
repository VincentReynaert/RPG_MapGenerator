package fr.isen.map;

import fr.isen.map.element.MapElement;

import java.util.List;

public class RPGMap {
    private List<List<MapElement>> elements;

    public RPGMap(List<List<MapElement>> elements) {
        this.elements = elements;
    }

    public List<List<MapElement>> getElements() {
        return elements;
    }

    public MapElement getElement(int x, int y) {
        return elements.get(x).get(y);
    }
    public int getHeight(){
        return elements.size();
    }
    public int getWidth(){
        return elements.get(0).size();
    }
}
