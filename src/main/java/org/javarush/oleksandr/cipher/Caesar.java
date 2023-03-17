package org.javarush.oleksandr.cipher;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javarush.oleksandr.Main;

import java.util.ArrayList;

public class Caesar implements Cipher{

    private static final Logger log = LogManager.getLogger(Caesar.class);
    private final ArrayList<Character> alphabet;

    public Caesar(ArrayList<Character> alphabet){
        this.alphabet = alphabet;
    }

    @Override
    public String encrypt(String text, int shiftKey) {
        log.info("encrypt");
        StringBuilder resultText = new StringBuilder();

        for (Character c : text.toCharArray()) {
            if(alphabet.contains(Character.toLowerCase(c))){
                resultText.append(shiftChar(c, shiftKey));
            }else {
                resultText.append(c);
            }
        }
        return resultText.toString();
    }

    @Override
    public String decrypt(String text, int shiftKey) {
        log.info("decrypt");
        int key = (alphabet.size() - shiftKey) % (alphabet.size());
        return encrypt(text, key);
    }

    private Character shiftChar(Character character, int key){
        char lowerChar = (Character.toLowerCase(character));

        int index = (alphabet.indexOf(lowerChar) + key) % (alphabet.size());

        if (Character.isUpperCase(character)){
            return Character.toUpperCase(alphabet.get(index));
        } else {
            return alphabet.get(index);
        }
    }

}
