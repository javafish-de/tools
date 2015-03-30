package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <colgroup>}. Definiert eine Gruppe von Tabellenspalten.
 *
 * @author fmk
 */
public class HtmlTagColgroup extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagColgroup() {
        super("colgroup");
        setValidAttributes(new String[]{"align", "char", "charoff", "span", "valign", "width"});
    }

}
