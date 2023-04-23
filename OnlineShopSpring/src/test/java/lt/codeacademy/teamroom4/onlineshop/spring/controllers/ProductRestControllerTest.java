package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;

class ProductRestControllerTest {
	
	ProductRestController controller = new ProductRestController();
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	  public void testSearchByPrice() {
		double minPrice = 100;
		double maxPrice = 200;
		
		ResponseEntity<Product[]> response = restTemplate.getForEntity("/api/product/search/{min}/{max}", Product[].class, minPrice, maxPrice);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

		// Verify that the response body contains products with prices within the specified range
		    Product[] products = response.getBody();
		    assertThat(products).isNotNull();
		    for (Product product : products) {
		        assertThat(product.getPrice()).isGreaterThanOrEqualTo((minPrice));
		        assertThat(product.getPrice()).isLessThanOrEqualTo((maxPrice));
		    }
	  }

}
