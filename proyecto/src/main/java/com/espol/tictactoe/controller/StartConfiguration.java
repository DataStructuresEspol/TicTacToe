package com.espol.tictactoe.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

import com.espol.tictactoe.App;

public class StartConfiguration {
    @FXML
    private ImageView returnButton;

    public void initialize() {
        this.returnHome();
    }

    private void returnHome() {
        try {
            App.setRoot("home");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
