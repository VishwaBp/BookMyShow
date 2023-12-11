package com.vishwanath.book_my_show.services;


import com.vishwanath.book_my_show.models.*;
import com.vishwanath.book_my_show.repositories.BookingRepository;
import com.vishwanath.book_my_show.repositories.CustomerRepository;
import com.vishwanath.book_my_show.repositories.MovieShowRepository;
import com.vishwanath.book_my_show.repositories.MovieShowSeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.springframework.transaction.annotation.Isolation.*;

@Service
@AllArgsConstructor
public class BookingService {

    /*
    1. Get the user with UserId.
    2. Get the movie show with movieShowId.
    3. Get the seat objects from the DB by using seatIds.
    4. Check if seats are available? -> Booking seat status
    5. Mark the seats as reserved. seat.setBookingStatus(Reserved)?
    6. ShowSeatRepository.save()
    7. Create a booking object
    8. Save that to DB
    9. Return the booking.
     */

    private CustomerRepository customerRepository;
    private MovieShowRepository movieShowRepository;
    private MovieShowSeatRepository movieShowSeatRepository;
    private BookingRepository bookingRepository;

    @Transactional(isolation = SERIALIZABLE)
    public Booking createBooking(Long customerId, Long movieShowId, List<Long> seatIds) {

        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isEmpty()) {
            throw new IllegalArgumentException("Customer not found.");
        }

        MovieShow movieShow =
                movieShowRepository
                        .findById(movieShowId)
                        .orElseThrow(() -> new IllegalArgumentException(
                                "Movie show not found."));

        List<MovieShowSeat> movieShowSeats =
                movieShowSeatRepository.findAllById(seatIds);

        if (movieShowSeats.size() != seatIds.size()) {
            throw new IllegalArgumentException("All seat IDs not found.");
        }

        for (MovieShowSeat movieShowSeat: movieShowSeats) {
            if (movieShowSeat.getStatus() != BookingSeatStatus.AVAILABLE) {
                throw new IllegalArgumentException("Something went wrong.");
            }
        }

        for (MovieShowSeat movieShowSeat: movieShowSeats) {
            movieShowSeat.setStatus(BookingSeatStatus.RESERVED);
            movieShowSeatRepository.save(movieShowSeat);
        }

        Booking booking = new Booking();
        booking.setAmount(0);
        booking.setShowSeats(movieShowSeats);
        booking.setCustomer(customerOptional.get());
        booking.setMovieShow(movieShow);

        bookingRepository.save(booking);

        return booking;

    }
}
