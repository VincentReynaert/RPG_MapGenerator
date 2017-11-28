package fr.isen.map.view;

import fr.isen.map.element.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class GlobalView extends JPanel {
    Image[][] images;
//    PlayerView playerView;

    public GlobalView(List<List<MapElement>> elements, PlayerView playerView) {
        int height = elements.get(0).size();
        int width = elements.size();
//        this.playerView = playerView;
//        this.playerView.getPlayer().addObserver(this);
        this.images = new Image[width][height];
        associateAllURL_Element(elements);
    }

    private void associateAllURL_Element(List<List<MapElement>> elements) {
        int i = 0, j = 0;
        while (i < elements.size()) {
            List<MapElement> elementList = elements.get(i);
            while (j < elementList.size()) {
                MapElement element = elementList.get(j);
                try {
//                    System.out.println(element.getCurrentUrl());
                    images[i][j] = ImageIO.read(ClassLoader.getSystemResource(element.getCurrentUrl()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                j++;
            }
            System.out.println("");
            j = 0;
            i++;
        }
    }

//    private String associateURLElement(MapElement element) {
//        if (element instanceof TownGround) {
//            return "TG";
//        } else if (element instanceof TownWall) {
//            return "TW";
//        } else if (element instanceof ForestGround) {
//            if (((ForestGround) element).getValue()) return "FGFP";
//            else return "FG";
//        } else if (element instanceof ForestWall) {
//            if (((ForestWall) element).getHasSnow()) return "FWS";
//            else return "FW";
//        } else if (element instanceof MazeGround) {
//            if (((MazeGround) element).getLightning()) return "MGG";
//            else return "MG";
//        } else if (element instanceof MazeWall) {
//            if (((MazeWall) element).getLightning()) return "MWG";
//            else return "MW";
//        } else {
//            System.out.println("error : " + element.getClass());
//            return "";
//        }
//
//    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        int i = 0, j = 0;
        while (i < images.length) {
            Image[] img = images[i];
            while (j < img.length) {
                Image imageToDraw = img[j];
                graphics.drawImage(imageToDraw, 32 * j, 32 * i, null);
                j++;
            }
            j = 0;
            i++;
        }
//        System.out.println(playerView.getImage());
//        graphics.drawImage(playerView.getImage(), 32 * playerView.getPlayer().getPosition().y, 32 * playerView.getPlayer().getPosition().x, null);
    }

}
