package lt.codeacademy.teamroom4.onlineshop.spring.payload.request;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import payload.request.SignupRequest;

class SignupRequestTest {
	
	SignupRequest signup = new SignupRequest("name", "name@gmail.com", "password");

	@Test
	void testGetUsername() {
		if(signup.getUsername().equals("name")) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetUsername() {
		signup.setUsername("username");
		if(signup.getUsername().equals("username")) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetEmail() {
		if(signup.getEmail().equals("name@gmail.com")) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetEmail() {
		signup.setEmail("username@gmail.com");
		if(signup.getEmail().equals("username@gmail.com")) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetPassword() {
		if(signup.getPassword().equals("password")) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetPassword() {
		signup.setPassword("pass");
		if(signup.getPassword().equals("pass")) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

}
