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
import com.espol.tictactoe.model.Game;
import com.espol.tictactoe.logic.GameMode;
import com.espol.tictactoe.logic.HumanvsHuman;
import com.espol.tictactoe.logic.PcvsHuman;
import com.espol.tictactoe.logic.PcvsPc;
import com.espol.tictactoe.model.Player;
import com.espol.tictactoe.model.Symbol;
import com.espol.tictactoe.state.GamePlayContext;

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

    private Game game;

    private GameMode[] gameModesList;

    public void initialize() {
        game = new Game();
        this.setInitialActions();
        this.initializeGameModes();
        chooseNames.setVisible(false);
        orders.getItems().addAll(Symbol.X, Symbol.O);
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
                game.setGameMode(gameModesList[gameModes.getChildren().indexOf(box)]);
            } else {
                box.setStyle("");
            }
        });
        chooseNames.setVisible(true);
        setPlayerTypes();
    }

    private void setPlayerTypes() {
        String[] playerType = game.getGameMode().toString().split(" vs ");
        playerOneType.setText(playerType[0]);
        playerTwoType.setText(playerType[1]);
    }

    private void setPlayerOne() {
        GameMode gameMode = game.getGameMode();
        Player player = gameMode.playerOne();
        player.setName(playerOneName.getText());
        player.setSymbol(Symbol.O);
        game.setPlayerOne(player);
    }
    private void setPlayerTwo() {
        GameMode gameMode = game.getGameMode();
        Player player = gameMode.playerTwo();
        player.setName(playerTwoName.getText());
        player.setSymbol(Symbol.X);
        game.setPlayerTwo(player);
    }

    @FXML
    private void play() {
        setPlayerOne();
        setPlayerTwo();
        game.setStartingSymbol(orders.getValue());

        GamePlayContext.getInstance().getGameData().setGameData(game);

        try {
            App.setRoot("gameplay");
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }
}
