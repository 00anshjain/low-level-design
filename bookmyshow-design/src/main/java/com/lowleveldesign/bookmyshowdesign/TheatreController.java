package com.lowleveldesign.bookmyshowdesign;

import com.lowleveldesign.bookmyshowdesign.enums.City;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class TheatreController {
    private Map<City, List<Theatre>> cityVsTheatre;
    private List<Theatre> allTheatres;

    public TheatreController() {
        this.cityVsTheatre = new HashMap<>();
        this.allTheatres = new ArrayList<>();
    }

    public List<Theatre> getTheatresInCity(City city) {
        return cityVsTheatre.getOrDefault(city, new ArrayList<>());
    }

    public Map<String, List<Show>> getAllShowsForMovie(City city, Movie movie) {
        List<Theatre> theatres = getTheatresInCity(city);
        Map<String, List<Show>> theatreShowMap = new HashMap<>();
        for (Theatre theatre : theatres) {
            List<Show> shows = getShowsInTheatreForMovie(theatre, movie);
            if (!shows.isEmpty()) {
                theatreShowMap.put(theatre.getId(), shows);
            }
        }
        return theatreShowMap;
    }

    public List<Show> getShowsInTheatreForMovie(Theatre theatre, Movie movie) {
        List<Show> shows = new ArrayList<>();
        for (Show show : theatre.getShows()) {
            if (movie.equals(show.getMovie())) {
                shows.add(show);
            }
        }
        return shows;
    }


    public void addTheatresInCity(City city, Theatre theatre) {
        List<Theatre> theatres = cityVsTheatre.getOrDefault(city, new ArrayList<>());
        if (!theatres.contains(theatre)) {
            allTheatres.add(theatre);
        }
        theatres.add(theatre);
        cityVsTheatre.put(city, theatres);
    }

}
