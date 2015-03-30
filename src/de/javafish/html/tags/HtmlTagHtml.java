package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <html>}. Wurzelelement einer HTML-Datei.
 * 
 * @author fmk
 */
public class HtmlTagHtml extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagHtml() {
        super("html");
        setValidAttributes(new String[]{"version"});
    }
}
