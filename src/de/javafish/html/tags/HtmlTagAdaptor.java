package de.javafish.html.tags;

/**
 * Die Implementierung des {@linkplain HtmlTag} Interface als Adapter-Klasse.
 *
 * @author fmk
 */
public class HtmlTagAdaptor implements HtmlTag {

    @Override
    public String getTagString() {
        return "";
    }

    @Override
    public String getTagString(String text) {
        return "";
    }

    @Override
    public void addTag(HtmlTag tag) {
    }

    @Override
    public void setText(String text) {
    }

    @Override
    public String getOpenTagString() {
        return "";
    }

    @Override
    public String getClosingString() {
        return "";
    }

    @Override
    public String getClosingTagString() {
        return "";
    }

    @Override
    public String getAttributeString() {
        return "";
    }

    @Override
    public String getTagName() {
        return "";
    }

    @Override
    public void addAttribute(String attribute) {
    }

    @Override
    public void addAttribute(String attribute, String value) {
    }

}
