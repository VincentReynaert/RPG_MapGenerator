package fr.isen.map.view;

import fr.isen.map.model.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class PlayerView extends JPanel implements Observer{
    private Player player;
    private Image[] images;
    private int imageIndex;

    public PlayerView(Player player) {
        this.player = player;
        images = new Image[4];
        imageIndex = 1;
        FindUrl();
    }

    private void FindUrl() {
        try {
            this.images[0] = ImageIO.read(ClassLoader.getSystemResource("./PlayerUp.png"));
            this.images[1] = ImageIO.read(ClassLoader.getSystemResource("./PlayerDown.png"));
            this.images[2] = ImageIO.read(ClassLoader.getSystemResource("./PlayerLeft.png"));
            this.images[3] = ImageIO.read(ClassLoader.getSystemResource("./PlayerRight.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Player getPlayer() {
        return player;
    }

    public Image getImage() {
        return images[imageIndex];
    }

    public void setImageIndex(Player player){switch (player.getDirection()) {
        case UP:
            imageIndex = 0;

            break;
        case LEFT:
            imageIndex = 2;

            break;
        case RIGHT:
            imageIndex = 3;

            break;
        default:
            imageIndex = 1;

    }

    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
