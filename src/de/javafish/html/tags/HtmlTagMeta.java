package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <meta>}. Definiert Meta-Daten für eine Datei.
 * 
 * @author fmk
 */
public class HtmlTagMeta extends HtmlSimpleTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagMeta() {
        super("meta");
        setValidAttributes(new String[]{"name", "content", "http-equiv", "scheme"});
    }
}
