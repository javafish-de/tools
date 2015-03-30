package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <basefont>}. Bestimmt Basis-Schriftmerkmale für
 * nachfolgenden Text.
 *
 * @author fmk
 */
public class HtmlTagBasefont extends HtmlSimpleTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagBasefont() {
        super("basefont");
        setValidAttributes(new String[]{"color", "face", "size"});
    }

}
