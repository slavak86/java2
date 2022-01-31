package ru.gb.chat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextArea tipArea;
    @FXML
    private TextField tipText;

    public void onButtonClick(ActionEvent ActionEvent) {

        final String answer = tipText.getText();
        if (answer != null && !answer.isEmpty()) {
            tipArea.appendText(answer + "\n");
        }
        tipText.clear();
    }
}
