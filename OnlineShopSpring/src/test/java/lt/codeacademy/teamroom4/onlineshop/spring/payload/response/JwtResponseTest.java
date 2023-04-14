package lt.codeacademy.teamroom4.onlineshop.spring.payload.response;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import payload.response.JwtResponse;

class JwtResponseTest {
	List<String> roles =List.of(("ADMIN"));
			//new ArrayList<>();
	JwtResponse jwtResponse = new JwtResponse("TestToken", (long)1, "TestJWT", "larry@gmail.com",roles);
	@Test
	void testJwtResponse() {
		JwtResponse jwtResponse = new JwtResponse("TestToken2", (long)2, "TestJWT2", "larry2@gmail.com",roles);
	}

	@Test
	void testGetAccessToken() {
		boolean ifTestpassed = true;

		if (jwtResponse.getAccessToken()==null) {
			ifTestpassed = false;

		}
		assertTrue(ifTestpassed);
	}

	@Test
	void testSetAccessToken() {
		boolean ifTestpassed = true;
		jwtResponse.setAccessToken("TestToken");
		if (jwtResponse.getAccessToken()!="TestToken") {
			ifTestpassed = false;
		}
		assertTrue(ifTestpassed);
	}

	@Test
	void testGetSetTokenType() {
		boolean ifTestpassed = true;
		jwtResponse.setTokenType("TestType");
		if(jwtResponse.getTokenType()!="TestType") {
			ifTestpassed = false;

		}
		assertTrue(ifTestpassed);

	}

	@Test
	void testGetSetId() {
		boolean ifTestpassed = true;
		jwtResponse.setId((long)9);
		if(jwtResponse.getId()!=9) {
			ifTestpassed = false;

		}
		assertTrue(ifTestpassed);
	}

	@Test
	void testSetGetUsername() {
		boolean ifTestpassed = true;
		jwtResponse.setId((long)9);
		if(jwtResponse.getId()!=9) {
			ifTestpassed = false;

		}
		assertTrue(ifTestpassed);
	}



	@Test
	void testSetGetEmail() {
		boolean ifTestpassed = true;
		jwtResponse.setEmail("larryK@hotmail.com");
		if(jwtResponse.getEmail().equals("larryK@hotmail.com")) {
			ifTestpassed = false;

		}
		assertTrue(ifTestpassed);
	}


	@Test
	void testSetGetRoles() {
		boolean ifTestpassed = true;
		jwtResponse.setRoles(roles);
		if(jwtResponse.getRoles().equals(roles)) {
			ifTestpassed = false;

		}
		assertTrue(ifTestpassed);
	}


}
