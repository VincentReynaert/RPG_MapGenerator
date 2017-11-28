package fr.isen.map.element;

public class TownWall extends Wall {

    private int state = 0;
    private String[] images = {"./TownWall.png"};

    @Override
    public int getState() {
        return state;
    }

    @Override
    public String getCurrentUrl() {
        return images[state];
    }
    @Override
    public Boolean enter() {
        return false;
    }

    @Override
    public void leave() {

    }
}
