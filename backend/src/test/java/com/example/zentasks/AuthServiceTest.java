package com.example.zentasks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.zentasks.dto.LoginRequestDTO;
import com.example.zentasks.entities.User;
import com.example.zentasks.repositories.UserRepository;
import com.example.zentasks.security.JwtTokenProvider;
import com.example.zentasks.services.AuthService;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

	@Mock
	private UserRepository userRepo;
	@Mock
	private JwtTokenProvider jwtTokenProvider;

	@InjectMocks
	private AuthService authService;
	 @Test
	    void shouldReturnTokenOnValidLogin() {
	        User user = new User();
	        user.setEmail("test@example.com");
	        user.setPassword("pass");

	        when(userRepo.findByEmail("test@example.com")).thenReturn(Optional.of(user));
	        when(jwtTokenProvider.generateToken("test@example.com")).thenReturn("mock-token");

	        LoginRequestDTO dto = new LoginRequestDTO();
	        dto.setEmail("test@example.com");
	        dto.setPassword("pass");

	        String token = authService.login(dto);
	        assertEquals("mock-token", token);
	    }
}
