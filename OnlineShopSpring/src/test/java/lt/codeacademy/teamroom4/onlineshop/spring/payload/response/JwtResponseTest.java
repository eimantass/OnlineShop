package lt.codeacademy.teamroom4.onlineshop.spring.payload.response;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import lt.codeacademy.teamroom4.onlineshop.spring.utils.MoneyGenerator;
import payload.response.JwtResponse;

class JwtResponseTest {
	
	private List<String> roles;
	JwtResponse jwt = new JwtResponse("token", (long)2, "username", "email@gmail.com", roles);

	@Test
	void testJwtResponse() {
		if(jwt == null) {
			assertTrue(true);
		}
		else {
			assertTrue(false);
		}
	}

	@Test
	void testGetAccessToken() {
		if(jwt.getAccessToken().equals("token")) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetAccessToken() {
		jwt.setAccessToken("accessToken");
		if(jwt.getAccessToken().equals("accessToken")) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetId() {
		if(jwt.getId().equals((long)2)) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetId() {
		jwt.setId((long)3);
		if(jwt.getId().equals((long)3)) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetUsername() {
		if(jwt.getUsername().equals("username")) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetUsername() {
		jwt.setUsername("name");
		if(jwt.getUsername().equals("name")) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetEmail() {
		if(jwt.getEmail().equals("email@gmail.com")) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetEmail() {
		jwt.setEmail("name@gmail.com");
		if(jwt.getEmail().equals("name@gmail.com")) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetRoles() {
		if(jwt.getRoles() == null) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

}
