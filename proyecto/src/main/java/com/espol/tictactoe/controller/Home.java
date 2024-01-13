package com.espol.tictactoe.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import com.espol.tictactoe.App;

public class Home {
    @FXML
    private Button exit;

    @FXML
    private Button history;

    @FXML
    private Button play;

    public void initialize() {
        this.setInitialActions();
    }

    private void exit() {
        System.exit(0);
    }

    private void history() throws IOException {
        App.setRoot("history");
    }

    private void play() throws IOException {
        App.setRoot("startConfiguration");
    }

    private void setInitialActions() {
        exit.setOnAction(e -> exit());
        history.setOnAction(e -> {
            try {
                history();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        play.setOnAction(e -> {
            try {
                play();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }
}
