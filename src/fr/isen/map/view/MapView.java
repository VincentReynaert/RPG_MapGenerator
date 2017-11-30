package fr.isen.map.view;

import fr.isen.map.controller.MapController;
import fr.isen.map.element.MapElement;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class MapView extends JPanel {

    public MapView(MapController mapController,int width, int height){
        this.setSize(width*32,height*32);
        this.setLayout(new GridLayout(height,width));
        Map<Integer,MapElementView> mapElementViews = mapController.getMapElementViews();
        for (int i = 0; i < mapElementViews.size(); i++) {
          this.add(mapElementViews.get(i));
        }
    }
}
