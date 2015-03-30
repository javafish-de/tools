/**
 * Hier findet sich für jedes mögliche Html-Tag eine Klasse welche dieses
 * repräsentiert. Die Bezeichnung der Tag-Klassen folgt dem Muster
 * <code>HtmlTagXxx</code> (in CamelCase-Screibweise), wobei Xxx der Name des
 * entsprechenden Html-Tags ist. <p>Jede Klasse verfügt über einen
 * parameterlosen Konstruktor, der eine Instanz des Html-Tags erzeugt.
 * Weitergehende Abhängigkeiten (wie z. B. Pfilchtattribute) werden nicht
 * überprüft.
 * </p>
 * <p><b>
 * Es wird daher dringend Empfohlen, zur Nutzung dieses Frameworks,
 * ausschliesslich die Klassen des Packeges {@code de.javafish.html} zu
 * verwenden.
 * </b></p>
 *
 */
package de.javafish.html.tags;