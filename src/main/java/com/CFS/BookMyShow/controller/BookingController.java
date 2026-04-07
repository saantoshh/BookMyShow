package com.CFS.BookMyShow.controller;

import com.CFS.BookMyShow.dto.BookingRequest;
import com.CFS.BookMyShow.entity.Booking;
import com.CFS.BookMyShow.entity.Seat;
import com.CFS.BookMyShow.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

  @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody BookingRequest request){
        return  ResponseEntity.ok(bookingService.createBooking(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable long id){
      return  ResponseEntity.ok(bookingService.getBookingById(id));
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Booking>> getBookingByUserId(@PathVariable Long userId)
    {
        return ResponseEntity.ok(bookingService.getBookingByUser(userId));
    }
    @PutMapping("/{id}/cancel")
    public ResponseEntity<Booking> cancelBooking(@PathVariable Long id)
    {
        return ResponseEntity.ok(bookingService.cancelbooking(id));
    }

    @GetMapping("/show/{showId}/available-seats")
    public ResponseEntity<List<Seat>> getAvailableSeats(@PathVariable Long showId)
    {
        return ResponseEntity.ok(bookingService.getAvailableSeats(showId));
    }
}
