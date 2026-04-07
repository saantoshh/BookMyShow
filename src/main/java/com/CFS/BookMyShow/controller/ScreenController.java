package com.CFS.BookMyShow.controller;

import com.CFS.BookMyShow.dto.ScreenRequest;
import com.CFS.BookMyShow.entity.Screen;
import com.CFS.BookMyShow.service.ScreenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/screens")
@RequiredArgsConstructor
public class ScreenController {
    private final ScreenService screenService;

    @PostMapping
    public ResponseEntity<Screen> addScreen(@RequestBody ScreenRequest request) {
        return ResponseEntity.ok(screenService.addScreen(request));
    }

    @GetMapping
    public ResponseEntity<List<Screen>> getAllScreens(){
        return ResponseEntity.ok(screenService.getAllScreen());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Screen> getScreenById(@PathVariable Long id){
        return ResponseEntity.ok(screenService.getScreenById(id));
    }


    @GetMapping("/theater/{theaterId}")
    public ResponseEntity <List<Screen>> getScreenByTheater(@PathVariable Long theaterId){
        return ResponseEntity.ok(screenService.getScreenByTheater(theaterId));
    }


}
