package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.User;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.UserRepository;
import payload.request.SignupRequest;

class AuthControllerTest {
	
	 @Mock
	 private AuthenticationManager authenticationManager;

	 @Mock
	 private UserDetailsService userDetailsService;
	 
	 @Autowired
	 private TestRestTemplate restTemplate;

	 private MockMvc mockMvc;
	 
	
	@Test
	void testAuthenticateUser() throws Exception {
		String username = "testuser";
	    String password = "testpass";
	    String token = "testtoken";

	    Authentication auth = mock(Authentication.class);
	    UserDetails userDetails = mock(UserDetails.class);
	    
	    when(authenticationManager.authenticate((Authentication) any(Authentication.class))).thenReturn(auth);
        when(userDetailsService.loadUserByUsername(username)).thenReturn(userDetails);
        when(userDetails.getUsername()).thenReturn(username);
        when(userDetails.getPassword()).thenReturn(password);
        when(userDetailsService.loadUserByUsername(username)).thenThrow(new UsernameNotFoundException("User not found"));
        
        mockMvc.perform(post("api/auth/sigin")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\": \"" + username + "\", \"password\": \"" + password + "\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value(token));
    }

	 private UserRepository userRepository;
	 private PasswordEncoder passwordEncoder;
	 private AuthController authController;

	@Test
	void testRegisterUser() {
      SignupRequest request = new SignupRequest();
      request.setUsername("user");
      request.setEmail("user@user.com");
      request.setPassword("user123");
      
      ResponseEntity<Void> response = restTemplate.postForEntity("/api/auth/signup", request, Void.class);
      assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);

	}

}
