package lt.codeacademy.teamroom4.onlineshop.spring.payload.request;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import payload.request.LoginRequest;

class LoginRequestTest {
	
	LoginRequest loging = new LoginRequest("username", "password");

	@Test
	void testGetUsername() {
		if(loging.getUsername().equals("username")) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetUsername() {
		loging.setUsername("name");
		if(loging.getUsername().equals("name")) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetPassword() {
		if(loging.getPassword().equals("password")) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetPassword() {
		loging.setPassword("pass");
		if(loging.getPassword().equals("pass")) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

}
