package com.example.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TictactoeController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}