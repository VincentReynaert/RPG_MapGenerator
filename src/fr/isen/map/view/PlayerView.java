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
    private int state;

    public PlayerView(Player player) {
        this.player = player;
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

    public Image getImage() {
        return images[state];
    }

    public void setState(Player player){switch (player.getDirection()) {
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

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(images[state],32 * player.getPosition().y, 32 * player.getPosition().x,this);
    }
    @Override
    public void update(Observable observable, Object object) {
        if (observable == player) {
            setState(player);
//            revalidate();
            repaint();
        }
    }
}
