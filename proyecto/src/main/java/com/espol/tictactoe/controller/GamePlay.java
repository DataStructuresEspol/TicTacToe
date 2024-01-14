
package com.espol.tictactoe.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import com.espol.tictactoe.model.GameData;

/**
 * FXML Controller class
 *
 * @author ariel
 */
public class GamePlay {

    @FXML
    private Label gameMode;

    @FXML
    private Label playerOne;

    @FXML
    private Label playerTwo;

    @FXML
    private VBox returnButton;

    @FXML
    private Button saveGame;

    private GameData gameData;

    public void initialize() {

    }

    public void setGameData(GameData gameData) {
        this.gameData = gameData;
    }
}
