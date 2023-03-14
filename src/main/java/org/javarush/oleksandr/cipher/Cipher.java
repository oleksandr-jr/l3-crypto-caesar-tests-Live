package org.javarush.oleksandr.cipher;

public interface Cipher {
    String encrypt(String text, int shiftKey);
    String decrypt(String text, int shiftKey);
}
