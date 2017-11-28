package fr.isen.map.view;

import fr.isen.map.element.MapElement;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class MapElementView extends JPanel implements Observer {
    private MapElement element;

    public MapElementView(MapElement element) {
        this.element = element;
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = null;
        try {
            image = ImageIO.read(ClassLoader.getSystemResource(element.getCurrentUrl()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(image,0,0,null);
    }

    @Override
    public void update(Observable observable, Object object) {
        if (observable == element){
//            System.out.println(element.getState());
            repaint();
//            System.out.println("MapElementView Update : " + element.getCurrentUrl());
        }
    }
}
