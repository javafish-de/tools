package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal
 * <pre>}. Formatiert einen Bereich wie im Editor eingegeben (vorformatierter
 * Text).
 *
 * @author fmk
 */
public class HtmlTagPre extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagPre() {
        super("pre");
        setValidAttributes(new String[]{"width"});
    }

}
