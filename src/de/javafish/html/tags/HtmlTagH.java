package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <hx>}. Markiert eine Überschrift 1. bis 6. Ordnung.
 *
 * @author fmk
 */
public class HtmlTagH extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     * @param ordnung
     */
    public HtmlTagH(int ordnung) {
        super("h" + Math.max(1, Math.min(6, ordnung)));
        setValidAttributes(new String[]{"align"});
    }

}
