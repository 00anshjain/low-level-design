package com.lowleveldesign.bookmyshowdesign;

import com.lowleveldesign.bookmyshowdesign.enums.City;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookmyshowDesignApplication {

    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initialize();
        bookMyShow.createBooking(City.Bangalore, "Avengers - End Game", "T1001", "SH1001");
        SpringApplication.run(BookmyshowDesignApplication.class, args);
    }

}
