package com.vishwanath.book_my_show.controllers;

import com.vishwanath.book_my_show.dtos.CreateBookingRequest;
import com.vishwanath.book_my_show.dtos.CreateBookingResponse;
import com.vishwanath.book_my_show.models.Booking;
import com.vishwanath.book_my_show.services.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/bms/v1")
@AllArgsConstructor
public class BookingController {

    private BookingService bookingService;

    @PostMapping(path = "/bookings")
    public CreateBookingResponse createBooking(@RequestBody CreateBookingRequest request) {
        // Add validations to ensure all the fields are present in the request.
        System.out.println(request.toString());
        Booking booking = bookingService.createBooking(
                request.getUserId(), request.getShowId(), request.getSeatIds());

        return new CreateBookingResponse("SUCCESS");
    }

}