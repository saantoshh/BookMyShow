package com.CFS.BookMyShow.controller;

import com.CFS.BookMyShow.dto.SeatRequest;
import com.CFS.BookMyShow.entity.Seat;
import com.CFS.BookMyShow.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
@RequiredArgsConstructor
public class SeatController {
    private final SeatService seatService;

    @PostMapping
    public ResponseEntity<Seat> addSeat(@RequestBody SeatRequest request) {
        return ResponseEntity.ok(seatService.addSeat(request));
    }
    @GetMapping
    public ResponseEntity<List<Seat>> getAllSeats(){
        return ResponseEntity.ok(seatService.geatAllSeats());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Seat> getSeatsById(@PathVariable Long id){
        return ResponseEntity.ok(seatService.getSeatById(id));
    }

    @GetMapping("/screen/{screenId}")
    public ResponseEntity<List<Seat>> getSeatByScreen(@PathVariable Long screenId)
    {
        return ResponseEntity.ok(seatService.getSeatsByScreen(screenId));
    }

}
