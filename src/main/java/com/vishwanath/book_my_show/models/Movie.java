package com.vishwanath.book_my_show.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Movie {
    private String description;
    private String name;
    private String language;
    private Date releaseDate;;
}
