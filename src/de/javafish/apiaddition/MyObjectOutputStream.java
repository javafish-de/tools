package de.javafish.apiaddition;

import java.io.*;

/**
 * Erzeugt einen ObjectOutputStream.
 * 
 * @author fmk
 */
public class MyObjectOutputStream extends ObjectOutputStream {

    public MyObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }
    
    /**
     * Sendet ein serialisierbares Object in den OutputStream. Das übergebene
     * Object wird mit Hilfe von writeObject() in den OutputStream gesendet.
     * Im Gegensatz zur direkten Verwendung von writeObject() wird durch den
     * Compiler sichergestellt, dass auch tatsächlich eine Referenz auf ein 
     * serialisierbares Object übergeben wird.
     * 
     * @param ser an object that implements Serializable
     * @throws IOException 
     */
    public final void writeSerializable(Serializable ser) throws IOException {
        writeObject(ser);
    }
    
}
