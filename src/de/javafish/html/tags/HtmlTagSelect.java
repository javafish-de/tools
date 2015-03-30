package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <select>}. Definiert eine Auswahlliste.
 *
 * @author fmk
 */
public class HtmlTagSelect extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagSelect() {
        super("select");
        setValidAttributes(new String[]{"disabled", "multiple", "name", "onblur", "onchange", "onfocus", "size", "tabindex"});
    }

}
