package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.services.ProductService;

class ProductControllerTest {

	@Test
	public void testGetProductById() {
		 ProductService productService = mock(ProductService.class);
		 ProductController productController = new ProductController();
		 
		 Product product = new Product((long)1, "Product 1", 10.0);
	     when(productService.getProductById((long)1)).thenReturn(product);
	      
	     Product result = productController.getProduct((long)1);
	        
	     assertEquals(product, result);
	}

}
