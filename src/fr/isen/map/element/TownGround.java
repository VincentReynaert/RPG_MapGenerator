package fr.isen.map.element;

public class TownGround extends Ground{
    @Override
    public void leave() {}

    @Override
    public Boolean enter() {
        return true;
    }
}
