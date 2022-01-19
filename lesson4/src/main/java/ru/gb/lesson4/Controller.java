package ru.gb.lesson4;

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

//    public void onClearSelect(ActionEvent actionEvent) {
//        tipArea.clear();
//    }
//
//    public void onExitAction(ActionEvent actionEvent) {
//        System.exit(0);
//    }

    public void onButtonClick(ActionEvent actionEvent) {
        final String answer = tipText.getText();
        if (answer != null && !answer.isEmpty()) {
          tipArea.appendText(answer + "\n");
        }
        tipText.clear();
    }
}