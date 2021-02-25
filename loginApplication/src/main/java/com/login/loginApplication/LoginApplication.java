package com.login.loginApplication;

import com.login.loginApplication.domain.User;
import com.login.loginApplication.domain.UserRepository;
import com.login.loginApplication.domain.UserRequestDto;
import com.login.loginApplication.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class LoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository userRepository, UserService userService) {

		return args -> {

			userRepository.save(new User("richthofen4852@naver.com", "jiseok918"));
			List<User> userList = userRepository.findAll();
			for (int i = 0; i < userList.size(); i++) {
				User user = userList.get(i);
				System.out.println(user.getEmail());
				System.out.println(user.getPassword());
			}

			UserRequestDto requestDto = new UserRequestDto("smash87299@gmail.com", "wkddnjsdud4852");
			userService.update(1L, requestDto);
			userList = userRepository.findAll();
			for (int i = 0; i < userList.size(); i++) {

				User user = userList.get(i);
				System.out.println(user.getEmail());
				System.out.println(user.getPassword());
			}


		};

	}



}
