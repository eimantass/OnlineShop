package lt.codeacademy.teamroom4.onlineshop.spring.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.CartItem;

class CartItemRepositoryTest {
	
	@Autowired
	CartItemRepository rep;
	
	@Test
	void test() {
		rep.save(new CartItem());
	}

}
