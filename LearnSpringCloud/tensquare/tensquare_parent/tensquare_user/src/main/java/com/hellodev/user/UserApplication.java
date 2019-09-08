package com.hellodev.user;
import com.hellodev.common.utils.JwtUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.hellodev.common.utils.IdWorker;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@Bean
	public IdWorker idWorkker(){
		return new IdWorker(1, 1);
	}

	@Bean
	public BCryptPasswordEncoder bcryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	public JwtUtil jwtUtil(){
		return new JwtUtil();
	}
}
