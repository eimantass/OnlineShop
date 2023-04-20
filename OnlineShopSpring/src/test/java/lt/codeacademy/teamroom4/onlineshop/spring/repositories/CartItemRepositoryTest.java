package lt.codeacademy.teamroom4.onlineshop.spring.repositories;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.CartItem;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;

@RunWith(SpringRunner.class)
@DataJpaTest
class CartItemRepositoryTest {
	
	@Autowired
	CartItemRepository rep;
	
	@Test
	void test() {
		Date time = new Date();
		CartItem item = new CartItem(1L, 5 , time, new Product());
		rep.save(item);
	}

}
