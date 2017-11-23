package fr.isen.map;

public class Player {

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
    }
}
