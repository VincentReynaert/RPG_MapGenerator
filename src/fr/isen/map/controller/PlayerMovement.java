package fr.isen.map.controller;

import fr.isen.map.Direction;
import fr.isen.map.RPGWorlManager;
import fr.isen.map.model.Player;
import fr.isen.map.view.PlayerView;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerMovement implements KeyListener {

    private RPGWorlManager rpgWorlManager;
    private Player player;
    private PlayerView playerView;

    public PlayerMovement(RPGWorlManager rpgWorlManager, PlayerView playerView) {
        this.rpgWorlManager = rpgWorlManager;
        this.playerView = playerView;
        this.player = this.playerView.getPlayer();
        this.player.addObserver(this.playerView);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                player.setDirection(Direction.UP);
                rpgWorlManager.moveNorth();
                break;
            case KeyEvent.VK_DOWN:
                player.setDirection(Direction.DOWN);
                rpgWorlManager.moveSouth();
                break;
            case KeyEvent.VK_LEFT:
                player.setDirection(Direction.LEFT);
                rpgWorlManager.moveWest();
                break;
            case KeyEvent.VK_RIGHT:
                player.setDirection(Direction.RIGHT);
                rpgWorlManager.moveEast();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
