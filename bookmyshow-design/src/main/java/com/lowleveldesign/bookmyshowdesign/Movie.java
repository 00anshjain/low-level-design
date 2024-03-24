package com.lowleveldesign.bookmyshowdesign;

import lombok.Data;

@Data
public class Movie {
    private String id;
    private String name;
    private int duration;

    public Movie(String id, String name, int duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }
}
