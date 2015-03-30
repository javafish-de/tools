package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <caption>}. Setzt eine Tabellenüberschrift oder eine
 * Tabellenunterschrift.
 *
 * @author fmk
 */
public class HtmlTagCaption extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagCaption() {
        super("caption");
        setValidAttributes(new String[]{"align"});
    }

}
