package com.example.zentasks.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.zentasks.entities.User;
import com.example.zentasks.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;

	public Optional<User> findById(Long id) {
		return repo.findById(id);
	}
}
