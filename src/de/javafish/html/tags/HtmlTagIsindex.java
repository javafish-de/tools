package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <isindex>}. Erzeugt ein einzeiliges Eingabefeld.
 *
 * @author fmk
 */
public class HtmlTagIsindex extends HtmlSimpleTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagIsindex() {
        super("isindex");
        setValidAttributes(new String[]{"prompt"});
    }

}
