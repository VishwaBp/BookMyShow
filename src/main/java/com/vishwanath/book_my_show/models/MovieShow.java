package com.vishwanath.book_my_show.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MovieShow {
    private Movie movie;
    private Date startTime;
    private  int durationInMinutes;
    private Hall hall;

}
