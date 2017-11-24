package fr.isen.map.view;

import fr.isen.map.model.Player;

import java.util.Observable;
import java.util.Observer;

public class PlayerView implements Observer {
    private Player player;

    public PlayerView(Player player) {
        this.player = player;
    }

    @Override
    public void update(Observable observable, Object object) {
        if (observable == player){
            System.out.println("x " + player.getPosition().x + " : y" + player.getPosition().y);
        }
    }
}
