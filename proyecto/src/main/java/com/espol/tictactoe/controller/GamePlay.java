package com.espol.tictactoe.controller;

import java.io.IOException;
import java.util.Objects;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import com.espol.tictactoe.App;
import com.espol.tictactoe.model.Game;
import com.espol.tictactoe.model.Matrix;
import com.espol.tictactoe.model.Player;
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
    private Button recommend;

    @FXML
    private Label bestPlay;

    @FXML
    private GridPane board;

    @FXML
    public static GridPane gameMatrix;

    private Game game;

    private Matrix matrix;

    private Player playerTurn;

    public void initialize() {
        this.game = GamePlayContext.getInstance().getGameData();
        gameMode.setText(game.getGameMode().toString());
        playerOne.setText(game.getPlayerOne().getName());
        playerTwo.setText(game.getPlayerTwo().getName());

        // Not always root, because may be opening a saved game
        this.matrix = game.getTree().getRoot();
        this.paintMatrix(this.matrix);
        bestPlay.setText("");

        recommend.setOnMouseClicked(e -> {
            int[] best = Game.recomendacion(this.matrix, this.playerTurn.getSymbol());
            bestPlay.setText("Se recomienda jugar en la fila " + (best[0]+1)  + " columna " + (best[1]+1) + ".");
        });

        this.play();
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

    public void setSymbolOnHover(Symbol symbol) {
        String greyCross = "file:src/main/resources/com/espol/tictactoe/img/greycross.png";
        String greyCircle = "file:src/main/resources/com/espol/tictactoe/img/greycircle.png";

        String imgPath = symbol.equals(Symbol.X) ? greyCross : greyCircle;

        for (Node node: board.getChildren()) {
            VBox cell = (VBox) node;

            if (!cell.isDisabled()) {
                int rowIndex = GridPane.getRowIndex(node) == null ? 0 : GridPane.getRowIndex(node);
                int colIndex = GridPane.getColumnIndex(node) == null ? 0 : GridPane.getColumnIndex(node);

                cell.setOnMouseEntered(e -> {
                    setImage(rowIndex, colIndex, imgPath);
                });
                cell.setOnMouseExited(e -> {
                    clearImage(rowIndex, colIndex);
                });
            }
        }
    }

    private void setImage(int row, int col, String imgPath) {
        VBox cell = getCell(row, col);
        assert cell != null;
        ImageView imgView = (ImageView) cell.getChildren().get(0);

        Image img = new Image(imgPath);
        imgView.setImage(img);
    }

    private void disableCell(int row, int col) {
        VBox cell = getCell(row, col);
        assert cell != null;
        cell.setDisable(true);
    }

    public void clearImage(int row, int col) {
        Symbol[][] matrixPlay = this.matrix.getPlay();
        Symbol symbol = matrixPlay[row][col];
        boolean isEmpty = symbol.equals(Symbol.EMPTY);

        if (isEmpty) {
            VBox cell = getCell(row, col);
            assert cell != null;
            ImageView img = (ImageView) cell.getChildren().get(0);
            img.setImage(null);
        }
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

    public GridPane getBoard(){
        return board;
    }

    public void paintMatrix(Matrix matrix) {
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

    public void rePaint() {
        for (int i = 0; i < matrix.getPlay().length; i++) {
            for (int j = 0; j < matrix.getPlay()[i].length; j++) {
                if (matrix.getPlay()[i][j].equals(Symbol.X)) {
                    setX(i, j);
                    disableCell(i, j);
                } else if (matrix.getPlay()[i][j].equals(Symbol.O)) {
                    setO(i, j);
                    disableCell(i, j);
                } else {
                    clearImage(i, j);
                }
            }
        }
    }

    public Matrix getMatrix() {
        return matrix;
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }

    private void play() {
        Symbol startingSymbol = game.getStartingSymbol();
        Player one = game.getPlayerOne();
        Player two = game.getPlayerTwo();

        boolean startsOne = startingSymbol.equals(one.getSymbol());

        Player startingPlayer = startsOne ? one : two;
        Player secondPlayer = startsOne ? two : one;

        startingPlayer.play(secondPlayer, this);
    }

    public void checkWinners() {
        boolean xWon = Game.win(this.matrix, Symbol.X);
        boolean oWon = Game.win(this.matrix, Symbol.O);

        if (xWon || oWon) {
            Player winner = oWon ? game.getPlayerOne() : game.getPlayerTwo();

            try {
                FXMLLoader loader = new FXMLLoader(App.class.getResource("view/winner.fxml"));
                Parent root = loader.load();
                Winner winnerController = loader.getController();

                winnerController.initData(winner);

                Stage stage = new Stage();

                stage.initStyle(StageStyle.UNDECORATED);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Congratulations!");

                stage.setScene(new Scene(root));
                stage.show();
            } catch (
                    IOException e) {
                throw new RuntimeException(e);
            }
            this.returnHome();
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(App.class.getResource("view/end.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();

                stage.initStyle(StageStyle.UNDECORATED);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Game Over");

                stage.setScene(new Scene(root));
                stage.show();
            } catch (
                    IOException e) {
                throw new RuntimeException(e);
            }
            this.returnHome();
        }
    }

    public void setPlayerTurn(Player p) {
        this.playerTurn = p;
    }

    public void clearBestPlay(){
        bestPlay.setText("");
    }
}
