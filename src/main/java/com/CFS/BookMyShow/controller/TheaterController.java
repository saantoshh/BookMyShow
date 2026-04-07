package com.CFS.BookMyShow.controller;

import com.CFS.BookMyShow.dto.TheaterRequest;
import com.CFS.BookMyShow.entity.City;
import com.CFS.BookMyShow.entity.Theater;
import com.CFS.BookMyShow.repository.TheaterRepository;
import com.CFS.BookMyShow.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theaters")
@RequiredArgsConstructor
public class TheaterController {
   private final TheaterService  theaterService;

    @PostMapping
    public ResponseEntity<Theater> addTheater(@RequestBody TheaterRequest request) {
        return ResponseEntity.ok(theaterService.addTheater(request));
    }

    @GetMapping
    public ResponseEntity<List<Theater>> getAllTheaters(){
        return ResponseEntity.ok(theaterService.getAllTheaters());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Theater> getTheaterById(@PathVariable Long id) {
        return ResponseEntity.ok(theaterService.getTheaterById(id));
    }
    @GetMapping("/city/{cityId}")
    public ResponseEntity<List<Theater>> getTheaterByCity(@PathVariable Long cityId) {
        return ResponseEntity.ok(theaterService.getTheatersByCityId(cityId));
    }
}
