package com.lowleveldesign.snakeandladdergamedesign;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.ThreadLocalRandom;

@Data
@AllArgsConstructor
public class Dice {
    private static int min = 1;
    private static int max = 6;
    private int diceCount;

    public int rollDice() {
        int diceUsed = diceCount;
        int totalSum = 0;
        while (diceUsed-- > 0) {
            totalSum += ThreadLocalRandom.current().nextInt(min, max + 1);
        }
        return totalSum;
    }
}
