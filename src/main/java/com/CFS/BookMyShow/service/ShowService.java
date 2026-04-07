package com.CFS.BookMyShow.service;

import com.CFS.BookMyShow.dto.ShowRequest;
import com.CFS.BookMyShow.entity.Movie;
import com.CFS.BookMyShow.entity.Screen;
import com.CFS.BookMyShow.entity.Show;
import com.CFS.BookMyShow.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowService {
    private final ShowRepository showRepository;
    private final ScreenService screenService;
    private final MovieService movieService;

    public Show addShow(ShowRequest request) {
        Movie movie=movieService.getMovieById(request.getMovieId());
        Screen screen=screenService.getScreenById(request.getScreenId());

        Show show=Show.builder()
                .movie(movie)
                .screen(screen)
                .showDate(request.getShowDate())
                .start_time(request.getStartTime())
                .end_time(request.getEndTime())
                .ticket_price(request.getTicketPrice())
                .build();

        return showRepository.save(show);
    }

    public List<Show> getAllShows() {
        return showRepository.findAll();
    }
    public Show getShowById(Long id)
    {
        return showRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Show not found with id: "+id));

    }

    public List<Show> getShowByMovie(Long movieId)
    {
        return showRepository.findByMovieId(movieId);
    }
    public List<Show> getShowByMovieAndDate(Long movieId, LocalDate date)
    {
        return showRepository.findByMovie_IdAndShowDate(movieId, date);
    }
    public List<Show> getShowByScreen(Long screenId)
    {
        return showRepository.findByScreenId(screenId);
    }

}
