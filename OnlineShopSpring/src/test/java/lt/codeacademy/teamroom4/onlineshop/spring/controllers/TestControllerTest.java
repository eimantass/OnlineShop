package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import org.junit.jupiter.api.Test;

import lt.codeacademy.teamroom4.onlineshop.spring.controllers.TestController;

import static org.junit.jupiter.api.Assertions.*;

public class TestControllerTest {
	@Test
	void hello() {
		TestController controller = new TestController(); //Arange
		String response = controller.hello("World"); //Act
		assertEquals("Hello, World", response);//Assert
		//assertEquals(1>2)
		
	}
}
