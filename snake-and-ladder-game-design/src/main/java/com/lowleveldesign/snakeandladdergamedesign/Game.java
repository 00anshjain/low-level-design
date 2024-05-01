package com.lowleveldesign.snakeandladdergamedesign;

import lombok.Data;

import java.util.Deque;
import java.util.LinkedList;

@Data
public class Game {
    Deque<Player> players;
    Player winner;
    private Board board;
    private Dice dice;

    public Game() {
        initialiseGame();
    }

    public void initialiseGame() {
        board = new Board(10, 5, 5);
        dice = new Dice(1);
        winner = null;
        addPlayers(2);
    }

    private void addPlayers(int numPlayer) {
        players = new LinkedList<>();
        for (int i = 1; i <= numPlayer; i++)
            players.addLast(new Player(String.valueOf(i), 0));
    }

    public void startGame() {
        if (board == null || board.getCells().length == 0) {
            System.out.println("Invalid board setup.");
            return;
        }

        final int boardSize = board.getCells().length;
        final int winningPosition = boardSize * boardSize - 1;

        while (winner == null) {
            for (Player player : players) {
                int move = dice.rollDice();
                System.out.println("Turn: Player " + player.getId() + " move: " + move);
                int currentPosition = player.getCurrentPos();
                int newPosition = calculateNewPosition(currentPosition, move);
                player.setCurrentPos(newPosition);
                System.out.println("Player " + player.getId() + " new position: " + newPosition);
                if (newPosition == winningPosition) {
                    System.out.println("Winner is Player: " + player.getId());
                    winner = player;
                    break;
                }
            }
        }
    }

    private int calculateNewPosition(int currentPosition, int move) {
        int newPosition = currentPosition + move;
        int boardLength = board.getCells().length;
        if (newPosition >= boardLength * boardLength) {
            return currentPosition;
        }
        Cell cell = board.getCellAtPosition(newPosition);
        Jump jump = cell != null ? cell.getJump() : null;
        if (jump != null) {
            int jumpEnd = jump.getEnd();
            System.out.println(jump.getType() + " found at cell " + newPosition);
            return jumpEnd;
        }

        return newPosition;
    }
}
