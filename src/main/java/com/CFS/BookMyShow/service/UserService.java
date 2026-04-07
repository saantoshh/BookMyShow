package com.CFS.BookMyShow.service;

import com.CFS.BookMyShow.dto.LoginRequest;
import com.CFS.BookMyShow.dto.UserRequest;
import com.CFS.BookMyShow.entity.User;
import com.CFS.BookMyShow.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    //Register User
    public User register(UserRequest userRequest) {
        if (userRepository.existsByEmail(userRequest.getEmail())) {
            throw new RuntimeException("User already exists:  "+userRequest.getEmail());
        }
            User user = User.builder().
                    name(userRequest.getName())
                    .email(userRequest.getEmail())
                    .password(userRequest.getPassword())
                    .phone(userRequest.getPhone())
                    .build();

        return userRepository.save(user);
    }

    //login
    public User login(LoginRequest  loginRequest) {
        User user=userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(()->new RuntimeException("User not found:  "+loginRequest.getEmail()));

        if (!user.getPassword().equals(loginRequest.getPassword())) {
            throw new RuntimeException("Wrong password");
        }
        return user;
    }

    //Get list of all users
    public List<User>getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).
                orElseThrow(()->new RuntimeException("User not found:  "+id));
    }

}
