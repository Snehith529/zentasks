package com.example.zentasks;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.zentasks.entities.User;
import com.example.zentasks.repositories.UserRepository;
import com.example.zentasks.security.JwtTokenProvider;
import com.example.zentasks.services.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	
    @Mock private UserRepository userRepo;
    @Mock private JwtTokenProvider jwtTokenProvider;
    @InjectMocks private UserService userService;
    
    @Test
    void shouldFindUserById() {
        User user = new User(); user.setId(1L);
        when(userRepo.findById(1L)).thenReturn(Optional.of(user));
        Optional<User> result = userService.findById(1L);
        assertTrue(result.isPresent());
    }

    @Test
    void shouldReturnEmptyForInvalidUser() {
        when(userRepo.findById(99L)).thenReturn(Optional.empty());
        Optional<User> result = userService.findById(99L);
        assertFalse(result.isPresent());
    }

    @Test
    void shouldGenerateToken() {
        JwtTokenProvider jwt = new JwtTokenProvider();
        String token = jwt.generateToken("test@example.com");
        assertNotNull(token);
        assertTrue(token.contains("."));
    }
}
