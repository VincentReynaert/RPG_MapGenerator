package fr.isen.map;

import fr.isen.map.controller.MapController;
import fr.isen.map.controller.PlayerMovement;
import fr.isen.map.element.*;
import fr.isen.map.model.Player;
import fr.isen.map.view.MapView;
import fr.isen.map.view.PlayerView;

import javax.swing.*;

public class GameApp extends JFrame {

    public GameApp(int width, int height, MapElementFactory mapElementFactory) {
        super();
        //region Init
        Player Rayman = new Player("Rayman");
        RPGWorlManager raymanManager = new RPGWorlManager(Rayman, width, height, new RPGMapBuilder(), mapElementFactory);

        PlayerView playerView = new PlayerView(Rayman);
        PlayerMovement playerMovement = new PlayerMovement(raymanManager, playerView);

        MapController mapController = new MapController(raymanManager);
        MapView mapView = new MapView(mapController, width, height);
        //endregion

        this.setTitle("Mon application");
        this.setSize(width * 32, height * 32);
        this.setLocationRelativeTo(null);
        this.addKeyListener(playerMovement);

        JLayeredPane lp = getLayeredPane();
        lp.add(playerView, new Integer(2));
        lp.add(mapView, new Integer(1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
