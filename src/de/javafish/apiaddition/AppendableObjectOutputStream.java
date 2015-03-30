package de.javafish.apiaddition;

import java.io.*;

/**
 * Erzeugt einen ObjectOutputStream. Der Stream ist in der Lage, Objekte an
 * eine vorhandene Datei anzuhängen. Dabei wird auf das erneute Senden
 * (Schreiben) des StreamHeader verzichtet.
 * 
 * @author fmk (inspired by S.R.)
 */
public class AppendableObjectOutputStream extends ObjectOutputStream {

    public AppendableObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }
    
    @Override
    protected void writeStreamHeader() throws IOException {
        // no header to write
    }
}
