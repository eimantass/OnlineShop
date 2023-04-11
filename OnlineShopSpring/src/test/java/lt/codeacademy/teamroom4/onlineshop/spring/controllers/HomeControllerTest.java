package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HomeControllerTest {
HomeController homeController = new HomeController();
	@Test
	void startPagetest() {
		if(homeController.startPage() == "index") {
			assertTrue(true);
		}
		else {
			assertTrue(false);

		}
	}
	void getAllProductstest() {
		
		if(homeController.getAllProduct() != null ) {
			assertTrue(true);
		}
		else {
			assertTrue(false);

		}
	}
}
