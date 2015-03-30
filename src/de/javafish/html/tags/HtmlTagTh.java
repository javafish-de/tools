package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <th>}. Markiert eine Tabellenkopfzelle.
 *
 * @author fmk
 */
public class HtmlTagTh extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagTh() {
        super("th");
        setValidAttributes(new String[]{"abbr", "align", "axis", "bgcolor", "char", "charoff", "colspan", "headers", "height", "nowrap", "scope", "valign", "width"});
    }

}
