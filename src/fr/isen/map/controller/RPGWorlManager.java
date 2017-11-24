package fr.isen.map.controller;

import com.Logger.Logger;
import fr.isen.map.Position;
import fr.isen.map.RPGMap;
import fr.isen.map.RPGMapBuilder;
import fr.isen.map.element.MapElement;
import fr.isen.map.element.MapElementFactory;
import fr.isen.map.model.Player;
import org.jetbrains.annotations.NotNull;

public class RPGWorlManager {
    private Logger moveLogger = Logger.getLogger("move", null);
    private Player player = null;

    public RPGMap getRpg_map() {
        return rpg_map;
    }

    private RPGMap rpg_map;

    public RPGWorlManager(Player player, int width, int height, RPGMapBuilder builder, MapElementFactory mapElementFactory) {
        builder.setFactory(mapElementFactory);
        builder.setSize(width, height);
        rpg_map = builder.build();
        Position initialPosition = initialPlayerPosition(builder, width, height);
        player.setPosition(initialPosition);
        this.player = player;
        System.out.println("Player : " + initialPosition.x + ", " + initialPosition.y);
        printRPGMap(builder, width, height);
    }

    private void printRPGMap(RPGMapBuilder rpgMapBuilder, int w, int h) {
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (rpgMapBuilder.isWall(i, j)) System.out.print("#");
                else System.out.print(".");
            }
            System.out.println("");
        }
    }

    @NotNull
    private Position initialPlayerPosition(RPGMapBuilder builder, int w, int h) {
        int i = 1, j = 1;
        while (i < w) {
            while (j < h) {
                if (!builder.isWall(i, j)) return new Position(i, j);
                j++;
            }
            j = 1;
            i++;
        }
        return new Position(0, 0);
    }

    public String getName() {
        return player.getName();
    }

    //region Move
    private void move(int x, int y, String direction) {
        MapElement element = rpg_map.getElement(x, y);
        if (element.enter()) {
            Position newPosition = new Position(x, y);
            element.leave();
            player.setPosition(newPosition);
            moveLogger.info(direction + " : player position = x " + newPosition.x + ", y " + newPosition.y);
        } else moveLogger.error(" there is an obstacle " + direction + "!");
    }

    public void moveNorth() {
        Position position = player.getPosition();
        if (position.y > 0) move(position.x - 1, position.y, " Up");
        else moveLogger.error(" cannot move Up");
    }

    public void moveSouth() {
        Position position = player.getPosition();
        if (position.y < rpg_map.getHeight()) move(position.x + 1, position.y, " Down");
        else moveLogger.error(" cannot move Down");
    }

    public void moveWest() {
        Position position = player.getPosition();
        if (position.x > 0) move(position.x, position.y - 1, " Left");
        else moveLogger.error(" cannot move Left");
    }

    public void moveEast() {
        Position position = player.getPosition();
        if (position.x < rpg_map.getWidth()) move(position.x, position.y + 1, " Right");
        else moveLogger.error(" cannot move Right");
    }
    //endregion
}
