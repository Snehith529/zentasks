package com.example.zentasks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.zentasks.dto.UserDTO;
import com.example.zentasks.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired private UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        return service.findById(id).map(u -> ResponseEntity.ok(new UserDTO()))
            .orElse(ResponseEntity.notFound().build());
    }
}