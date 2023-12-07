package com.vishwanath.book_my_show.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Booking {
    private Customer customer;

    private List<MovieShowSeat> showSeats;
    private MovieShow movieShow;
    private Date bookedAt;
    private double amount;
}
