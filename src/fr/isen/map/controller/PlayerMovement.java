package fr.isen.map.controller;

import fr.isen.map.model.Player;
import fr.isen.map.view.PlayerView;

import java.awt.event.*;

public class PlayerMovement implements KeyListener{

    private RPGWorlManager rpgWorlManager;
    private Player player;
    private PlayerView playerView;

    public PlayerMovement(RPGWorlManager rpgWorlManager, Player player) {
        this.rpgWorlManager = rpgWorlManager;
        this.player = player;
        this.playerView = new PlayerView(player);
        player.addObserver(playerView);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch( keyCode ) {
            case KeyEvent.VK_UP:
                System.out.println("press up");
                rpgWorlManager.moveNorth();
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("press do");
                rpgWorlManager.moveSouth();
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("press le");
                rpgWorlManager.moveWest();
                break;
            case KeyEvent.VK_RIGHT :
                System.out.println("press ri");
                rpgWorlManager.moveEast();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}
