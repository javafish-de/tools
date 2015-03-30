package de.javafish.html.tags;

/**
 * Eine Aufzählung der möglichen Ausrichtungen, welche als Wert dem Attribut
 * {@code align=} übergeben werden können.
 *
 * @author fmk
 */
public enum HtmlAlignment {

    /**
     * Richtet das Element oben aus.
     */
    TOP,
    /**
     * Richtet das Element vertikal zentriert aus.
     */
    MIDDLE,
    /**
     * Richtet das Element unten aus.
     */
    BOTTOM,
    /**
     * Richtet das Element linksbündig aus.
     */
    LEFT,
    /**
     * Richtet das Element rechtsbündig aus.
     */
    RIGHT,
    /**
     * Richtet das Element horizontal zentriert aus.
     */
    CENTER,
    /**
     * Richtet das Element als Block aus.
     */
    JUSTIFY,;

    /**
     * Liefert die Ausgabe der Aufzählungs-Konstante in kleinbuchstaben.
     * 
     * @return die Ausgabe der Aufzählungs-Konstante in kleinbuchstaben
     */
    @Override
    public String toString() {
        return name().toLowerCase();
    }

}
