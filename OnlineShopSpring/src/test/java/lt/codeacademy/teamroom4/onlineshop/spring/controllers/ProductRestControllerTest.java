package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;

class ProductRestControllerTest {
	
	ProductRestController controller = new ProductRestController();
	
	@Test
	  public void testSearchByPrice() {
	    double minPrice = 500.00;
	    double maxPrice = 1000.00;
	    @SuppressWarnings("unchecked")
		List<Product> productList = (List<Product>) controller.search(minPrice, maxPrice);
	    assertFalse(productList.isEmpty());
	    for (Product product : productList) {
	        assertTrue(product.getPrice() >= minPrice && product.getPrice() <= maxPrice);
	    }
	  }

}
