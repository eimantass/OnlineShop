package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.User;
import lt.codeacademy.teamroom4.onlineshop.spring.services.UserDetailsServiceImpl;

@WebMvcTest( UserAccessController.class)
class UserAccessControllerTest {
	
	 @Autowired
	 private MockMvc mvc;
	
	@MockBean
	private UserDetailsServiceImpl userService;
	
	@Test
	void testGetUserById() throws Exception {
		User user = new User((long)1, "Name", "email@gmail.com", "password");
		userService.getById((long)1);
		
		 mvc.perform(get("/api/user-access/customers/{id}")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.id").value(1))
	                .andExpect(jsonPath("$.Name").value("Name"))
	                .andExpect(jsonPath("$.email").value("email@gmail.com"))
	                .andExpect(jsonPath("$.password").value("password"));
	}

}
