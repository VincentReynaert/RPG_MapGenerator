package fr.isen;

import fr.isen.map.GameApp;
import fr.isen.map.element.MazeFactory;

public class Main {
    public static void main(String[] args) {
        new GameApp(50,10, MazeFactory.getInstance());
    }
}
