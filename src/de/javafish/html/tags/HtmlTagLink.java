package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <link>}. Definiert logische Beziehungen zu anderen
 * Dateien.
 *
 * @author fmk
 */
public class HtmlTagLink extends HtmlSimpleTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagLink() {
        super("link");
        setValidAttributes(new String[]{"charset", "href", "hreflang", "media", "rel", "rev", "target", "type"});
    }

}
