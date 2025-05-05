package com.example.zentasks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.zentasks.dto.TaskDTO;
import com.example.zentasks.entities.Tag;
import com.example.zentasks.entities.Task;
import com.example.zentasks.repositories.TagRepository;
import com.example.zentasks.repositories.TaskRepository;
import com.example.zentasks.repositories.UserRepository;

@Service
public class TaskService {
    @Autowired private TaskRepository repo;
    @Autowired private UserRepository userRepo;
    @Autowired private TagRepository tagRepo;

    public TaskDTO create(TaskDTO dto) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setUser(userRepo.findById(dto.getUserId()).orElseThrow());
        task.setTags(tagRepo.findAllById(dto.getTagIds()));
        return toDTO(repo.save(task));
    }
    public List<TaskDTO> getTasksForUser(Long userId) {
        return repo.findByUserId(userId).stream().map(this::toDTO).toList();
    }

    private TaskDTO toDTO(Task t) {
        return new TaskDTO(t.getId(), t.getTitle(), t.getDescription(), t.getUser().getId(),
            t.getTags().stream().map(Tag::getId).toList());
    }
}