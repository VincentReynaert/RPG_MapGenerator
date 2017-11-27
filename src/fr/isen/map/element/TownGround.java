package fr.isen.map.element;

public class TownGround extends Ground{

    private int state = 0;
    private String[] images = {"./TownGround.png"};


    @Override
    public int getState() {
        return state;
    }

    @Override
    public String getCurrentImage() {
        return images[state];
    }
    @Override
    public void leave() {}

    @Override
    public Boolean enter() {
        return true;
    }
}
