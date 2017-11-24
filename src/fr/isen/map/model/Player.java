package fr.isen.map.model;

import fr.isen.map.Position;

import java.util.Observable;

public class Player extends Observable{

    private Position position;

    private String name;

    public Player(String name) {
        this.name = name;
        this.position = new Position(0,0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
        setChanged();
        notifyObservers();
    }
}
