package com.example.zentasks;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.zentasks.entities.User;
import com.example.zentasks.repositories.UserRepository;

@SpringBootApplication
public class ZenTasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZenTasksApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(UserRepository repo, PasswordEncoder encoder) {
	    return args -> {
	        if (repo.findByEmail("test@example.com").isEmpty()) {
	            User user = new User();
	            user.setEmail("test@example.com");
	            user.setPassword(encoder.encode("password123"));
	            user.setName("Test User");
	            repo.save(user);
	            System.out.println("Default user created: test@example.com / password123");
	        }
	    };
	}


}
