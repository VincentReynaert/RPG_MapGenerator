package fr.isen.map.view;

import fr.isen.map.element.MapElement;

import java.util.Observable;
import java.util.Observer;

public class MapElementView implements Observer {
    private MapElement element;

    public MapElementView(MapElement element) {
        this.element = element;
    }

    @Override
    public void update(Observable observable, Object object) {
        if (observable == element){
            System.out.println(element.getState());
            System.out.println(element.getCurrentImage());
        }
    }
}
