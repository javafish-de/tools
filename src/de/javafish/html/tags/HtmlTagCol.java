package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <col>}. Definiert Daten für eine Tabellenspalte.
 *
 * @author fmk
 */
public class HtmlTagCol extends HtmlSimpleTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagCol() {
        super("col");
        setValidAttributes(new String[]{"align", "char", "charoff", "span", "valign", "width"});
    }

}
