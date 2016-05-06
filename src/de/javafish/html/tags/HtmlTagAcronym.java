package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <acronym>}. Markiert eine Abkürzung.
 * 
 * @author fmk
 * @deprecated use: {@link HtmlTagAbbr}
 */
@Deprecated
public class HtmlTagAcronym extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagAcronym() {
        super("acronym");
        // no more attributes
    }
}
