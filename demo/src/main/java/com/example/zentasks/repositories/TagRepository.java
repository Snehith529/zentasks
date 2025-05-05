package com.example.zentasks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.zentasks.entities.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}
