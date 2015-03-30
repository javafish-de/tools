package de.javafish.html.tags;

/**
 * Das HtmlTag {@literal <table>}. Erzeugt eine Tabelle.
 * 
 * @author fmk
 */
public class HtmlTagTable extends HtmlBodyTag {

    /**
     * Erzeugt ein leeres HtmlTag.
     */
    public HtmlTagTable() {
        super("table");
        setValidAttributes(new String[]{"align", "border", "bgcolor", "cellpadding", "cellspacing", "frame", "rules", "summary", "width"});
    }
}
