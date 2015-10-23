package de.javafish.helper;

import java.security.*;

public final class CodeText {

    private CodeText() {
    }
    
    public static String getCode(String text) {
        return getCode(text.getBytes());
    }
    
    public static String getCode(char[] pw) {
        return getCode(pw.toString());
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
        String pw = "geheim";
        System.out.println(pw.toCharArray());
        System.out.println(CodeText.getCode(pw));
    }
}
