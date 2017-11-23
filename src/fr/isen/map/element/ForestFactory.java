package fr.isen.map.element;

public class ForestFactory extends MapElementFactory {
    //region Singleton
    private static ForestFactory instance = null;
    private ForestFactory(){}
    public static ForestFactory getInstance() {
        if (instance == null) {
            instance = new ForestFactory();
        }
        return instance;
    }
    //endregion

    @Override
    public Ground getGround() {
        return new ForestGround();
    }

    @Override
    public Wall getWall() {
        return new ForestWall();
    }
}
