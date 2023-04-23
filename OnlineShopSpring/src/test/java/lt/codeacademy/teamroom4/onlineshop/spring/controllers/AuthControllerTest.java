package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.UserRepository;


@SpringBootTest
class AuthControllerTest {
	
	 @Autowired
	 UserRepository userRepository;
	 

//	@Test
//	void testAuthenticateUser() throws Exception {
//		String username = "testuser";
//	    String password = "testpass";
//	    String token = "testtoken";
//
//	    Authentication auth = mock(Authentication.class);
//	    UserDetails userDetails = mock(UserDetails.class);
//	    
//	    when(authenticationManager.authenticate((Authentication) any(Authentication.class))).thenReturn(auth);
//        when(userDetailsService.loadUserByUsername(username)).thenReturn(userDetails);
//        when(userDetails.getUsername()).thenReturn(username);
//        when(userDetails.getPassword()).thenReturn(password);
//        when(userDetailsService.loadUserByUsername(username)).thenThrow(new UsernameNotFoundException("User not found"));
//        
//        mockMvc.perform(post("api/auth/sigin")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"username\": \"" + username + "\", \"password\": \"" + password + "\"}"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.token").value(token));
//    }

	
	
//	@Test
//	void testRegisterUser() {
//      SignupRequest request = new SignupRequest();
//      request.setUsername("user");
//      request.setEmail("user@user.com");
//      request.setPassword("user123");      
//     
//	}

}
