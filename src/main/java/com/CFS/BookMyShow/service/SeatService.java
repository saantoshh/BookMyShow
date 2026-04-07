package com.CFS.BookMyShow.service;

import com.CFS.BookMyShow.dto.ScreenRequest;
import com.CFS.BookMyShow.dto.SeatRequest;
import com.CFS.BookMyShow.entity.Screen;
import com.CFS.BookMyShow.entity.Seat;
import com.CFS.BookMyShow.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatService {
    private final SeatRepository seatRepository;
    private final ScreenService screenService;

    public Seat addSeat(SeatRequest seatRequest) {

        // Fetch Screen from DB
        Screen screen = screenService.getScreenById(seatRequest.getScreenId());

        // Create Seat
        Seat seat = Seat.builder()
                .seat_number(seatRequest.getSeatNumber())
                .rows(seatRequest.getRow())
                .columns(Integer.parseInt(seatRequest.getColumn()))  // String → Integer
                .seat_type(seatRequest.getSeatType())
                .screen(screen)
                .build();

        // Save Seat
        return seatRepository.save(seat);
    }
    public List<Seat> geatAllSeats() {
        return seatRepository.findAll();
    }
    public List<Seat> getSeatsByScreen(Long screenId)
    {
        return seatRepository.findByScreenId(screenId);
    }

    public Seat getSeatById(Long id)
    {
        return seatRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Seat not found with id: "+id));

    }
    
}
