package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <dir>}. Markiert eine Verzeichnisliste.
 *
 * @author fmk
 */
public class HtmlTagDir extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagDir() {
        super("dir");
        setValidAttributes(new String[]{"compact"});
    }

}
