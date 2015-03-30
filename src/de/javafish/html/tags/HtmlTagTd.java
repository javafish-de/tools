package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <td>}. Markiert eine Tabellenzelle.
 *
 * @author fmk
 */
public class HtmlTagTd extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagTd() {
        super("td");
        setValidAttributes(new String[]{"abbr", "align", "axis", "bgcolor", "char", "charoff", "colspan", "headers", "height", "nowrap", "rowspan", "scope", "valign", "width"});
    }

}
