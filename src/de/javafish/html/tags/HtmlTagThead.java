package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <thead>}. Bestimmt in einer Tabelle den Tabellenkopf.
 *
 * @author fmk
 */
public class HtmlTagThead extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagThead() {
        super("thead");
        setValidAttributes(new String[]{"align", "char", "charoff", "valign"});
    }

}
