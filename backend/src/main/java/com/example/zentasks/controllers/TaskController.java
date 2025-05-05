package com.example.zentasks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.zentasks.dto.TaskDTO;
import com.example.zentasks.services.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired private TaskService service;

    @PostMapping
    public ResponseEntity<TaskDTO> create(@RequestBody TaskDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/user/{userId}")
    public List<TaskDTO> getUserTasks(@PathVariable Long userId) {
        return service.getTasksForUser(userId);
    }
}
