package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <param>}. Definiert Parameter eines Multimediaobjekts
 * oder Java-Applets.
 *
 * @author fmk
 */
public class HtmlTagParam extends HtmlSimpleTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagParam() {
        super("param");
        setValidAttributes(new String[]{"id", "name", "value", "valuetype", "type"});
    }

}
