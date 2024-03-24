package com.lowleveldesign.bookmyshowdesign;

import com.lowleveldesign.bookmyshowdesign.enums.SeatCategory;
import lombok.Data;

@Data
public class Seat {
    private String id;
    private String row;
    private SeatCategory category;

    public Seat(String id, String row, SeatCategory category) {
        this.id = id;
        this.row = row;
        this.category = category;
    }
}
