package com.lowleveldesign.bookmyshowdesign;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Show {
    private String id;
    private Movie movie;
    private Screen screen;
    private long startTime;
    private List<String> bookedSeatIds;

    public Show() {
        this.bookedSeatIds = new ArrayList<>();
    }
}
