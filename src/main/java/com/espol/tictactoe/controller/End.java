package com.espol.tictactoe.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class End {
    @FXML
    private Button returnButton;
    @FXML
    void handleReturn() {
        Stage stage = (Stage) returnButton.getScene().getWindow();
        stage.close();
    }
}
