package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <area>}. Definiert einen Ausschnitt für eine
 * verweis-sensitive Grafik.
 *
 * @author fmk
 */
public class HtmlTagArea extends HtmlSimpleTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagArea() {
        super("area");
        setValidAttributes(new String[]{"alt", "accesskey", "coords", "href", "nohref", "onblur", "onfocus", "shape", "tabindex", "target"});
    }

}
