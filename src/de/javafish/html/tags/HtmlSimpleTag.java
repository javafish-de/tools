package de.javafish.html.tags;

import java.util.*;

/**
 * Ein einfaches HTML-Tag (ohne schliessendes Tag). Dieses Tag wird implizit mit
 * {@code "/>"} geschlossen.
 *
 * @author fmk
 */
public abstract class HtmlSimpleTag implements HtmlTag {

    /**
     * Die Html-Bezeichnung des Tag.
     */
    private String name;
    /**
     * Eine Liste mit den für dieses Tag gültigen Attribut-Bezeichnungen.
     */
    private List<String> validAttributes =
            new ArrayList<String>(Arrays.asList(new String[]{"class", "id", "style", "title"}));
    /**
     * Die Liste mit den für dieses Tag verwendeten Attributen.
     */
    private List<HtmlAttribute> attributes = new LinkedList<HtmlAttribute>();

    /**
     * Das HtmlTag mit dem angegebenen Namen wird erzeugt.
     *
     * @param name
     */
    public HtmlSimpleTag(String name) {
        this.name = name;
    }

    /**
     * Fügt dem HtmlTag ein Attribut ohne Wertangabe hinzu.
     *
     * @param attribute
     */
    @Override
    public void addAttribute(String attribute) {
        addAttribute(attribute, null);
    }

    /**
     * Fügt dem HtmlTag ein Attribut mit Wertangabe hinzu.
     *
     * @param attribute
     * @param value
     */
    @Override
    public void addAttribute(String attribute, String value) {
        if (isAttributeValid(attribute)) {
            attributes.add(new HtmlAttribute(attribute, value));
        }
    }

    /**
     * Überprüft, ob das übergebene Attribut in der Liste der gültigen Attribute
     * enthalten ist.
     *
     * @param attribute
     * @return {@code true}, wenn das Attribut gültig ist
     */
    private boolean isAttributeValid(String attribute) {
        return validAttributes.contains(attribute);
    }

    /**
     * Fügt der Liste der gültigen Attribute weitere hinzu.
     * 
     * @param validAttributes 
     */
    public void setValidAttributes(String[] validAttributes) {
        this.validAttributes.addAll(Arrays.asList(validAttributes));
    }

    @Override
    public String getTagString() {
        return getTagString("");
    }

    @Override
    public String getTagString(String text) {
        return getOpenTagString() + text + getClosingTagString();
    }

    @Override
    public final String getOpenTagString() {
        return "<"
                + getTagName()
                + getAttributeString()
                + getClosingString()
                + ">";
    }

    @Override
    public String getClosingString() {
        return " /";
    }

    @Override
    public String getClosingTagString() {
        return "";
    }

    @Override
    public String getAttributeString() {
        String s = " ";
        for (HtmlAttribute htmlAttribute : attributes) {
            s += htmlAttribute.getAttribute();
            s += " ";
        }
        return s.substring(0, s.length() - 1);
    }

    @Override
    public String getTagName() {
        return name;
    }

    @Override
    public void addTag(HtmlTag tag) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setText(String text) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return getTagString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HtmlSimpleTag other = (HtmlSimpleTag) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if (this.attributes != other.attributes && (this.attributes == null || !this.attributes.equals(other.attributes))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 67 * hash + (this.attributes != null ? this.attributes.hashCode() : 0);
        return hash;
    }

}
