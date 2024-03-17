package com.lowleveldesign.tictactoe.model;

public class Board {
    public int size;
    public PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int row, int col, PlayingPiece playingPiece) {
        if (isSafe(row) && isSafe(col) && board[row][col] != null) {
            return false;
        }
        board[row][col] = playingPiece;
        return true;
    }

    private boolean isSafe(int row) {
        return row >= 0 && row < size;
    }


    public void printBoard() {
        System.out.println("Game Board: ");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null)
                    System.out.printf("   ");
                else
                    System.out.printf(" %s ", board[i][j]);

                System.out.print(" | ");
            }
            System.out.println();
        }
    }

    public boolean ifEmptySpace() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null)
                    return true;
            }
        }
        return false;

    }
}
