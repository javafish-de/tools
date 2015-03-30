package de.javafish.helper;

import java.io.*;

/**
 *
 * @author fmk
 */
public class ByteHelper implements Serializable {

    private final Byte myByte;

    public ByteHelper(byte myByte) {
        this.myByte = myByte;
    }

    public static String binaryByte(byte myByte) {
        String str = ".";
        for (int i = 7; i >= 0; i--) {
            str += isBit(myByte, i) ? "1" : "0";
            if (i % 4 == 0) {
                str += ".";
            }
        }
        return str;
    }

    public String binaryByte() {
        return binaryByte(getMyByte());
    }

    public static boolean isBit(byte myByte, int pos) {
        return (myByte & 1 << pos) != 0;
    }

    public boolean isBit(int pos) {
        return isBit(getMyByte(), pos);
    }

    /**
     * @return the myByte
     */
    public Byte getMyByte() {
        return myByte;
    }
}
