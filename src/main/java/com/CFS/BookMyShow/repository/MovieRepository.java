package com.CFS.BookMyShow.repository;

import com.CFS.BookMyShow.entity.Movie;
import com.CFS.BookMyShow.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Long> {
    List<Movie> findByGenre(String genre);
    List<Movie> findByLanguage(String language);
    List<Movie> findByRating(Double rating);
    List<Movie> findByTitleContainingIgnoreCase(String title);
    List<Movie> findByRatingGreaterThan(Double rating);
//    List<Movie> findByName(String name);

}
