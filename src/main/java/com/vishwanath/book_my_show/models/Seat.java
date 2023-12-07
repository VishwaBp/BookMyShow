package com.vishwanath.book_my_show.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat {
    private int rowNum;
    private int colNum;
    private SeatType seatType;
}
