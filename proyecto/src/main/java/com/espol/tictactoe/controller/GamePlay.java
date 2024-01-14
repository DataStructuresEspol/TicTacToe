
package com.espol.tictactoe.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import com.espol.tictactoe.App;
import com.espol.tictactoe.model.GameData;
import com.espol.tictactoe.state.GamePlayContext;
import javafx.scene.layout.GridPane;

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
    @FXML
    public static GridPane gameMatrix;

    public void initialize() {
        this.gameData = GamePlayContext.getInstance().getGameData();
        System.out.println(gameData);
    }

    @FXML
    private void returnHome() {
        try {
            App.setRoot("home");
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }
    

}
