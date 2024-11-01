package com.example;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        
        try {

            // Genera coppia di chiavi
            KeyPair keyPair = RSAEncryption.generateRSAKeyPair();
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            // Messaggio da cifrare
            String plainText = "Ciao, questo è un messaggio crittografato con RSA!";
            System.out.println(plainText + "\n");
            
            // Cifratura
            String encryptedText = RSAEncryption.encrypt(plainText, publicKey);
            System.out.println("Messaggio Cifrato: " + encryptedText);

            // Decifratura
            String decryptedText = RSAEncryption.decrypt(encryptedText, privateKey);
            System.out.println("\nMessaggio Decifrato: " + decryptedText);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        //Senza libreria java.security
        RSA rsa = new RSA();
        
        // Messaggio di esempio da cifrare
        String plainText = "Hello RSA!";
        BigInteger message = new BigInteger(plainText.getBytes());

        // Cifrare
        BigInteger encryptedMessage = rsa.encrypt(message);
        System.out.println("Messaggio cifrato: " + encryptedMessage);

        // Decifrare
        BigInteger decryptedMessage = rsa.decrypt(encryptedMessage);
        String decryptedText = new String(decryptedMessage.toByteArray());
        System.out.println("Messaggio decifrato: " + decryptedText);

    }
}