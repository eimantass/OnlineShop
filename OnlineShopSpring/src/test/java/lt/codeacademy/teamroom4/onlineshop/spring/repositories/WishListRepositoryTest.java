package lt.codeacademy.teamroom4.onlineshop.spring.repositories;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.WishList;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.WishListItem;

class WishListRepositoryTest {
	
	@Autowired
	WishListRepository rep;
	
	Date time = new Date();
	List<WishListItem> items;
	String session = "sessionToken";
	WishList list = new WishList((long)2, 446.45, items);
	
//	@Test
//	void testFindBySessionToken() {
//		rep.save(list);
//		rep.findBySessionToken(session);
//	}

}
