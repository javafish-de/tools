package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <img>}. Referenziert eine Grafik.
 * 
 * @author fmk
 */
public class HtmlTagImg extends HtmlSimpleTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagImg() {
        super("img");
        setValidAttributes(new String[]{"align", "alt", "border", "height", "hspace", "ismap", "longdesc", "name", "src", "usemap", "vspace", "width"});
    }
}