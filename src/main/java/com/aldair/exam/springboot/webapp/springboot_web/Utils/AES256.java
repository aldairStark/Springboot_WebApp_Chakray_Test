package com.aldair.exam.springboot.webapp.springboot_web.Utils;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import com.fasterxml.jackson.databind.JsonSerializable.Base;

public class AES256 {
    private static final String SECRET = "12345678901234567890123456789012"; 

    public static String Encrypt(String value){

        try{
            SecretKeySpec key = new SecretKeySpec(SECRET.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] ecrypted = cipher.doFinal(value.getBytes());

            return Base64.getEncoder().encodeToString(ecrypted);
        }catch(Exception ex){
                throw new RuntimeException("Error al encriptar password");
        }

    }
}
