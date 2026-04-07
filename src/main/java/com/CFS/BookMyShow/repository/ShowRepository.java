package com.CFS.BookMyShow.repository;

import com.CFS.BookMyShow.entity.Show;
import com.CFS.BookMyShow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ShowRepository extends JpaRepository<Show,Long> {

      List<Show> findByMovieId(Long movieId);
      List<Show> findByScreenId(Long screenIid);
      List<Show> findByMovie_IdAndShowDate(Long movieId, LocalDate showDate);
}
