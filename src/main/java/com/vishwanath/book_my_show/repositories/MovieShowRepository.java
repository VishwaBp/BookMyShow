package com.vishwanath.book_my_show.repositories;

import com.vishwanath.book_my_show.models.MovieShow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieShowRepository extends JpaRepository<MovieShow, Long> {

    @Override
    Optional<MovieShow> findById(Long aLong);

}
