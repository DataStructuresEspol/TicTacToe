
package com.espol.tictactoe.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import com.espol.tictactoe.App;
import com.espol.tictactoe.model.GameData;
import com.espol.tictactoe.state.GamePlayContext;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
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
    private GridPane gameMatrix;

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
    
    private void savePlay(){
        saveGame.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                StringBuilder text = new StringBuilder(); 

                gameMatrix.getChildren().forEach((child) -> {
                    text.append(child.toString()).append(" ");
                });

                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("game_data.ser"))) {
                    oos.writeObject(text.toString());
                    System.out.println("Datos del juego guardados correctamente.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
