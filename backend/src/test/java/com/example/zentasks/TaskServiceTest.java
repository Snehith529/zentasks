package com.example.zentasks;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.zentasks.dto.TaskDTO;
import com.example.zentasks.entities.Tag;
import com.example.zentasks.entities.Task;
import com.example.zentasks.entities.User;
import com.example.zentasks.repositories.TagRepository;
import com.example.zentasks.repositories.TaskRepository;
import com.example.zentasks.repositories.UserRepository;
import com.example.zentasks.services.TagService;
import com.example.zentasks.services.TaskService;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

	 @Mock private UserRepository userRepo;
	 
	  @Mock private TagRepository tagRepo;
      @InjectMocks private TagService tagService;
      
      @Mock private TaskRepository taskRepo;
      @InjectMocks private TaskService taskService;
      
      
	   @Test
       void shouldCreateTaskSuccessfully() {
       	
       	Long id = 1L;
           String title = "Test Task";
           String description = "Description";
           Long userId = 1L;
           List<Long> tagIds = List.of(1L);
           
           TaskDTO dto = new TaskDTO(id, title, description, userId, tagIds);


           User user = new User(); user.setId(1L);
           Tag tag = new Tag(); tag.setId(1L);

           when(userRepo.findById(1L)).thenReturn(Optional.of(user));
           when(tagRepo.findAllById(List.of(1L))).thenReturn(List.of(tag));

           Task savedTask = new Task();
           savedTask.setId(100L);
           savedTask.setTitle("Test Task");
           savedTask.setDescription("Description");
           savedTask.setUser(user);
           savedTask.setTags(List.of(tag));

           when(taskRepo.save(any(Task.class))).thenReturn(savedTask);

           TaskDTO result = taskService.create(dto);
           assertEquals("Test Task", result.getTitle());
           assertEquals(1L, result.getUserId());
           assertEquals(List.of(1L), result.getTagIds());
       }
	   
	    @Test
        void shouldReturnUserTasks() {
            Task task = new Task();
            task.setId(1L);
            task.setTitle("Test");
            User user = new User(); user.setId(1L);
            task.setUser(user);
            task.setTags(List.of());

            when(taskRepo.findByUserId(1L)).thenReturn(List.of(task));

            List<TaskDTO> result = taskService.getTasksForUser(1L);
            assertEquals(1, result.size());
            assertEquals("Test", result.get(0).getTitle());
        }
    
}
