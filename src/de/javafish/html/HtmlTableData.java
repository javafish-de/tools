package de.javafish.html;

import de.javafish.html.tags.*;

/**
 * Repräsentiert ein Html {@literal <td>}-Tag.
 *
 * @author fmk
 */
public class HtmlTableData extends Html {

    /**
     * Erzeugt das {@code <td>}-Tag.
     */
    private HtmlTableData() {
        tag = new HtmlTagTd();
    }

    /**
     * Erzeugt das Html {@literal <td>}-Tag mit den angegebenen Parametern.
     *
     * @param data
     */
    public HtmlTableData(String data) {
        this(data, 1);
    }

    /**
     * Erzeugt das Html {@literal <td>}-Tag mit den angegebenen Parametern.
     *
     * @param data
     */
    public HtmlTableData(String data, int colspan) {
        this();
        tag.setText(data);
        tag.addAttribute("colspan", ""+colspan);
    }

}
