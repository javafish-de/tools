package de.javafish.html.tags;

/**
 * Repräsentiert das Attribut eines Html-Tags.
 *
 * @author fmk
 */
public class HtmlAttribute {

    private String attribute;
    private String value;

    /**
     * Erzeugt ein neues Attribut mit dem angegebenen Namen. Dieses Attribut hat
     * keinen Wert.
     *
     * @param attribute
     */
    public HtmlAttribute(String attribute) {
        this(attribute, null);
    }

    /**
     * Erzeugt ein neues Attribut mit den angegebenen Namen und weist ihm den
     * übergebenen Wert zu.
     *
     * @param attribute
     * @param value
     */
    public HtmlAttribute(String attribute, String value) {
        this.attribute = attribute.toLowerCase();
        this.value = value;
    }

    /**
     * Liefert das Attribut als String zurück.
     * 
     * @return das Attribut
     */
    public String getAttribute() {
        return attribute + getValue();
    }

    private String getValue() {
        return value == null ? "" : "=\"" + value + "\"";
    }

    /**
     * Die String-Repräsentation dieses Atributes.
     * 
     * @return das Attribut als String
     */
    @Override
    public String toString() {
        return getAttribute();
    }

}
