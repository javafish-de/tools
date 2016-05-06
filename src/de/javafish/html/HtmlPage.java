package de.javafish.html;

import de.javafish.html.tags.*;

/**
 * Diese Klasse repräsentiert eine Html-Seite. Es wird folgendes Grundgerüst von
 * Tags bereitgestellt.
 * <p>
 * <code>
 * {@literal <html>}<br /> {@literal <head>}<br />
 * {@literal <title>titel</title>}<br /> {@literal </head>}<br />
 * {@literal <body>}<br /> {@literal </body>}<br /> {@literal </html>}<br />
 * </code>
 * </p>
 * <p>
 * Die Gestaltung der Seite erfolgt in der Hauptsache durch
 * nachfolgende Aufrufe der {@code add()}-Methode, welche weitere Tags aufnimmt
 * und dem {@literal <body>} hinzufügt.
 * </p>
 *
 * @author fmk
 */
public class HtmlPage extends HtmlBody {

    private final HtmlTagHtml htmlTag = new HtmlTagHtml();
    private final HtmlTagHead headTag = new HtmlTagHead();
    private final HtmlTagTitle titleTag;

    /**
     * Erzeugt eine Html-Seite mit dem angegebenen Titel.
     *
     * @param title
     */
    public HtmlPage(String title) {
        titleTag = new HtmlTagTitle();
        titleTag.setText(title);
        headTag.addTag(titleTag);
        htmlTag.addTag(headTag);
        htmlTag.addTag(tag);
    }

    /**
     * Fügt dem {@literal <head>}-Tag ein HtmlTag hinzu.
     *
     * @param tag
     */
    public void addToHead(HtmlTag tag) {
        headTag.addTag(tag);
    }

    @Override
    public String toString() {
        return "<!DOCTYPE html>" + htmlTag.getTagString();
    }

}
