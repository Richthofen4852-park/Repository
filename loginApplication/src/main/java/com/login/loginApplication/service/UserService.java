package com.login.loginApplication.service;


import com.login.loginApplication.domain.User;
import com.login.loginApplication.domain.UserRepository;
import com.login.loginApplication.domain.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;


    @Transactional
    public Long update(Long id, UserRequestDto requestDto) {

        User user = userRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );

        user.update(requestDto);
        return user.getId();

    }

    @Transactional
    public String emailToPassword(Long id, String email) {

        User user = userRepository.findById(id).orElseThrow(
                ()-> new NullPointerException("아이디가 존재하지 않습니다.")
        );

        if(user.getEmail().equals(email)) {
            return user.getPassword();
        } else {
            return null;
        }
    }

}
