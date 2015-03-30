package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <iframe>}. Definiert ein eingebettetes Fenster.
 *
 * @author fmk
 */
public class HtmlTagIframe extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagIframe() {
        super("iframe");
        setValidAttributes(new String[]{"align", "frameborder", "height", "longdesc", "marginwidth", "marginheight", "name", "scrolling", "src", "width"});
    }

}
