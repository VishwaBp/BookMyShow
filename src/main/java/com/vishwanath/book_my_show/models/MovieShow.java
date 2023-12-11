package com.vishwanath.book_my_show.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class MovieShow extends BaseModel{
    @ManyToOne
    private Movie movie;
    private Date startTime;
    private  int durationInMinutes;
    @ManyToOne
    private Hall hall;

}
