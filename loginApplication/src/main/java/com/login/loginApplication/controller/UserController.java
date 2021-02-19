package com.login.loginApplication.controller;


import com.login.loginApplication.domain.User;
import com.login.loginApplication.domain.UserRepository;
import com.login.loginApplication.domain.UserRequestDto;
import com.login.loginApplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping("/api/login")
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @PostMapping("/api/login")
    public User createUser(@RequestBody UserRequestDto requestDto) {

        User user = new User(requestDto);
        return userRepository.save(user);
    }

    @PutMapping("/api/login/{id}")
    public Long updateUser(@PathVariable Long id, @RequestBody UserRequestDto requestDto) {

        return userService.update(id, requestDto);
    }

    @DeleteMapping("/api/login/{id}")
    public Long deleteUser(@PathVariable Long id, @RequestBody UserRequestDto requestDto) {

        userRepository.deleteById(id);
        return id;
    }
}
