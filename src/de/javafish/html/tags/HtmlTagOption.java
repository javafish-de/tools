package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <option>}. Markiert einen Eintrag in einer
 * Auswahlliste.
 *
 * @author fmk
 */
public class HtmlTagOption extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagOption() {
        super("option");
        setValidAttributes(new String[]{"disabled", "label", "selected", "value"});
    }

}
