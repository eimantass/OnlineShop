package lt.codeacademy.teamroom4.onlineshop.spring.repositories;

import java.util.Collection;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.CartItem;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.ShoppingCart;

class ShoppingCartRepositoryTest {
	
	@Autowired
	ShoppingCartRepository rep;
	
	Collection<CartItem> cartItems;
	Date time = new Date();
	String session =  "sessionToken";
	ShoppingCart cart = new ShoppingCart((long)2, time, 45.45, 5, cartItems,session);
	
	@Test
	void testFindBySessionToken() {
		//rep.save(cart);
		rep.findBySessionToken(session);
	}

}
