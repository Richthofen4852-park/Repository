package com.login.loginApplication.controller;


import com.login.loginApplication.domain.User;
import com.login.loginApplication.domain.UserRepository;
import com.login.loginApplication.domain.UserRequestDto;
import com.login.loginApplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping("/login")
    public List<User> getUser() {
        return userRepository.findAll();
    }

//    @PostMapping("/login")
//    public User createUser(@RequestBody UserRequestDto requestDto) {
//
//        User user = new User(requestDto);
//        return userRepository.save(user);
//    }

    @PostMapping("/login")
    public String loginSuccess(Long id, String email, HttpServletRequest httpServletRequest) {

        String pw = userService.emailToPassword(id, email);


        String password = httpServletRequest.getParameter("password");

        if (pw == password) {
            return "redirect:/main";
        } else {
            return null;
        }


    }
}

//    @PutMapping("/api/login/{id}")
//    public Long updateUser(@PathVariable Long id, @RequestBody UserRequestDto requestDto) {
//
//        return userService.update(id, requestDto);
//    }
//
//    @DeleteMapping("/api/login/{id}")
//    public Long deleteUser(@PathVariable Long id, @RequestBody UserRequestDto requestDto) {
//
//        userRepository.deleteById(id);
//        return id;
//    }
//}
