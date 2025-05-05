package com.example.zentasks.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.zentasks.entities.Tag;
import com.example.zentasks.repositories.TagRepository;

@Service
public class TagService {
    @Autowired private TagRepository repo;
    public Tag save(Tag t) { return repo.save(t); }
}