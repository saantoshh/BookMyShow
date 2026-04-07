package com.CFS.BookMyShow.service;

import com.CFS.BookMyShow.dto.TheaterRequest;
import com.CFS.BookMyShow.entity.City;
import com.CFS.BookMyShow.entity.Theater;

import com.CFS.BookMyShow.repository.TheaterRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TheaterService {

    private final TheaterRepository theaterRepository;
    private final CityService cityService;

   public List<Theater> getAllTheaters(){
       return theaterRepository.findAll();
   }
    public Theater addTheater(TheaterRequest request)
    {
        City city=cityService.getCityById(request.getCityId());
        Theater theater=Theater.builder()
                .name(request.getName())
                .address(request.getAddress())
                .city(city)
                .build();
        return theaterRepository.save(theater);
    }
    public Theater getTheaterById(Long id)
    {
        return theaterRepository.findById(id).
                orElseThrow(()->new RuntimeException("Theater not found with id:  "+id));
    }
    public List<Theater> getTheatersByCityId(Long cityId)
    {
        return theaterRepository.findByCityId(cityId);
    }


}
