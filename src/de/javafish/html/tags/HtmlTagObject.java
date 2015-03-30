package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <object>}. Definiert ein Multimediaobjekt.
 *
 * @author fmk
 */
public class HtmlTagObject extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagObject() {
        super("object");
        setValidAttributes(new String[]{"align", "archive", "border", "classid", "codebase", "codetype", "data", "declare", "height", "hspace", "name", "standby", "tabindex", "type", "usemap", "vspace", "width"});
    }

}
