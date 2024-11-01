package com.example;

import java.security.*;
import javax.crypto.Cipher;
import java.util.Base64;

public class RSAEncryption {
    
    // Genera una coppia di chiavi RSA (pubblica e privata)
    public static KeyPair generateRSAKeyPair() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048); // Lunghezza della chiave RSA in bit
        return keyGen.generateKeyPair();
    }

    // Metodo per cifrare un messaggio con la chiave pubblica
    public static String encrypt(String plainText, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes); // Codifica in Base64 per leggibilità
    }

    // Metodo per decifrare un messaggio con la chiave privata
    public static String decrypt(String encryptedText, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedBytes); // Converti in stringa
    }

}
