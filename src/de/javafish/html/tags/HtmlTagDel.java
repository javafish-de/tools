package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <del>}. Markiert Text als gelöscht.
 *
 * @author fmk
 */
public class HtmlTagDel extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagDel() {
        super("del");
        setValidAttributes(new String[]{"cite", "datetime"});
    }

}
