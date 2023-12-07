package com.vishwanath.book_my_show.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieShowSeat {
    private MovieShow movieShow;
    private Seat seat;
    private BookingSeatStatus bookingStatus;

}
