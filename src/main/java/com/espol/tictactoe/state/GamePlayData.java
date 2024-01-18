/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.tictactoe.state;

import com.espol.tictactoe.controller.GamePlay;
import com.espol.tictactoe.model.Game;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author ariel
 */
public class GamePlayData {
    private Game game;
    
    private void saveInformation(){
        StringBuilder text = new StringBuilder(); 

        GamePlay.gameMatrix.getChildren().forEach((child) -> {
            text.append(child.toString()).append(" ");
        });
        text.append(game.getPlayerOne().toString()).append(" ");
        text.append(game.getPlayerTwo().toString()).append(" ");
        text.append(game.getStartingSymbol().toString()).append(" ");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("game_data"))) {
            oos.writeObject(text.toString());
            System.out.println("Datos del juego guardados correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
