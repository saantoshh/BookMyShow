package com.CFS.BookMyShow.controller;

import com.CFS.BookMyShow.dto.ShowRequest;
import com.CFS.BookMyShow.dto.TheaterRequest;
import com.CFS.BookMyShow.entity.Show;
import com.CFS.BookMyShow.entity.Theater;
import com.CFS.BookMyShow.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/shows")
@RequiredArgsConstructor
public class ShowController {
    private final ShowService showService;

    @PostMapping("/add")
    public ResponseEntity<Show> addShow(@RequestBody ShowRequest request) {
        return ResponseEntity.ok(showService.addShow(request));
    }

    @GetMapping
    public ResponseEntity<List<Show>> getAllShows()
    {
        return ResponseEntity.ok(showService.getAllShows());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Show> getShowById(@PathVariable Long id)
    {
        return ResponseEntity.ok(showService.getShowById(id));
    }

    @GetMapping("/screen/{screenId}")
    public ResponseEntity<List<Show>> getShowByScreen(@PathVariable Long screenId){
        return ResponseEntity.ok(showService.getShowByScreen(screenId));
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<Show>> getShowByMovie(@PathVariable Long movieId)
    {
        return ResponseEntity.ok(showService.getShowByMovie(movieId));
    }


    @GetMapping("/movie/{movieId}/date")
    public ResponseEntity<List<Show>> getShowByMovieAndDate
            (@PathVariable Long movieId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date)
    {
        return ResponseEntity.ok(showService.getShowByMovieAndDate(movieId,date));
    }

}
