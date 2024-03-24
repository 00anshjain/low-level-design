package com.lowleveldesign.bookmyshowdesign;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Screen {
    private String id;
    private List<Seat> seats;

    public Screen(String id) {
        this.id = id;
        this.seats = new ArrayList<>();
    }

    public Screen(String id, List<Seat> seats) {
        this.id = id;
        this.seats = seats;
    }

}
