package fr.isen.map;

import fr.isen.map.element.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class TilePanel extends JPanel implements Observer {
    Image[][] images;

    public TilePanel(List<List<MapElement>> elements) {
        int height = elements.get(0).size();
        int width = elements.size();

        images = new Image[width][height];
        associateAllURL_Element(elements, MapImages.getInstance());
    }


    private void associateAllURL_Element(List<java.util.List<MapElement>> elements, MapImages mapImagesInstance) {
        int i = 0, j = 0;
        while (i < elements.size()) {
            List<MapElement> elementList = elements.get(i);
            while (j < elementList.size()) {
                MapElement element = elementList.get(j);
                try {
                    images[i][j] = ImageIO.read(mapImagesInstance.getUrl(associateURLElement(element)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                j++;
            }
            j = 0;
            i++;
        }
    }

    private String associateURLElement(MapElement element) {
        if (element instanceof TownGround) {
            return "TG";
        } else if (element instanceof TownWall) {
            return "TW";
        } else if (element instanceof ForestGround) {
            if (((ForestGround) element).getHasFootPrint()) return "FGFP";
            else return "FG";
        } else if (element instanceof ForestWall) {
            if (((ForestWall) element).getHasSnow()) return "FWS";
            else return "FW";
        } else if (element instanceof MazeGround) {
            if (((MazeGround) element).getLightning()) return "MGG";
            else return "MG";
        } else if (element instanceof MazeWall) {
            if (((MazeWall) element).getLightning()) return "MWG";
            else return "MW";
        } else {
            System.out.println("error : " + element.getClass());
            return "";
        }

    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        int i = 0, j = 0;
        while (i < images.length) {
            Image[] img = images[i];
            while (j < img.length) {
                Image imageToDraw = img[j];

                graphics.drawImage(imageToDraw, 32 * i, 32 * j, null);
                j++;
            }
            j = 0;
            i++;
        }

    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
