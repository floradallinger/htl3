package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.example.demo.model.Encrypter;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HelloController {
    Encrypter encrypter;

    @FXML
    private TextField txtAlphabet, txtKey;

    @FXML
    private TextArea txtPlainText, txtEncryptedText;

    public void initialize() {
        encrypter = new Encrypter();

        txtPlainText.selectedTextProperty().addListener(
                (observable, oldValue, newValue) -> {
                    int start = txtPlainText.getSelection().getStart();
                    int end = txtPlainText.getSelection().getEnd();

                    txtEncryptedText.selectRange(start, end);
                }
        );

        txtEncryptedText.selectedTextProperty().addListener(
                (observable, oldValue, newValue) -> {
                    int start = txtEncryptedText.getSelection().getStart();
                    int end = txtEncryptedText.getSelection().getEnd();

                    txtPlainText.selectRange(start, end);
                }
        );

        txtAlphabet.textProperty().bindBidirectional(encrypter.alphabetProperty());
        txtKey.textProperty().bindBidirectional(encrypter.keyProperty());
        txtPlainText.textProperty().bindBidirectional(encrypter.plainTextProperty());
        txtEncryptedText.textProperty().bindBidirectional(encrypter.encryptedTextProperty());
    }

    public void onStandardButtonClicked(ActionEvent actionEvent) {
        encrypter.setDefaultAlphabet();
    }

    public void onRecalcButtonClicked(ActionEvent actionEvent) {
        encrypter.generateRandomKey();
    }

}