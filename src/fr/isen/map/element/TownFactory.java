package fr.isen.map.element;

public class TownFactory extends MapElementFactory {
    //region Singleton
    private static TownFactory instance = null;

    private TownFactory() {
    }

    public static TownFactory getInstance() {
        if (instance == null) {
            instance = new TownFactory();
        }
        return instance;
    }
    //endregion

    @Override
    public Ground getGround() {
        return new TownGround();
    }

    @Override
    public Wall getWall() {
        return new TownWall();
    }
}
