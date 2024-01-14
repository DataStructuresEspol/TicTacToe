/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.tictactoe.state;

import com.espol.tictactoe.controller.GamePlay;
import com.espol.tictactoe.model.GameData;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


/**
 *
 * @author ariel
 */
public class GamePlayData {
    private GameData gameData;
    
    private void saveInformation(){
        StringBuilder text = new StringBuilder(); 

        GamePlay.gameMatrix.getChildren().forEach((child) -> {
            text.append(child.toString()).append(" ");
        });
        text.append(gameData.getPlayerOne().toString()).append(" ");
        text.append(gameData.getPlayerTwo().toString()).append(" ");
        text.append(gameData.getStartingSymbol().toString()).append(" ");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("game_data"))) {
            oos.writeObject(text.toString());
            System.out.println("Datos del juego guardados correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
