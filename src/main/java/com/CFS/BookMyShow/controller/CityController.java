package com.CFS.BookMyShow.controller;

import com.CFS.BookMyShow.entity.City;
import com.CFS.BookMyShow.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @PostMapping
    public ResponseEntity<City> addCity(@RequestBody City city) {
        return ResponseEntity.ok(cityService.addCity(city));
    }

    @GetMapping
    public ResponseEntity<List<City>> getAllCities()
    {
        return ResponseEntity.ok(cityService.getAllCities());
    }

    @GetMapping("{id}")
    public ResponseEntity<City> getAllCitiesById(@PathVariable Long id)
    {
        return ResponseEntity.ok(cityService.getCityById(id));
    }
}
