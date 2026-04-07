package com.CFS.BookMyShow.service;

import com.CFS.BookMyShow.dto.ScreenRequest;
import com.CFS.BookMyShow.entity.Screen;
import com.CFS.BookMyShow.entity.Theater;
import com.CFS.BookMyShow.repository.ScreenRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScreenService {
    private final ScreenRepository screenRepository;
    private final TheaterService theaterService;

    // Add Screen
    public Screen addScreen(ScreenRequest request) {

        // Get Theater using theaterId (not cityId)
        Theater theater = theaterService.getTheaterById(request.getTheaterId());

        // Create Screen object
        Screen screen = Screen.builder()
                .name(request.getName())
                .total_seats(request.getTotalSeats())
                .theater(theater)
                .build();

        // Save screen
        return screenRepository.save(screen);
    }
    public List<Screen> getAllScreen()
    {
        return screenRepository.findAll();
    }

    public Screen getScreenById(Long id)
    {
        return screenRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Screen not found with id: "+id));

    }

    public List<Screen> getScreenByTheater(Long theaterId)
    {
        return screenRepository.findByTheaterId(theaterId);
    }


}
