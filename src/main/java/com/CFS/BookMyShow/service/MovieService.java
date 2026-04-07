package com.CFS.BookMyShow.service;

import com.CFS.BookMyShow.entity.Movie;
import com.CFS.BookMyShow.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
     private final MovieRepository movieRepository;

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).
                orElseThrow(()->new RuntimeException("Movies Not Found With Id: "+id));
    }

    public List<Movie> searchByTitle(String title){
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Movie> getByGenre(String genre){
        return movieRepository.findByGenre(genre);
    }
    public List<Movie> getByRating(Double rating){
        return movieRepository.findByRating(rating);
    }

    public List<Movie> getByLanguage(String language){
        return movieRepository.findByLanguage(language);
    }

    public List<Movie> searchByRatingGreaterThan(Double rating){
        return movieRepository.findByRatingGreaterThan(rating);
    }

    public Movie updateMovie(Movie movie) {

        Movie existingMovie = movieRepository.findById(movie.getId())
                .orElseThrow(() -> new RuntimeException("Movie not found with id: " + movie.getId()));
        existingMovie.setTitle(movie.getTitle());
        existingMovie.setGenre(movie.getGenre());
        existingMovie.setLanguage(movie.getLanguage());
        existingMovie.setRating(movie.getRating());
        existingMovie.setDescription(movie.getDescription());
        existingMovie.setRelease_date(movie.getRelease_date());
        existingMovie.setDuration_minutes(movie.getDuration_minutes());

        return movieRepository.save(existingMovie);
    }
    public void deleteMovieById(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found with id: " + id));

        movieRepository.delete(movie);
        System.out.println("Deleted Movie with id: " + id);
    }
}
