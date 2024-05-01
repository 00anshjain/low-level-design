package com.lowleveldesign.snakeandladdergamedesign;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Jump {
    //It can be Snake or Ladder
    private int start;
    private int end;

    public String getType() {
        if (start < end) {
            return "Ladder";
        } else {
            return "Snake";
        }
    }
}
