package com.CFS.BookMyShow.controller;

import com.CFS.BookMyShow.entity.Movie;
import com.CFS.BookMyShow.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.addMovie(movie));
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies()
    {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id)
    {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }


    @GetMapping("/search")
    public ResponseEntity<List<Movie>> searchMovies(@RequestParam String title)
    {
        return ResponseEntity.ok(movieService.searchByTitle(title));
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Movie>> getByGenre(@PathVariable String genre)
    {
        return ResponseEntity.ok(movieService.getByGenre(genre));
    }

    @GetMapping("/language/{language}")
    public ResponseEntity<List<Movie>> getByLanguage(@PathVariable String language)
    {
        return ResponseEntity.ok(movieService.getByLanguage(language));
    }
    @GetMapping("/search/rating")
    public ResponseEntity<List<Movie>> searchByRating(@RequestParam Double rating) {
        return ResponseEntity.ok(movieService.searchByRatingGreaterThan(rating));
    }
    @GetMapping("/rating")
    public ResponseEntity<List<Movie>> getByRating(@RequestParam Double rating) {
        return ResponseEntity.ok(movieService.getByRating(rating));
    }
    @PutMapping
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.updateMovie(movie));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovieById(id);
        return ResponseEntity.ok("Movie deleted successfully");
    }
}
