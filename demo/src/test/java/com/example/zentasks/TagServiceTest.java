package com.example.zentasks;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.zentasks.entities.Tag;
import com.example.zentasks.repositories.TagRepository;
import com.example.zentasks.services.TagService;



@ExtendWith(MockitoExtension.class)
public class TagServiceTest {

    @Mock private TagRepository tagRepo;
    @InjectMocks private TagService tagService;
    
    @Test
    void shouldSaveTag() {
        Tag tag = new Tag(); tag.setName("Urgent");
        when(tagRepo.save(tag)).thenReturn(tag);
        Tag result = tagService.save(tag);
        assertEquals("Urgent", result.getName());
    }

}
