package fr.isen.map.view;

import fr.isen.map.model.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class PlayerView extends JPanel implements Observer {
    private Player player;
    private Image[] images;
    private int state;

    public PlayerView(Player player) {
        this.player = player;
        this.setBackground(new Color(0,0,0,0));
        this.setBounds(player.getPosition().y * 32, player.getPosition().x * 32, 32, 32);
        images = new Image[4];
        state = 1;
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

    private Image getImage() {
        return images[state];
    }

    private void setState(Player player) {
        switch (player.getDirection()) {
            case UP:
                state = 0;
                break;
            case LEFT:
                state = 2;
                break;
            case RIGHT:
                state = 3;
                break;
            default:
                state = 1;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.getImage(), 0, 0, null);
    }

    @Override
    public void update(Observable observable, Object object) {
        if (observable == player) {
            setState(player);
            this.setLocation(player.getPosition().y * 32, player.getPosition().x * 32);
            repaint();
        }
    }
}
