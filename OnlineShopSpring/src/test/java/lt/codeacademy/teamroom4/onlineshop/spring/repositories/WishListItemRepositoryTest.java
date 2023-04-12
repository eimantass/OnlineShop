package lt.codeacademy.teamroom4.onlineshop.spring.repositories;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.WishListItem;

class WishListItemRepositoryTest {
	
	@Autowired
	WishListItemRepository rep;

	@Test
	void test() {
		rep.save(new WishListItem());
	}

}
