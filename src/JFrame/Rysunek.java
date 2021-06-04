package JFrame;

import javax.swing.*;
import java.awt.*;

public class Rysunek extends JFrame {

    Image imageIcon = new ImageIcon(getClass().getClassLoader().getResource("ikona.png")).getImage();

    Rysunek() {
        super("Rysunek");
        setBounds(200, 100, 500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PanelRysunek panelRysunek = new PanelRysunek();
        setIconImage(imageIcon);

        setContentPane(panelRysunek);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Rysunek();
    }
}
