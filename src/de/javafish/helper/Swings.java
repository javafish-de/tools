package de.javafish.helper;

import java.awt.*;

/**
 * Utility-Klasse für grafische Oberflächen.
 * 
 * @author fmk
 */
public class Swings {

    private Swings() {
    }

    /**
     * Zentriert den referenzierten Frame auf dem Bildschirm.
     * 
     * @param frame 
     */
    public static void centerFrame(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }

}
