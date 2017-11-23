package fr.isen.map.controller;

import fr.isen.map.RPGWorlManager;

import java.awt.event.*;

public class PlayerMovement implements KeyListener{

    private RPGWorlManager rpgWorlManager;

    public PlayerMovement(RPGWorlManager rpgWorlManager) {
        this.rpgWorlManager = rpgWorlManager;
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
