package com.example.zentasks.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.zentasks.entities.User;
import com.example.zentasks.repositories.UserRepository;

import java.util.List;


@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired private UserRepository repo;
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User u = repo.findByEmail(email).orElseThrow();
        return new org.springframework.security.core.userdetails.User(u.getEmail(), u.getPassword(), List.of());
    }
}
