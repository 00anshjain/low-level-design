package com.lowleveldesign.snakeandladdergamedesign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SnakeAndLadderGameDesignApplication {

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
        SpringApplication.run(SnakeAndLadderGameDesignApplication.class, args);
    }

}
