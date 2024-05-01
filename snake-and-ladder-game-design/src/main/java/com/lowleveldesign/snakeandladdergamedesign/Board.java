package com.lowleveldesign.snakeandladdergamedesign;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@Data
@NoArgsConstructor
public class Board {
    private Cell[][] cells;

    public Board(int boardSize, int snakeCount, int ladderCount) {
        initializeCells(boardSize);
        addJumps(snakeCount, true);
        addJumps(ladderCount, false);
    }

    void initializeCells(int boardSize) {
        cells = new Cell[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    void addJumps(int jumpCount, boolean isSnake) {
        int boardSize = cells.length;
        int currCount = 0;
        while (currCount < jumpCount) {
            int start = ThreadLocalRandom.current().nextInt(1, (boardSize * boardSize) - 1);
            int end = ThreadLocalRandom.current().nextInt(1, (boardSize * boardSize) - 1);
            int row = start / 10;
            int col = start % 10;
            if ((isSnake && end >= start) || (!isSnake && end <= start) || cells[row][col].getJump() != null) {
                continue;
            }
            cells[row][col].setJump(new Jump(start, end));
            currCount++;
        }
    }

    public Cell getCellAtPosition(int position) {
        if (position < 0 || position >= (cells.length * cells.length)) {
            throw new RuntimeException("Invalid Cell Position " + position);
        }
        return cells[position / 10][position % 10];
    }


}
