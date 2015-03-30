package de.javafish.html;

import de.javafish.html.tags.*;

/**
 * Repräsentiert einen Container für Html-Tags. Es wird folgendes Grundgerüst
 * von Tags bereitgestellt. <p>
 * <code>
 * {@literal <div>}{@literal </div>}</br>
 * </code> </p> <p> Die Gestaltung des Formulars erfolgt in der Hauptsache durch
 * nachfolgende Aufrufe der add()-Methode, welche Html-Elemente aufnimmt und dem
 * Container hinzufügt. </p>
 *
 * @author fmk
 */
public class HtmlContainer extends Html {

    /**
     * Ein {@literal <br>}-Tag.
     */
    public static final HtmlTag BR = new HtmlTagBr();
    /**
     * Ein {@literal <hr>}-Tag.
     */
    public static final HtmlTag HR = new HtmlTagHr();

    /**
     * Erzeugt einen leeren Container.
     */
    public HtmlContainer() {
        tag = new HtmlTagDiv();
    }

    /**
     * Fügt dem Container ein HtmlTag hinzu.
     * 
     * @param tag ein HtmlTag
     */
    public void add(HtmlTag tag) {
        this.tag.addTag(tag);
    }

    /**
     * Fügt dem Container einen Text hinzu.
     *
     * @param text
     */
    public void add(String text) {
        add(new HtmlTagText(text));
    }

    /**
     * Fügt dem Container einen Link hinzu.
     *
     * @param url
     * @param text
     */
    public void addLink(String url, String text) {
        add(new HtmlLink(url, text).getTag());
    }

    /**
     * Fügt dem Container ein {@literal <h1>}-Tag hinzu.
     *
     * @param text
     */
    public void addHeadline(String text) {
        addHeadline1(text);
    }

    /**
     * Fügt dem Container ein {@literal <h1>}-Tag hinzu.
     *
     * @param text
     */
    public void addHeadline1(String text) {
        addHeadline(1, text);
    }

    /**
     * Fügt dem Container ein {@literal <h2>}-Tag hinzu.
     *
     * @param text
     */
    public void addHeadline2(String text) {
        addHeadline(2, text);
    }

    /**
     * Fügt dem Container ein {@literal <h3>}-Tag hinzu.
     *
     * @param text
     */
    public void addHeadline3(String text) {
        addHeadline(3, text);
    }

    /**
     * Fügt dem Container ein {@literal <h4>}-Tag hinzu.
     *
     * @param text
     */
    public void addHeadline4(String text) {
        addHeadline(4, text);
    }

    /**
     * Fügt dem Container ein {@literal <h5>}-Tag hinzu.
     *
     * @param text
     */
    public void addHeadline5(String text) {
        addHeadline(5, text);
    }

    /**
     * Fügt dem Container ein {@literal <h6>}-Tag hinzu.
     *
     * @param text
     */
    public void addHeadline6(String text) {
        addHeadline(6, text);
    }

    /**
     * Fügt dem Container ein {@literal <h.>}-Tag hinzu.
     *
     * @param i
     * @param text
     */
    public void addHeadline(int i, String text) {
        add(new HtmlHeadline(i, text).getTag());
    }

    /**
     * Fügt dem Container eine HtmlTable hinzu. Diese Tabelle sollte
     * bereits im Vorfeld mit der kompletten Tabellen-Struktur befüllt worden
     * sein.
     *
     * @param table
     */
    public void addTable(HtmlTable table) {
        add(table.getTable());
    }

    /**
     * Fügt dem Container eine HtmlForm hinzu. Dieses Formular
     * sollte bereits im Vorfeld mit der kompletten Formular-Struktur befüllt
     * worden sein.
     *
     * @param form
     */
    public void addForm(HtmlForm form) {
        add(form.getForm());
    }

    /**
     * Fügt dem Container eine HtmlList hinzu. Diese Liste sollte
     * bereits im Vorfeld mit der kompletten Listen-Struktur befüllt worden
     * sein.
     *
     * @param list
     */
    public void addList(HtmlList list) {
        add(list.getList());
    }

    /**
     * Fügt dem Container ein {@literal <hr>}-Tag hinzu.
     */
    public void addHR() {
        add(HR);
    }

    /**
     * Fügt dem Container ein {@literal <br>}-Tag hinzu.
     */
    public void addBR() {
        add(BR);
    }

    /**
     * Fügt dem Container ein {@literal <br>}-Tag hinzu.
     */
    public void addNewline() {
        addBR();
    }

    /**
     * Liefert den kompletten Container als Html-String.
     * 
     * @return den Html-String
     */
    @Override
    public String toString() {
        return tag.getTagString();
    }

}