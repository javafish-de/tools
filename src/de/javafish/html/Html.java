package de.javafish.html;

import de.javafish.html.tags.*;

/**
 * Abstrakte Klasse zur Erzeugung einfach zu nutzender Html-Elemente. Stellt ein
 * Attribut vom Typ {@link HtmlTag} bereit sowie eine Getter-Methode.
 *
 * @author fmk
 */
public abstract class Html {

    /**
     * Das HtmlTag.
     */
    protected HtmlTag tag;

    /**
     * Getter-Methode für das HtmlTag.
     * @return das HtmlTag
     */
    public HtmlTag getTag() {
        return tag;
    }

    /**
     * Liefert die Html-Ausgabe des HtmlTags.
     * 
     * @return die Html-Ausgabe des HtmlTags
     */
    @Override
    public String toString() {
        return getTag().getTagString();
    }
    
    /**
     * Gibt den übergebenen text mit dem Atribut bold aus.
     * 
     * @param text
     * @return 
     */
    public static String bold(String text) {
        HtmlTag t = new HtmlTagB();
        t.setText(text);
        return t.getTagString();
    }

    /**
     * Gibt den übergebenen text mit dem Atribut italic aus.
     * 
     * @param text
     * @return 
     */
    public static String italic(String text) {
        HtmlTag t = new HtmlTagI();
        t.setText(text);
        return t.getTagString();
    }

}