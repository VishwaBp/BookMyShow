package com.vishwanath.book_my_show.models;

import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.Id;

@MappedSuperclass
public class BaseModel  {
    @Id
    private int  id;
}
