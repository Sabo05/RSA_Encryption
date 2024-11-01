package com.example;

import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA {
    private BigInteger n; // Modulo n = p * q
    private BigInteger e; // Esponente pubblico
    private BigInteger d; // Esponente privato
    private int bitLength = 1024; // Lunghezza dei bit per p e q

    // Costruttore per generare le chiavi
    public RSA() {
        SecureRandom random = new SecureRandom();
        
        // Genera due numeri primi grandi, p e q
        BigInteger p = BigInteger.probablePrime(bitLength, random);
        BigInteger q = BigInteger.probablePrime(bitLength, random);
        
        // Calcola n = p * q
        n = p.multiply(q);
        
        // Calcola phi(n) = (p-1) * (q-1)
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        
        // Scegli e coprimo con phi(n), di solito 65537
        e = BigInteger.valueOf(65537);
        
        // Calcola d come l'inverso di e modulo phi(n)
        d = e.modInverse(phi);
    }

    // Metodo per cifrare il messaggio
    public BigInteger encrypt(BigInteger message) {
        // Cifra il messaggio: C = M^e mod n
        return message.modPow(e, n);
    }

    // Metodo per decifrare il messaggio
    public BigInteger decrypt(BigInteger encryptedMessage) {
        // Decifra il messaggio: M = C^d mod n
        return encryptedMessage.modPow(d, n);
    }

    // Ottieni la chiave pubblica (n, e)
    public BigInteger getPublicKeyN() {
        return n;
    }

    public BigInteger getPublicKeyE() {
        return e;
    }
}
