/*package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Date;

import org.junit.jupiter.api.Test;

class ShoppingCartTest {
	
	Collection<CartItem> cartItems;
	Date time = new Date();
	ShoppingCart cart = new ShoppingCart((long)2, time, 45.45, 5, cartItems, "sessionToken");

	@Test
	void testShoppingCart() {
		if(cart == null) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetId() {
		if(cart.getId().equals((long)2)) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}	}

	@Test
	void testSetId() {
		cart.setId((long)4);
		if(cart.getId()==4) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetDate() {
		if(cart.getDate() == time) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetDate() {
		cart.setDate(time);
		if(cart.getDate() == time) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetTotalPrice() {
		if(cart.getTotalPrice() == 45.45) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetItemsNumber() {
		if(cart.getItemsNumber() == 5) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetCartItems() {
		if(cart.getCartItems() == cartItems) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetCartItems() {
		cart.setCartItems(cartItems);
		if(cart.getCartItems() == cartItems) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetSessionToken() {
		if(cart.getSessionToken().equals("sessionToken")) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetSessionToken() {
		cart.setSessionToken("session");
		if(cart.getSessionToken() == "session") {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

}
*/