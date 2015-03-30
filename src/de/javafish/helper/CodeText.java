package de.javafish.helper;

import java.security.*;

public final class CodeText {

    private CodeText() {
    }
    
    @Deprecated
    public static String getCode(String text) {
        return getCode(text.toCharArray());
    }

    public static String getCode(char[] text) {
        
        String s = "";      // the resulting hex-String
        MessageDigest md;   // the MessageDigest
        byte[] b;           // the byte-Array for the given text
        byte[] d;           // the resulting byte-Array

        // convert the char-Array into a byte-Array, consider a char is two byte
        b = new byte[text.length << 1];
        for (int i = 0; i < text.length; i++) {
            int bpos = i << 1;
            b[bpos] = (byte) ((text[i] & 0xFF00) >> 8);
            b[bpos + 1] = (byte) (text[i] & 0x00FF);
        }

        // get the code
        try {
            // create a MessageDigest
            md = MessageDigest.getInstance("SHA");
            
            // send the text (as a byte-Array) to the Digest
            md.update(b);
            
            // get the hash-code as a byte-Array
            d = md.digest();

            // convert the resulting byte-Array to a String
            for (byte c : d) {
                s += String.format("%x", c);
            }
        } catch (NoSuchAlgorithmException ex) {
        }

        return s;
    }
    
    public static void main(String[] args) {
        String pw = "abcdefg";
//        System.out.println(CodeText.getCode(pw));
        System.out.println(CodeText.getCode(pw.toCharArray()));
    }
}

/*
 * char ch;  2 Byte - 16 Bit
 * byte by1, by2;  1 Byte -  8 Bit
 * by1 = (ch & 0xFF00) >> 8;
 * by2 = ch & 0x00FF;
 */