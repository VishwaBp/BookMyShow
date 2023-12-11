package com.vishwanath.book_my_show.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {
    private int rowNum;
    private int colNum;

    private SeatType seatType;
}
