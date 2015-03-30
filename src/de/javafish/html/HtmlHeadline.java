package de.javafish.html;

import de.javafish.html.tags.*;

/**
 * Die Klasse für ein Html {@literal  <hn>}-Tag.
 * 
 * @author fmk
 */
public class HtmlHeadline extends Html {

    /**
     * Erzeugt das Html {@literal  <hn>}-Tag angegebener Ordnung. 
     * 
     * @param ordnung 1. - 6. Ordnung
     */
    private HtmlHeadline(int ordnung) {
        tag = new HtmlTagH(ordnung);
    }

    /**
     * Erzeugt das Html {@literal  <hn>}-Tag mit den angegebenen Parametern. 
     * 
     * @param ordnung 1. - 6. Ordnung
     * @param text
     */
    public HtmlHeadline(int ordnung, String text) {
        this(ordnung);
        tag.setText(text);
    }
}
