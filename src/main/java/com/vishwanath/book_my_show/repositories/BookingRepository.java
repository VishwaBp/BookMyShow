package com.vishwanath.book_my_show.repositories;

import com.vishwanath.book_my_show.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Override
    Optional<Booking> findById(Long id);

    @Override
    Booking save(Booking booking);

}
