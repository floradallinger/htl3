package org.example.demo.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Locale;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Encrypter {

    private final String DEFAULT_ALPHABET = "abcdefghijklmnopqrstuvwxyzäöüß";
    private StringProperty alphabet = new SimpleStringProperty("");
    private StringProperty key = new SimpleStringProperty("");
    private StringProperty plainText = new SimpleStringProperty("");
    private StringProperty encryptedText = new SimpleStringProperty("");

    public Encrypter() {
        alphabet.addListener((observeable, oldValue, newValue) -> generateRandomKey());
        key.addListener((observable, oldValue, newValue) -> encrypt());
        plainText.addListener((observable, oldValue, newValue) -> encrypt());

        setDefaultAlphabet();
        setPlainText("Please enter your text");
    }

    // Getter and Setter

    public String getAlphabet() {
        return alphabet.get();
    }

    public StringProperty alphabetProperty() {
        return alphabet;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet.set(alphabet);
    }

    public String getEncryptedText() {
        return encryptedText.get();
    }

    public StringProperty encryptedTextProperty() {
        return encryptedText;
    }

    public void setEncryptedText(String encryptedText) {
        this.encryptedText.set(encryptedText);
    }

    public String getKey() {
        return key.get();
    }

    public StringProperty keyProperty() {
        return key;
    }

    public void setKey(String key) {
        this.key.set(key);
    }

    public String getPlainText() {
        return plainText.get();
    }

    public StringProperty plainTextProperty() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText.set(plainText);
    }

    // Methoden
    public void setDefaultAlphabet() {
        setAlphabet(DEFAULT_ALPHABET);
    }

    public void generateRandomKey() {
        String alphabet = getAlphabet();

        Random random = new Random();
        String key = Stream.generate(() -> alphabet.charAt(random.nextInt(alphabet.length())))
                .distinct()
                .limit(alphabet.length())
                .map(String::valueOf)
                .collect(Collectors.joining());

        setKey(key);
    }

    private void encrypt() {
        // TODO
        String alphabet = getAlphabet();
        String key = getKey();
        String plainText = getPlainText().toLowerCase();
        StringBuilder encryptText = new StringBuilder();



        for (int i = 0; i < plainText.length(); i++) {
            char oldChar = plainText.charAt(i);
            int pos = alphabet.indexOf(oldChar);

            if(pos < 0){
                encryptText.append(oldChar);
            } else {
                encryptText.append(key.charAt(pos));
            }
        }
        setEncryptedText(encryptText.toString());
    }
}
