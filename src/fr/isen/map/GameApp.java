package fr.isen.map;

import fr.isen.map.controller.PlayerMovement;
import fr.isen.map.element.*;
import fr.isen.map.model.Player;
import fr.isen.map.view.GlobalView;
import fr.isen.map.view.PlayerView;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameApp extends JFrame {

    public GameApp() {
        super();
        Player Rayman = new Player("Rayman");
        int width = 20, height = 10;
        RPGWorlManager raymanManager = new RPGWorlManager(Rayman, width, height, new RPGMapBuilder(), ForestFactory.getInstance());
        PlayerMovement playerMovement = new PlayerMovement(raymanManager);
        RPGMap map = raymanManager.getRpg_map();
        List<List<MapElement>> elements = map.getElements();

        PlayerView playerView = new PlayerView(Rayman);
        GlobalView panel = new GlobalView(elements, playerView);

        this.setTitle("Mon application");
        this.setSize(width * 32, height * 32);
        this.setLocationRelativeTo(null);
        this.addKeyListener(playerMovement);

        this.setLayout(new BorderLayout());
        panel.add(playerView);
        this.getContentPane().add(panel, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
