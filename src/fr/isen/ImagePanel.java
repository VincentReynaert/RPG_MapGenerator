package fr.isen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class ImagePanel extends JPanel {
    Image image1;
    Image image2;
    public ImagePanel() {
        URL url1 = ClassLoader.getSystemResource("./PlayerDown.png");
        URL url2 = ClassLoader.getSystemResource("./wall.png");
        try {
            image1 = ImageIO.read(url1);
            image2 = ImageIO.read(url2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.drawImage(image1,32, 32, null);
        graphics.drawImage(image2,128, 128, null);
    }
}