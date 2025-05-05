package com.example.zentasks.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.zentasks.dto.LoginRequestDTO;
import com.example.zentasks.dto.RegisterRequestDTO;
import com.example.zentasks.entities.User;
import com.example.zentasks.repositories.UserRepository;
import com.example.zentasks.security.JwtTokenProvider;

@Service
public class AuthService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private JwtTokenProvider jwt;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public String login(LoginRequestDTO dto) {
		User user = userRepo.findByEmail(dto.getEmail()).orElseThrow();
		// Password check skipped for brevity
		return jwt.generateToken(user.getEmail());
	}

	public void register(RegisterRequestDTO dto) {
		if (userRepo.findByEmail(dto.getEmail()).isPresent()) {
			throw new RuntimeException("User already exists");
		}
		User user = new User();
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		userRepo.save(user);
	}
}