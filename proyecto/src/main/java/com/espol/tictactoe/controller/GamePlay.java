
package com.espol.tictactoe.controller;

import java.io.IOException;
import java.util.Objects;

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
import com.espol.tictactoe.model.Matrix;
import com.espol.tictactoe.model.Symbol;
import com.espol.tictactoe.state.GamePlayContext;

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

    @FXML
    public static GridPane gameMatrix;

    private GameData gameData;

    public void initialize() {
        this.gameData = GamePlayContext.getInstance().getGameData();
        gameMode.setText(gameData.getGameMode().toString());
        playerOne.setText(gameData.getPlayerOne().getName());
        playerTwo.setText(gameData.getPlayerTwo().getName());

        // Not always root, because may be opening a saved game
        paintMatrix(gameData.getTree().getRoot());

        gameData.getGameMode().play(this.gameData, this);
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

    public void setX(int row, int col) {
        setImage(row, col, "file:src/main/resources/com/espol/tictactoe/img/cross.png");
    }

    public void setO(int row, int col) {
        setImage(row, col, "file:src/main/resources/com/espol/tictactoe/img/circle.png");
    }
    public void setXonHover(int row, int col) {
        setImage(row, col, "file:src/main/resources/com/espol/tictactoe/img/greycross.png");
    }

    public void setOonHover(int row, int col) {
        setImage(row, col, "file:src/main/resources/com/espol/tictactoe/img/greycircle.png");
    }

    private void setImage(int row, int col, String imgPath) {
        VBox cell = getCell(row, col);
        assert cell != null;
        ImageView imgView = (ImageView) cell.getChildren().get(0);

        Image img = new Image(imgPath);
        imgView.setImage(img);
    }

    public void clearImage(int row, int col) {
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

    private void paintMatrix(Matrix matrix) {
        for (int i = 0; i < matrix.getPlay().length; i++) {
            for (int j = 0; j < matrix.getPlay()[i].length; j++) {
                if (matrix.getPlay()[i][j].equals(Symbol.X)) {
                    setX(i, j);
                } else if (matrix.getPlay()[i][j].equals(Symbol.O)) {
                    setO(i, j);
                } else {
                    clearImage(i, j);
                }
            }
        }
    }
}
