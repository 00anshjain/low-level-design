package com.lowleveldesign.bookmyshowdesign;

import com.lowleveldesign.bookmyshowdesign.enums.City;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Theatre {
    private String id;
    private String name;
    private City city;
    private List<Screen> screens;
    private List<Show> shows;

    public Theatre(String id, String name, City city) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.screens = new ArrayList<>();
        this.shows = new ArrayList<>();
    }
}
