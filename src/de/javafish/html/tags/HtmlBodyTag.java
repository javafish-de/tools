package de.javafish.html.tags;

import java.util.*;

/**
 * Ein HTML-Tag mit schliessendem Tag. Dieses Tag wird explizit mittels
 * "<code>{@literal </tagname>}</code>" geschlossen.
 *
 * @author fmk
 */
public abstract class HtmlBodyTag extends HtmlSimpleTag {

    /**
     * Eine Liste mit den Html-Tags, die in diesem Tag integriert sind.
     */
    private List<HtmlTag> innerTags = new LinkedList<>();
    /**
     * Der Text, der zwischen öffnendem und schliessendem Tag erscheint.
     */
    private String innerText = "";

    public HtmlBodyTag(String tag) {
        super(tag);
    }

    @Override
    public void addTag(HtmlTag tag) {
        innerTags.add(tag);
    }

    @Override
    public void setText(String text) {
        this.innerText = text;
    }

    private String getInnerTags() {
        String s = "";
        s = innerTags.stream().map((htmlTag) -> htmlTag.getTagString()).reduce(s, String::concat);
        return s;
    }

    @Override
    public String getTagString() {
        return getTagString(getInnerTags() + innerText);
    }

    @Override
    public String getClosingTagString() {
        return "</" + getTagName() + ">";
    }

    @Override
    public String getClosingString() {
        return "";
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 17 * hash + (this.innerTags != null ? this.innerTags.hashCode() : 0);
        hash = 17 * hash + (this.innerText != null ? this.innerText.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HtmlBodyTag other = (HtmlBodyTag) obj;
        if (this.innerTags != other.innerTags && (this.innerTags == null || !this.innerTags.equals(other.innerTags))) {
            return false;
        }
        if ((this.innerText == null) ? (other.innerText != null) : !this.innerText.equals(other.innerText)) {
            return false;
        }
        return super.equals(obj);
    }
    
}
