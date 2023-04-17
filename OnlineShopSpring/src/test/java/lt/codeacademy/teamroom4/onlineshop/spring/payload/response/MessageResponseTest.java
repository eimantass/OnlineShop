package lt.codeacademy.teamroom4.onlineshop.spring.payload.response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import payload.response.MessageResponse;

class MessageResponseTest {
	MessageResponse response = new MessageResponse("message");

	@Test
	void testMessageResponse() {
		if(response == null) {
			assertTrue(true);
		}
		else {
			assertTrue(false);
		}
	}

	@Test
	void testGetMessage() {
		if(response.getMessage().equals("error")) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetMessage() {
		response.setMessage("error 404");
		if(response.getMessage().equals("error 404")) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

}