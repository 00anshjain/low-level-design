package com.lowleveldesign.bookmyshowdesign;

import com.lowleveldesign.bookmyshowdesign.enums.City;
import com.lowleveldesign.bookmyshowdesign.enums.SeatCategory;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Data
public class BookMyShow {
    private MovieController movieController;
    private TheatreController theatreController;

    public BookMyShow() {
        this.movieController = new MovieController();
        this.theatreController = new TheatreController();
    }

    public void createBooking(City city, String movieName, String theatreId, String showId) {

        //search movie by location
        List<Movie> movies = movieController.getMoviesInCity(city);
        Movie interestedMovie = null;
        for (Movie movie : movies) {
            if (movieName.equals(movie.getName())) {
                interestedMovie = movie;
                break;
            }
        }
        Map<String, List<Show>> theatreShowMap = theatreController.getAllShowsForMovie(city, interestedMovie);
        List<Show> showsForTheatre = theatreShowMap.getOrDefault(theatreId, Collections.emptyList());
        Show interestedShow = showsForTheatre.stream()
                .filter(movieShow -> showId.equals(movieShow.getId()))
                .findFirst().orElse(null);
        if (interestedShow == null) {
            System.out.println("No show found");
            return;
        }

        // select the seat
        String seatId = "30";
        List<String> bookedSeats = interestedShow.getBookedSeatIds();
        if (!bookedSeats.contains(seatId)) {
            bookedSeats.add(seatId);
            //startPayment
            Booking booking = new Booking();
            List<Seat> myBookedSeats = new ArrayList<>();
            for (Seat screenSeat : interestedShow.getScreen().getSeats()) {
                if (seatId.equals(screenSeat.getId())) {
                    myBookedSeats.add(screenSeat);
                }
            }
            booking.setBookedSeats(myBookedSeats);
            booking.setShow(interestedShow);
        } else {
            //throw exception
            System.out.println("seat already booked, try again");
            return;
        }

        System.out.println("BOOKING SUCCESSFUL");

    }

    public void initialize() {
        createMovies();
        createTheatres();
    }

    private void createTheatres() {
        Theatre theatre1 = new Theatre("T1001", "Nexus Mall - Inox", City.Bangalore);
        Theatre theatre2 = new Theatre("T1002", "Phoenix Mall - Inox", City.Bangalore);
        Theatre theatre3 = new Theatre("T2001", "Phoenix Mall - PVR", City.Delhi);
        Theatre theatre4 = new Theatre("T2002", "Phoenix Mall - PVR", City.Delhi);

        theatreController.addTheatresInCity(City.Bangalore, theatre1);
        theatreController.addTheatresInCity(City.Bangalore, theatre2);
        theatreController.addTheatresInCity(City.Delhi, theatre3);
        theatreController.addTheatresInCity(City.Delhi, theatre4);

        createScreensForTheatre(theatre1);
        createScreensForTheatre(theatre2);
        createScreensForTheatre(theatre3);
        createScreensForTheatre(theatre4);

        createShowsInTheatre(theatre1);
        createShowsInTheatre(theatre2);
        createShowsInTheatre(theatre3);
        createShowsInTheatre(theatre4);

    }

    private void createShowsInTheatre(Theatre theatre) {
        Movie m1 = movieController.getMovieByName("Avengers - End Game");
        Movie m2 = movieController.getMovieByName("Baahubali - The Beginning");

        Show m1MorningShow = createShow(m1, theatre.getScreens().get(0), 1000, "SH1001");
        Show m1EveningShow = createShow(m1, theatre.getScreens().get(0), 1700, "SH1002");
        Show m2MorningShow = createShow(m2, theatre.getScreens().get(1), 1000, "SH2001");
        Show m2EveningShow = createShow(m2, theatre.getScreens().get(1), 1700, "SH2002");
        theatre.setShows(Arrays.asList(m1MorningShow, m1EveningShow, m2MorningShow, m2EveningShow));
    }

    private Show createShow(Movie movie, Screen screen, int showStartTime, String showId) {
        Show show = new Show();
        show.setId(showId);
        show.setMovie(movie);
        show.setScreen(screen);
        show.setStartTime(showStartTime);
        return show;
    }

    private void createScreensForTheatre(Theatre theatre) {
        Screen s1 = new Screen("S1001", addSeats());
        Screen s2 = new Screen("S1002", addSeats());
        theatre.setScreens(Arrays.asList(s1, s2));
    }

    private List<Seat> addSeats() {
        List<Seat> seats = new ArrayList<>();
        for (int i = 1; i <= 40; i++) {
            seats.add(new Seat(String.valueOf(i), String.valueOf(i % 10), SeatCategory.Silver));
        }
        for (int i = 41; i <= 80; i++) {
            seats.add(new Seat(String.valueOf(i), String.valueOf(i % 10), SeatCategory.Gold));
        }
        for (int i = 81; i <= 100; i++) {
            seats.add(new Seat(String.valueOf(i), String.valueOf(i % 10), SeatCategory.Platinum));
        }
        return seats;
    }

    private void createMovies() {
        Movie movie1 = new Movie("M1001", "Avengers - End Game", 168);
        Movie movie2 = new Movie("M1002", "Baahubali - The Beginning", 187);

        movieController.addMovieInCity(City.Bangalore, movie1);
        movieController.addMovieInCity(City.Bangalore, movie2);
        movieController.addMovieInCity(City.Delhi, movie1);
        movieController.addMovieInCity(City.Delhi, movie2);

    }

}
