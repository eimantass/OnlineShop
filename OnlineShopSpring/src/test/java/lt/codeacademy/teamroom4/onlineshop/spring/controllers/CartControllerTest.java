package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Cart;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.CartItem;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.CartItemRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ShoppingCartRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.services.CartServiceImpl;

@SpringBootTest
class CartControllerTest {
	
	@Autowired 
	ShoppingCartRepository repository;
	
	@Autowired
	CartItemRepository itemRepository;
	
	@Autowired
	CartServiceImpl service;
	
	@Test
	void testCreateCart() {
		Cart cart = new Cart();
	    Cart savedCart = repository.save(cart);

	    assertNotNull(savedCart);
	    assertNotNull(savedCart.getId());
	    assertEquals(cart, savedCart);
	}

	@Test
	void testAddItem() {
		Cart cart = new Cart();
		repository.save(cart);

		CartItem item = new CartItem();
		itemRepository.save(item);
		cart.addItems(item);

		Optional<Cart> updatedCart = repository.findById(cart.getId());
		assertTrue(updatedCart.isPresent());
	}


	@Test
	void testDeleteCart() {
		 Cart cart = new Cart();
		 repository.save(cart);
		 service.deleteCart(cart.getId());
		 Optional<Cart> deletedCart = repository.findById(cart.getId());
		 assertFalse(deletedCart.isPresent());
	}

}
