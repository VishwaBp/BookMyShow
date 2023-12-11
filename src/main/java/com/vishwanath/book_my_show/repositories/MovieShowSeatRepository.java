package com.vishwanath.book_my_show.repositories;

import com.vishwanath.book_my_show.models.MovieShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieShowSeatRepository extends JpaRepository<MovieShowSeat, Long> {
}
