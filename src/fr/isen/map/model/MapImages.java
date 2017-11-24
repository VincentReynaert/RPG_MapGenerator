package fr.isen.map.model;

import java.net.URL;
import java.util.Hashtable;

public class MapImages {
    private static MapImages instance = null;
    private static Hashtable<String, String> urls = new Hashtable<>();

    private MapImages(){
        addUrl("FG", "./ForestSnowGround.png");
        addUrl("FGFP", "./ForestSnowGroundFooPrints.png");
        addUrl("FW", "./ForestWood.png");
        addUrl("FWS", "./ForestWoodSnow.png");
        addUrl("MG", "./MazeGround.png");
        addUrl("MGG", "./MazeGroundGlowing.png");
        addUrl("MW", "./MazeWall.png");
        addUrl("MWG", "./MazeWallGlowing.png");
        addUrl("TG", "./TownGround.png");
        addUrl("TW", "./TownWall.png");
    }

    public static MapImages getInstance() {
        if (instance == null) instance = new MapImages();
        return instance;
    }

    public static URL getUrl(String key) {
        return ClassLoader.getSystemResource(urls.get(key));
    }

    private void addUrl(String key, String url) {
        urls.put(key, url);
    }
}
