package com.lowleveldesign.bookmyshowdesign;

import com.lowleveldesign.bookmyshowdesign.enums.City;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class MovieController {
    private Map<City, List<Movie>> cityVsMovie;
    private List<Movie> allMovies;

    public MovieController() {
        this.cityVsMovie = new HashMap<>();
        this.allMovies = new ArrayList<>();
    }

    public List<Movie> getMoviesInCity(City city) {
        return cityVsMovie.getOrDefault(city, new ArrayList<>());
    }

    public Movie getMovieByName(String name) {
        if (name == null) {
            throw new RuntimeException("Movie name cannot be null");
        }
        for (Movie movie : allMovies) {
            if (name.equals(movie.getName())) {
                return movie;
            }
        }
        System.out.printf("No movie found with name = %s%n", name);
        return null;
    }

    public void addMovieInCity(City city, Movie movie) {
        List<Movie> movies = cityVsMovie.getOrDefault(city, new ArrayList<>());
        if (!movies.contains(movie)) {
            allMovies.add(movie);
        }
        movies.add(movie);
        cityVsMovie.put(city, movies);
    }
}
