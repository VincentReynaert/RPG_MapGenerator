package fr.isen.map.view;

import fr.isen.map.model.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class PlayerView implements Observer {
    private Player player;
    private Image image;

    public PlayerView(Player player) {
        this.player = player;
        String url = "./Player#.png";
        url = FindUrl(player, url);
        try {
            this.image = ImageIO.read(ClassLoader.getSystemResource(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String FindUrl(Player player, String url) {
        switch (player.getDirection()) {
            case UP:
                url = url.replace("#", "Up");
                break;
            case LEFT:
                url = url.replace("#", "Left");
                break;
            case RIGHT:
                url = url.replace("#", "Right");
                break;
            default:
                url = url.replace("#", "Down");
        }
        return url;
    }

    public Player getPlayer() {
        return player;
    }

    public Image getImage() {
        return image;
    }

    @Override
    public void update(Observable observable, Object object) {
        if (observable == player) {
            String url = "./Player#.png";
            url = FindUrl(player, url);
            try {
                this.image = ImageIO.read(ClassLoader.getSystemResource(url));
            } catch (IOException e) {
                e.printStackTrace();
            }
//            System.out.println("x " + player.getPosition().x + " : y" + player.getPosition().y);
        }
    }
}
