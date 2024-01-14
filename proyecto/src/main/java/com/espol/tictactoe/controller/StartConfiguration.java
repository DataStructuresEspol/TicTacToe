package com.espol.tictactoe.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import com.espol.tictactoe.App;
import com.espol.tictactoe.model.GameData;
import com.espol.tictactoe.model.GameMode;
import com.espol.tictactoe.model.HumanvsHuman;
import com.espol.tictactoe.model.PcvsHuman;
import com.espol.tictactoe.model.PcvsPc;
import com.espol.tictactoe.model.Player;
import com.espol.tictactoe.model.Symbol;

public class StartConfiguration {
    @FXML
    private ImageView returnButton;

    @FXML
    private HBox gameModes;

    @FXML
    private VBox chooseNames;

    @FXML
    private Label playerOneType;

    @FXML
    private Label playerTwoType;

    @FXML
    private TextField playerOneName;

    @FXML
    private TextField playerTwoName;

    @FXML
    private ComboBox<Symbol> orders;

    private GameData gameData;

    private GameMode[] gameModesList;

    public void initialize() {
        gameData = new GameData();
        this.setInitialActions();
        this.initializeGameModes();
        chooseNames.setVisible(false);
    }

    private void returnHome() {
        try {
            App.setRoot("home");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void initializeGameModes() {
        gameModesList = new GameMode[3];
        gameModesList[0] = new PcvsPc();
        gameModesList[1] = new PcvsHuman();
        gameModesList[2] = new HumanvsHuman();
    }
    private void setInitialActions() {
        returnButton.setOnMouseClicked((event) -> {
            returnHome();
        });
    }

    @FXML
    private void setGameMode(MouseEvent e) {
        gameModes.getChildren().forEach((child) -> {
            VBox box = (VBox) child;
            if (box.equals(e.getSource())) {
                box.setStyle("-fx-background-color: #233542; -fx-background-radius: 10px;");
                gameData.setGameMode(gameModesList[gameModes.getChildren().indexOf(box)]);
            } else {
                box.setStyle("");
            }
        });
        chooseNames.setVisible(true);
        setPlayerTypes();
        orders.getItems().addAll(Symbol.X, Symbol.O);
    }

    private void setPlayerTypes() {
        String[] playerType = gameData.getGameMode().toString().split(" vs ");
        playerOneType.setText(playerType[0]);
        playerTwoType.setText(playerType[1]);
    }

    private void setPlayerOne() {
        GameMode gameMode = gameData.getGameMode();
        Player player = gameMode.playerOne();
        player.setName(playerOneName.getText());
        player.setSymbol(Symbol.O);
        gameData.setPlayerOne(player);
    }
    private void setPlayerTwo() {
        GameMode gameMode = gameData.getGameMode();
        Player player = gameMode.playerTwo();
        player.setName(playerTwoName.getText());
        player.setSymbol(Symbol.X);
        gameData.setPlayerTwo(player);
    }

    @FXML
    private void play() {
        setPlayerOne();
        setPlayerTwo();
        gameData.setStartingSymbol(orders.getValue());

        try {
            App.setRoot("gameplay");
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }
}
