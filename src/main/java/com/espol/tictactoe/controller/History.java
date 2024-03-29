package com.espol.tictactoe.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

import com.espol.tictactoe.App;

public class History {
    @FXML
    private ImageView returnButton;

    public void initialize() {
        this.setInitialActions();
    }

    private void returnHome() {
        try {
            App.setRoot("home");
        } catch (
                IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void setInitialActions() {
        returnButton.setOnMouseClicked((event) -> {
            returnHome();
        });
    }
}
