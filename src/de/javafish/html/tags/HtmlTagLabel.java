package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <label>}. Ordnet Text einem bestimmten Formularfeld zu.
 *
 * @author fmk
 */
public class HtmlTagLabel extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagLabel() {
        super("label");
        setValidAttributes(new String[]{"accesskey", "for", "onblur", "onfocus"});
    }

}
