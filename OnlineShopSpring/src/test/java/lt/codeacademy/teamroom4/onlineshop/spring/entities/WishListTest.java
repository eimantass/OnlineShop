package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

class WishListTest {
	
	Date time = new Date();
	List<WishListItem> items;
	WishList list = new WishList((long)2, 212.15, items);
	
	@Test
	void testWishList() {
		if(list == null) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetId() {
		if(list.getId().equals((long)2)) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetId() {
		list.setId((long)4);
		if(list.getId()==4) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}


	@Test
	void testGetItems() {
		if(list.getItems().equals(items)) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetItems() {
		list.setItems(items);
		if(list.getItems().equals(items)) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}

	}

}
