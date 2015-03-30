package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <applet>}. Fügt ein Java-Applet ein.
 * 
 * @author fmk
 */
public class HtmlTagApplet extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagApplet() {
        super("applet");
        setValidAttributes(new String[]{"align", "alt", "archive", "code", "codebase", "height", "hspace", "name", "object", "vspace", "width"});
    }
}
