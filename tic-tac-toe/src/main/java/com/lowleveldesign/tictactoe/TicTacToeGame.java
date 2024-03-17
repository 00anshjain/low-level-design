package com.lowleveldesign.tictactoe;

import com.lowleveldesign.tictactoe.model.Board;
import com.lowleveldesign.tictactoe.model.Player;
import com.lowleveldesign.tictactoe.model.PlayingPiece;
import com.lowleveldesign.tictactoe.model.PlayingPieceO;
import com.lowleveldesign.tictactoe.model.PlayingPieceX;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class TicTacToeGame {
    Deque<Player> players;
    Board gameBoard;


    public void initializeGame() {
        players = new LinkedList<>();
        Player player1 = new Player("Player1", new PlayingPieceX());
        Player player2 = new Player("Player2", new PlayingPieceO());
        players.add(player1);
        players.add(player2);
        gameBoard = new Board(3);
    }

    public String startGame() {
        boolean noWinner = true;
        while (noWinner) {
            Player playerTurn = players.removeFirst();
            gameBoard.printBoard();
            if (!gameBoard.ifEmptySpace()) {
                noWinner = false;
                continue;
            }
            System.out.println("Player: " + playerTurn.getName() + " turn. Enter row, col: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);

            if (!gameBoard.addPiece(inputRow, inputColumn, playerTurn.getPiece())) {
                System.out.println("Incorrect Position, try again!");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);
            boolean winner = isWinner(inputRow, inputColumn, playerTurn.getPiece());
            if (winner) {
                return playerTurn.getName();
            }
        }
        return "tie";
    }

    private boolean isWinner(int inputRow, int inputColumn, PlayingPiece piece) {
        return checkColumn(inputColumn, piece) || checkRow(inputRow, piece) || checkDiagonal(piece);
    }

    private boolean checkColumn(int inputColumn, PlayingPiece piece) {
        for (int i = 0; i < gameBoard.size; i++) {
            if (!piece.equals(gameBoard.board[i][inputColumn])) {
                return false;
            }
        }
        return true;
    }

    private boolean checkRow(int inputRow, PlayingPiece piece) {
        for (int i = 0; i < gameBoard.size; i++) {
            if (!piece.equals(gameBoard.board[inputRow][i])) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal(PlayingPiece piece) {
        boolean diagonal1Match = true;
        for (int i = 0; i < gameBoard.size; i++) {
            if (!piece.equals(gameBoard.board[i][i])) {
                diagonal1Match = false;
                break;
            }
        }
        boolean diagonal2Match = true;
        for (int i = 0; i < gameBoard.size; i++) {
            if (!piece.equals(gameBoard.board[i][gameBoard.size - i - 1])) {
                diagonal2Match = false;
                break;
            }
        }
        return diagonal1Match || diagonal2Match;
    }

}
