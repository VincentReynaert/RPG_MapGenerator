package fr.isen.map.model;

import fr.isen.map.Direction;
import fr.isen.map.Position;

import java.util.Observable;

public class Player extends Observable {

    //region Position
    private Position position;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
        setChanged();
        notifyObservers();
    }
    //endregion

    //region Direction
    private Direction direction;

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    //endregion

    //region Name
    private String name;

    public String getName() {
        return name;
    }
    //endregion

   public Player(String name) {
        this.name = name;
        this.position = new Position(0, 0);
        this.direction = Direction.DOWN;
    }
}
