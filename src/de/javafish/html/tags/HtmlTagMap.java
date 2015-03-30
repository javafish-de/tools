package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <map>}. Markiert einen Definitionsbereich für
 * verweis-sensitive Grafiken.
 *
 * @author fmk
 */
public class HtmlTagMap extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagMap() {
        super("map");
        setValidAttributes(new String[]{"name"});
    }

}
