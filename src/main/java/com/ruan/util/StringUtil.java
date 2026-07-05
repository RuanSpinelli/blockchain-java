package com.ruan.util;

import java.security.MessageDigest;

public class StringUtil {


    public static String applySha256(String input) {
        try{
            // Aplica sha256 no texto
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            // Vai guardar o hash como hexadecimal
            StringBuffer hexString = new StringBuffer();
            for (int i = 0;i < hash.length; i ++ ){
                String hex = Integer.toHexString(0xff&hash[i]);
                if (hex.length() == 1) hexString.append('O');
                hexString.append(hex);
            }
            return hexString.toString();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
