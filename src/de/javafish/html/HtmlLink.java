package de.javafish.html;

import de.javafish.html.tags.*;

/**
 * Die Klasse für ein Html {@literal  <a>}-Tag.
 * 
 * @author fmk
 */
public class HtmlLink extends Html {

    private HtmlLink() {
        tag = new HtmlTagA();
    }

    /**
     * Erzeugt das Html {@literal  <a>}-Tag mit den angegebenen Parametern.
     * 
     * @param url 
     * @param text
     */
    public HtmlLink(String url, String text) {
        this();
        tag.addAttribute("href", url);
        tag.setText(text);
    }
}
