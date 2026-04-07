package com.CFS.BookMyShow.controller;

import com.CFS.BookMyShow.dto.LoginRequest;
import com.CFS.BookMyShow.dto.UserRequest;
import com.CFS.BookMyShow.entity.User;
import com.CFS.BookMyShow.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    private ResponseEntity<User> register(@RequestBody UserRequest userRequest) {
         return ResponseEntity.ok(userService.register(userRequest));
    }
    @PostMapping("/login")
    private ResponseEntity<User> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(userService.login(loginRequest));
    }

    @GetMapping
    private ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @GetMapping("/{id}")
    private ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
}
