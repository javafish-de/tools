package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <script>}. Definiert einen Bereich für Scripts.
 * 
 * @author fmk
 */
public class HtmlTagScript extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagScript() {
        super("script");
        setValidAttributes(new String[]{"charset", "defer", "event", "language", "for", "src", "type"});
    }

}
