package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.CartItem;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.services.ProductService;

class CartControllerTest {
	
	 private CartController cartController;
	 private ProductService productService;


	@Test
	public void testAddToCart() {
		 long productId = 1;
	     int quantity = 2;
	     Product product = new Product("Test Product name", 10.0, "Test Description");
	     
	     when(productService.getProductById(productId)).thenReturn(product);
//	     CartItem cartItem = cartController.addingItemsToCart(null, productId, quantity);
//	     
//	     assertEquals(product, cartItem.getProduct());
//	     assertEquals(quantity, cartItem.getQuantity());
	}

}
