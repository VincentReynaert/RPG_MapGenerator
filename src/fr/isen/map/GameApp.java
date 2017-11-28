package fr.isen.map;

import fr.isen.map.controller.MapController;
import fr.isen.map.controller.PlayerMovement;
import fr.isen.map.element.ForestFactory;
import fr.isen.map.element.MapElement;
import fr.isen.map.model.Player;
import fr.isen.map.view.MapView;
import fr.isen.map.view.PlayerView;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameApp extends JFrame {

    public GameApp() {
        super();
        Player Rayman = new Player("Rayman");
        int width = 15, height = 20;
        RPGWorlManager raymanManager = new RPGWorlManager(Rayman, width, height, new RPGMapBuilder(), ForestFactory.getInstance());
        RPGMap map = raymanManager.getRpg_map();
        List<List<MapElement>> elements = map.getElements();

        PlayerView playerView = new PlayerView(Rayman);
        PlayerMovement playerMovement = new PlayerMovement(raymanManager, playerView);

//        GlobalView panel = new GlobalView(elements, playerView);
        MapController mapController = new MapController(raymanManager);
        MapView mapView = new MapView(mapController, width, height);

        this.setTitle("Mon application");
        this.setSize(width * 32, height * 32);
        this.setLocationRelativeTo(null);
        this.addKeyListener(playerMovement);

//        this.setLayout(new BorderLayout());
//        panel.add(playerView);
//        this.getContentPane().add(panel, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 0, 100));
        panel.setBounds(34, 34, 34, 34);
        JLayeredPane lp = getLayeredPane();
        lp.add(panel, new Integer(3));
        lp.add(playerView, new Integer(2));
        lp.add(mapView, new Integer(1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
