package lt.codeacademy.teamroom4.onlineshop.spring.repositories;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Cart;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.CartItem;

class ShoppingCartRepositoryTest {
	
	@Autowired
	ShoppingCartRepository rep;
	
	List<CartItem> items;
	Date time = new Date();
	String session =  "sessionToken";
	Cart cart = new Cart((long)2,  45.45, items);
	
	@Test
	void testFindBySessionToken() {
		fail("Not yet implemented");
		//rep.save(cart);
		//rep.findBySessionToken(session);
	}

}
