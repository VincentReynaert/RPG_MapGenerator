package fr.isen.map.element;

public class MazeFactory extends MapElementFactory {
    //region Singleton
    private static MazeFactory instance = null;
    private MazeFactory(){}
    public static MazeFactory getInstance() {
        if (instance == null) {
            instance = new MazeFactory();
        }
        return instance;
    }

    @Override
    public Ground getGround() {
        return new MazeGround();
    }

    @Override
    public Wall getWall() {
        return new MazeWall();
    }
    //endregion

}
