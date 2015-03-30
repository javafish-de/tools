package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <a>}. Definiert einen Anker oder einen Hyperlink.
 *
 * @author fmk
 */
public class HtmlTagA extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagA() {
        super("a");
        setValidAttributes(new String[]{"accesskey", "charset", "coords", "href", "hreflang", "name", "onblur", "onfocus", "rel", "rev", "shape", "tabindex", "target", "type"});
    }

}
