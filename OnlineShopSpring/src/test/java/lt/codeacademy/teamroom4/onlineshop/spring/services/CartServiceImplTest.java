package lt.codeacademy.teamroom4.onlineshop.spring.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Cart;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.CartItem;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.CartItemRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ShoppingCartRepository;

class CartServiceImplTest {
	
	@Autowired 
	ShoppingCartRepository repository;
	
	@Autowired
	CartServiceImpl service;
	
	@Autowired
	CartItemRepository itemRepository;

	@Test
	void testCreateCart() {
		
		Cart cart = service.createCart();
		Optional<Cart> createdCart = repository.findById(cart.getId());
		assertTrue(createdCart.isPresent());
	}

	@Test
	void testAddItem() {
		Cart cart = new Cart();
		repository.save(cart);

		CartItem item = new CartItem();
		itemRepository.save(item);
		service.addItem(cart.getId(), item);

		Optional<Cart> updatedCart = repository.findById(cart.getId());
		assertTrue(updatedCart.isPresent());
		assertEquals(1, updatedCart.get().getItems().size());
		assertEquals(item, updatedCart.get().getItems().get(0));
	}

	@Test
	void testRemoveItem() {
		 Cart cart = new Cart();
		 repository.save(cart);

		 CartItem item = new CartItem();
		 itemRepository.save(item);

		 service.addItem(cart.getId(), item);

		 service.removeItem(cart.getId(), item);

		 Optional<Cart> updatedCart = repository.findById(cart.getId());
		 assertTrue(updatedCart.isPresent());
		 assertEquals(0, updatedCart.get().getItems().size());
	}

	@Test
	void testDeleteCart() {
		  Cart cart = new Cart();
		  repository.save(cart);
		  service.deleteCart(cart.getId());
		  Optional<Cart> deletedCart = repository.findById(cart.getId());
		  assertFalse(deletedCart.isPresent());
	}

	@Test
	void testGetAllCarts() {
		List<Cart> allCarts = service.getAllCarts();
		if (allCarts.size() == repository.findAll().size()) {
			assertTrue(true);

		} else {
			assertTrue(false);

		}
	}

}
