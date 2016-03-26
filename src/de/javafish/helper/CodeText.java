package de.javafish.helper;

import java.nio.*;
import java.nio.charset.*;
import java.security.*;
import java.util.*;

public final class CodeText {

    private CodeText() {
    }
    
    @Deprecated
    public static String getCode(String text) {
        return getCode(text.getBytes());
    }
    
    public static String getCode(char[] pw) {
        return getCode(char2byteBuffer(pw));
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
            md = MessageDigest.getInstance("SHA-512");
            
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
    
    private static byte[] char2byteBuffer(char[] chars) {
        ByteBuffer bb = Charset.forName("UTF-8").encode(CharBuffer.wrap(chars));
        byte[] ba = new byte[bb.limit()];
        bb.get(ba);
        return ba;
    }
    
    public static void test(String[] args) {
        String pw = "geheüm";
        
        System.out.println("\nString");
        System.out.println(pw);
        System.out.println(CodeText.getCode(pw));
        
        System.out.println("\nbyte[]");
        System.out.println(Arrays.toString(pw.getBytes()));
        System.out.println(CodeText.getCode(pw.getBytes()));
        
        System.out.println("\nbb");
        System.out.println(Arrays.toString(char2byteBuffer(pw.toCharArray())));
        System.out.println(CodeText.getCode(char2byteBuffer(pw.toCharArray())));
       
    }
    
    /*
    String pw = "geheim"    - addb0f5e7826c857d7376d1bd9bc33c0c544790a2eac96144a8af22b1298c940
    hashgenerator.de        - addb0f5e7826c857d7376d1bd9bc33c0c544790a2eac96144a8af22b1298c940
    
    pw.toCharArray          - c0452214c046c0fb6d44b095e2d4ae54f75862ef1074870daa0489126651a657
    */
}
