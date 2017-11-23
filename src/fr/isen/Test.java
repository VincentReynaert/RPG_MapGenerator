package fr.isen;


import fr.isen.map.*;
import fr.isen.map.element.ForestFactory;
import fr.isen.map.element.MazeFactory;
import fr.isen.map.element.TownFactory;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Player Link = new Player("Link");
        Player Zelda = new Player("Zelda");
        Player Rayman = new Player("Rayman");
        RPGWorlManager linkManager = new RPGWorlManager(Link, 50, 100, new RPGMapBuilder(), TownFactory.getInstance());
        //manager.moveRight();
        moveShuffle(5, linkManager);
        RPGWorlManager zeldaManager = new RPGWorlManager(Zelda, 50, 100, new RPGMapBuilder(), MazeFactory.getInstance());
        //manager.moveRight();
        moveShuffle(5, zeldaManager);
        RPGWorlManager raymanManager = new RPGWorlManager(Rayman, 50, 100, new RPGMapBuilder(), ForestFactory.getInstance());
        //manager.moveRight();
        moveShuffle(5, raymanManager);
    }

    private static void moveShuffle(int moves, RPGWorlManager manager) {
        int i = 0;
        while (i < moves) {
            System.out.println();
            System.out.println();
            System.out.println(manager.getName());
            i++;
            int j = new Random().nextInt(4);
            switch (j) {
                case 0:
                    System.out.println("South");
                    manager.moveSouth();
                    break;
                case 1:
                    System.out.println("West");
                    manager.moveWest();
                    break;
                case 2:
                    System.out.println("East");
                    manager.moveEast();
                    break;
                case 3:
                    System.out.println("North");
                    manager.moveNorth();
                    break;
            }
        }
    }
}
