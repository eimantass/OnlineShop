package lt.codeacademy.teamroom4.onlineshop.spring.payload.request;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import payload.request.LoginRequest;
//@RunWith(SpringRunner.class)
@SpringBootTest
class LoginRequestTest {
	
	LoginRequest loginRequest = new LoginRequest();

	@Test
	void testGetSetUsername() {
		loginRequest.setUsername("Test");
		boolean ifTestpassed = true;

		if(!loginRequest.getUsername().equals("Test")) {
			ifTestpassed = false;
		}
		assertTrue(ifTestpassed);
	}

//	@Test
//	void testSetUsername() {
//		fail("Not yet implemented");
//	}

	//@Test
	void testGetSetPassword() {
		loginRequest.setPassword("Test");
		boolean ifTestpassed = true;

		if(!loginRequest.getPassword().equals("Test")) {
			ifTestpassed = false;
		}
		assertTrue(ifTestpassed);
	}
}
