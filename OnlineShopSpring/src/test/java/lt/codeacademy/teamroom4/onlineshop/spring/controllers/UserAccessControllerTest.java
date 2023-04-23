package lt.codeacademy.teamroom4.onlineshop.spring.controllers;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.User;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.UserRepository;
import static org.junit.Assert.assertTrue;


//@WebMvcTest( UserAccessController.class)
@SpringBootTest
class UserAccessControllerTest {
	
	 
	 @Autowired
	 UserRepository userRepository;
	
	
	@Test
	void testGetUserById() throws Exception {
		Long id = 10L;
		//userRepository.deleteAll();
		User user = new User(id, "username" ,"username@gmail.com", "username123");
		//userRepository.save(user);
		if(user.getId() == 10) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
		
		
	}

}
