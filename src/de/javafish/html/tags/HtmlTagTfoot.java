package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <tfoot>}. Bestimmt in einer Tabelle den Tabellenfuss.
 *
 * @author fmk
 */
public class HtmlTagTfoot extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagTfoot() {
        super("tfoot");
        setValidAttributes(new String[]{"align", "char", "charoff", "valign"});
    }

}
