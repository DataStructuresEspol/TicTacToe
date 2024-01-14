
package com.espol.tictactoe.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Objects;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
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
    private Button saveGame;

    @FXML
    private GridPane board;

    private GameData gameData;
    @FXML
    private GridPane gameMatrix;

    public void initialize() {
        this.gameData = GamePlayContext.getInstance().getGameData();
        gameMode.setText(gameData.getGameMode().toString());
        playerOne.setText(gameData.getPlayerOne().getName());
        playerTwo.setText(gameData.getPlayerTwo().getName());

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

    private void setX(int row, int col) {
        setImage(row, col, "file:src/main/resources/com/espol/tictactoe/img/cross.png");
    }

    private void setO(int row, int col) {
        setImage(row, col, "file:src/main/resources/com/espol/tictactoe/img/circle.png");
    }
    private void setXonHover(int row, int col) {
        setImage(row, col, "file:src/main/resources/com/espol/tictactoe/img/greycross.png");
    }

    private void setOonHover(int row, int col) {
        setImage(row, col, "file:src/main/resources/com/espol/tictactoe/img/greycircle.png");
    }

    private void setImage(int row, int col, String imgPath) {
        VBox cell = getCell(row, col);
        assert cell != null;
        ImageView imgView = (ImageView) cell.getChildren().get(0);

        Image img = new Image(imgPath);
        imgView.setImage(img);
    }

    private void clearImage(int row, int col) {
        VBox cell = getCell(row, col);
        assert cell != null;
        ImageView img = (ImageView) cell.getChildren().get(0);
        img.setImage(null);
    }

    private VBox getCell(Integer row, Integer col) {
        for (Node node : board.getChildren()) {
            Integer rowIndex = GridPane.getRowIndex(node) == null ? 0 : GridPane.getRowIndex(node);
            Integer colIndex = GridPane.getColumnIndex(node) == null ? 0 : GridPane.getColumnIndex(node);
            if (Objects.equals(rowIndex, row) && Objects.equals(colIndex, col)) {
                return (VBox) node;
            }
        }
        return null;
    }
}
