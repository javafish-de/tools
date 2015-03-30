package de.javafish.html.tags;

/**
 * Repräsentiert einen einfachen Text, der von einem HtmlTag aufgenommen werden
 * kann.
 *
 * @author fmk
 */
public class HtmlTagText extends HtmlTagAdaptor {

    /**
     * Der Text.
     */
    private String text;

    /**
     * Erzeugt einen einfachen Text.
     *
     * @param text
     */
    public HtmlTagText(String text) {
        this.text = text;
    }

    /**
     * Liefert den Text zurück.
     *
     * @return der Text
     */
    @Override
    public String getTagString() {
        return text;
    }

}
