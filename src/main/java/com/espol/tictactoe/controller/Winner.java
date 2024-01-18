package com.espol.tictactoe.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import com.espol.tictactoe.model.Player;
import com.espol.tictactoe.model.Symbol;

public class Winner {

    @FXML
    private Label playerName;

    @FXML
    private ImageView icon;

    @FXML
    private Button returnButton;

    public void initData(Player winner) {
        playerName.setText(winner.getName());
        Symbol symbol = winner.getSymbol();
        setSymbol(symbol);
    }

    @FXML
    public void handleReturn() {
        Stage stage = (Stage) returnButton.getScene().getWindow();
        stage.close();
    }

    private void setSymbol(Symbol symbol) {
        if (symbol.equals(Symbol.X)) {
            icon.setImage(new Image("file:src/main/resources/com/espol/tictactoe/img/cross.png"));
        } else {
            icon.setImage(new Image("file:src/main/resources/com/espol/tictactoe/img/circle.png"));
        }
    }
}
