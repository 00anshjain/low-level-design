package com.lowleveldesign.snakeandladdergamedesign;

import lombok.Data;

@Data
public class Player {
    private String id;
    private int currentPos;

    public Player(String id, int initialPos) {
        this.id = id;
        this.currentPos = initialPos;
    }
}
