package fr.isen;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {
    public Application() {
        super();

        ImagePanel panel = new ImagePanel();

        this.setTitle("Mon application");
        this.setSize(640, 672);
        this.setLocationRelativeTo(null);

        this.setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}