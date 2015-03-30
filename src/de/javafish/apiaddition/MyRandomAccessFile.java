package de.javafish.apiaddition;

import java.io.*;

/**
 * Erweitert die API-Klasse java.io.RandomAccessFile. Zwei Methoden werden
 * hinzugefügt, die in Abhängigkeit von length() und getFilePointer() ermitteln,
 * ob EOF erreicht ist, oder ob noch mehr zum Lesen zur Verfügung steht. Die
 * API-Klasse RandomAccessFile stellt unterschiedliche Mechanismen zur Verfügung
 * EOF zu detektieren: readLine() liefert
 * <code>null</code>, die überladenen read()-Methoden liefern -1 und die
 * qualifizierten readXxx()-Methoden werfen eine EOFException.
 *
 * @author javafish
 * @version 0.1
 * @since 2012
 */
public class MyRandomAccessFile extends RandomAccessFile {

    public MyRandomAccessFile(File file, String mode) throws FileNotFoundException {
        super(file, mode);
    }

    public MyRandomAccessFile(String name, String mode) throws FileNotFoundException {
        super(name, mode);
    }

    /**
     * Überprüft, ob noch die angegebene Anzahl Bytes zum Lesen vorhanden sind.
     * Gibt true zurück, sofern noch mindestens len Bytes zum Lesen vorhanden
     * sind.
     *
     * @param len the number of Bytes to read
     * @return true, if there are at least len more Bytes to read
     */
    public boolean hasMore(int len) {
        try {
            return ((this.getFilePointer() + len) <= this.length());
        } catch (IOException ex) {
//            Logger.getLogger(MyRandomAccessFile.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Überprüft, ob noch mindestens ein Byte zu, Lesen vorhanden ist. Gibt true
     * zurück, sofern noch mindestens 1 Byte zum Lesen vorhanden ist.
     *
     * @return true, if there is at least one more byte to read
     */
    public boolean hasMore() {
        return this.hasMore(1);
    }

    /**
     * Überprüft, ob noch ein Short zum Lesen vorhanden ist. Gibt true zurück,
     * sofern noch mindestens 2 Byte zum Lesen vorhanden sind.
     *
     * @return true, if there are at least two more byte to read
     */
    public boolean hasMoreShort() {
        return this.hasMore(2);
    }

    /**
     * Überprüft, ob noch ein Char zum Lesen vorhanden ist. Gibt true zurück,
     * sofern noch mindestens 2 Byte zum Lesen vorhanden sind.
     *
     * @return true, if there are at least two more byte to read
     */
    public boolean hasMoreChar() {
        return this.hasMore(2);
    }

    /**
     * Überprüft, ob noch ein Integer zum Lesen vorhanden ist. Gibt true zurück,
     * sofern noch mindestens 4 Byte zum Lesen vorhanden sind.
     *
     * @return true, if there are at least four more byte to read
     */
    public boolean hasMoreInt() {
        return this.hasMore(4);
    }

    /**
     * Überprüft, ob noch ein Long zum Lesen vorhanden ist. Gibt true zurück,
     * sofern noch mindestens 8 Byte zum Lesen vorhanden sind.
     *
     * @return true, if there are at least eight more byte to read
     */
    public boolean hasMoreLong() {
        return this.hasMore(8);
    }

    /**
     * Überprüft, ob noch ein Float zum Lesen vorhanden ist. Gibt true zurück,
     * sofern noch mindestens 4 Byte zum Lesen vorhanden ist.
     *
     * @return true, if there are at least four more byte to read
     */
    public boolean hasMoreFloat() {
        return this.hasMore(4);
    }

    /**
     * Überprüft, ob noch ein Double zum Lesen vorhanden ist. Gibt true zurück,
     * sofern noch mindestens 8 Byte zum Lesen vorhanden ist.
     *
     * @return true, if there are at least eight more byte to read
     */
    public boolean hasMoreDouble() {
        return this.hasMore(8);
    }

    /**
     * Überprüft, ob End-Of-File erreicht ist. Gibt true zurück, wenn der
     * FilePointer auf der letzten File-Position oder dahinter steht. Wenn false
     * zurückgeliefert wird, ist nicht garantiert, dass sämtliche read-Methoden
     * fehlerfrei lesen.
     *
     * @return true, if End-Of-File is reached | false, if there is at least one
     * byte to read
     */
    public boolean isEOF() {
        return !hasMore();
    }

}