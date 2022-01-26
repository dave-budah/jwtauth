package com.selvigtech.jwtauth;

import com.selvigtech.jwtauth.domain.Role;
import com.selvigtech.jwtauth.domain.User;
import com.selvigtech.jwtauth.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class JwtauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtauthApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_WRITER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_MODERATOR"));

			userService.saveUser(new User(null, "Dave Budah", "dave@email.com", "davebudah", "password", new ArrayList<>()));
			userService.saveUser(new User(null, "Walter Budah", "walter@email.com", "walterbudah", "password", new ArrayList<>()));
			userService.saveUser(new User(null, "Memory Budah", "memo@email.com", "memobudah", "password", new ArrayList<>()));
			userService.saveUser(new User(null, "Dana Budah", "dana@email.com", "danabudah", "password", new ArrayList<>()));
			userService.saveUser(new User(null, "Fotrica Budah", "fortie@email.com", "fortiebudah", "password", new ArrayList<>()));

			userService.addRoleToUser( "davebudah", "ROLE_ADMIN");
			userService.addRoleToUser( "davebudah", "ROLE_WRITER");
			userService.addRoleToUser( "fortiebudah", "ROLE_WRITER");
			userService.addRoleToUser( "walterbudah", "ROLE_USER");
			userService.addRoleToUser( "memobudah", "ROLE_WRITER");
			userService.addRoleToUser( "danabudah", "ROLE_MODERATOR");
		};
	}
}
