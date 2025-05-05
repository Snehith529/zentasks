package com.example.zentasks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.zentasks.entities.Tag;
import com.example.zentasks.services.TagService;

@RestController
@RequestMapping("/api/tags")
public class TagController {
    @Autowired private TagService service;

    @PostMapping
    public ResponseEntity<Tag> add(@RequestBody Tag tag) {
        return ResponseEntity.ok(service.save(tag));
    }
}
