package com.lowleveldesign.bookmyshowdesign;

import lombok.Data;

import java.util.List;

@Data
public class Booking {
    private Show show;
    private List<Seat> bookedSeats;
    private Payment payment;
}
