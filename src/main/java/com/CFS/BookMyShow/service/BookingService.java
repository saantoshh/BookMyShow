package com.CFS.BookMyShow.service;

import com.CFS.BookMyShow.dto.BookingRequest;
import com.CFS.BookMyShow.entity.Booking;
import com.CFS.BookMyShow.entity.Seat;
import com.CFS.BookMyShow.entity.Show;
import com.CFS.BookMyShow.entity.User;
import com.CFS.BookMyShow.enums.BookingStatus;
import com.CFS.BookMyShow.repository.BookingRepository;
import com.CFS.BookMyShow.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final SeatRepository seatRepository;
    private final UserService userService;
    private final ShowService showService;

    @Transactional
    public Booking createBooking(BookingRequest request) {

        User user = userService.getUserById(request.getUserId());
        Show show = showService.getShowById(request.getShowId());

        // Check already booked seats
        List<Long> alreadyBookedSeats =
                bookingRepository.findBookedSeatIdsByShowId(show.getId());

        for (Long seatId : request.getSeatIds()) {
            if (alreadyBookedSeats.contains(seatId)) {
                throw new RuntimeException("Seat already booked: " + seatId);
            }
        }

        // Fetch seats
        List<Seat> seats = seatRepository.findAllById(request.getSeatIds());

        if (seats.size() != request.getSeatIds().size()) {
            throw new RuntimeException("Some seats are invalid");
        }

        // Calculate price
        double totalPrice = seats.size() * show.getTicket_price();

        // Create booking
        Booking booking = Booking.builder()
                .user(user)
                .show(show)
                .seats(seats)
                .total_price(totalPrice)
                .status(BookingStatus.CONFORMED)
                .build();

        // Save booking
        return bookingRepository.save(booking);
    }

    //GetBookingById
    public Booking getBookingById(Long id)
    {
        return bookingRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Booking not found with id: "+id));
    }

    public List<Booking> getBookingByUser(Long userId){
        return bookingRepository.findByUserId(userId);
    }

    @Transactional
    public Booking cancelbooking(Long bookingid)
    {
        Booking booking=getBookingById(bookingid);
        booking.setStatus(BookingStatus.CANCELLED);
        return bookingRepository.save(booking);
    }

    public List<Seat> getAvailableSeats(Long showId)
    {
        Show show=showService.getShowById(showId);
        List<Seat> allSeats=seatRepository.findByScreenId((long) show.getScreen().getId());
        List<Long> bookingSeatIds=bookingRepository.findBookedSeatIdsByShowId(showId);
        return allSeats.stream()
                .filter(seat -> !bookingSeatIds.contains(seat.getId()))
                .toList();
    }


}
