package com.lowleveldesign.tictactoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicTacToeApplication {

    public static void main(String[] args) {
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        ticTacToeGame.initializeGame();
        System.out.println("Game Winner: " + ticTacToeGame.startGame());
        SpringApplication.run(TicTacToeApplication.class, args);
    }

}
