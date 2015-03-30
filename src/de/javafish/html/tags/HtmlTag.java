package de.javafish.html.tags;

/**
 * Das HTML-Tag. Ein Interface mit den für ein HTML-Tag erforderlichen Methoden.
 * Es wird von sämtlichen nativen HtmlTag-Klassen implementiert.
 *
 * @author fmk
 */
public interface HtmlTag {

    /**
     * Fügt dem HtmlTag ein inneres HtmlTag hinzu. Das HtmlTag ist vom
     * Entwurfsmuster eines Kompositums. Es kann selbst wieder HtmlTags
     * beinhalten.
     *
     * @param tag
     */
    public void addTag(HtmlTag tag);

    /**
     * Fügt dem HtmlTag ein Attribut ohne Wertangabe hinzu.
     *
     * @param attribute
     */
    public void addAttribute(String attribute);

    /**
     * Fügt dem HtmlTag ein Attribut mit Werttangabe hinzu.
     *
     * @param attribute
     * @param value
     */
    public void addAttribute(String attribute, String value);

    /**
     * Fügt dem HtmlTag einen inneren Text hinzu. Dieser Text wird zwischen dem
     * öffnenden und dem schliessenden Tag eingefügt.
     *
     * @param text
     */
    public void setText(String text);

    /**
     * Liefert die String-Repräsentation des Tag.
     *
     * @return die String-Repräsentation des Tag
     */
    public String getTagString();

    /**
     * Liefert die String-Repraesentation des Tag, inkl innerem Text.
     *
     * @param text
     * @return die String-Repräsentation des Tag
     */
    public String getTagString(String text);

    /**
     * Liefert den String des öffnenden Tags.
     * 
     * @return der String des öffnenden Tags
     */
    public String getOpenTagString();

    /**
     * Liefert den String, mit dem das öffnende Tag geschlossen wird.
     * 
     * @return der String, mit dem das öffnende Tag geschlossen wird
     */
    public String getClosingString();

    /**
     * Liefert den String des schliessenden Tag.
     * 
     * @return der String des schliessenden Tag
     */
    public String getClosingTagString();

    /**
     * Liefert den String, der die Attribute des Tag representiert.
     * 
     * @return der String, der die Attribute des Tag representiert
     */
    public String getAttributeString();

    /**
     * Liefert den Namen des Tag.
     * 
     * @return der Namen des Tag
     */
    public String getTagName();

}
