package de.javafish.helper;

import java.security.*;

public final class CodeText {

    private CodeText() {
    }
    
    public static String getCode(String text) {
        return getCode(text.getBytes());
    }

    public static String getCode(byte[] ba) {
        
        // the resulting hex-String
        StringBuilder s = new StringBuilder(); 
        
        // the MessageDigest
        MessageDigest md;   
        
        // the resulting byte-Array
        byte[] d;           
        
        // get the code
        try {
            // create a MessageDigest
            md = MessageDigest.getInstance("SHA-256");
            System.out.println(md.getClass());
            // send the text (as a byte-Array) to the Digest
            md.update(ba);
            
            // get the hash-code as a byte-Array
            d = md.digest();

            // convert the resulting byte-Array to a String
            for (byte b : d) {
                s.append(String.format("%02x", b));
            }
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex);
        }

        return s.toString();
    }
    
    public static void main(String[] args) {
        String pw = "password3";
        System.out.println(CodeText.getCode(pw));
    }
}

/*
 * char ch;  2 Byte - 16 Bit
 * byte by1, by2;  1 Byte -  8 Bit
 * by1 = (ch & 0xFF00) >> 8;
 * by2 = ch & 0x00FF;
 */