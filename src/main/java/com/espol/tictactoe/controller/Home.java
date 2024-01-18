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

    private void history()  {
        try {
            App.setRoot("history");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void play() {
        try {
            App.setRoot("startConfiguration");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setInitialActions() {
        exit.setOnAction(e -> exit());
        history.setOnAction(e -> history());
        play.setOnAction(e -> play());

    }
}
