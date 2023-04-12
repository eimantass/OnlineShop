package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.Set;

import org.junit.jupiter.api.Test;

class WishListTest {
	
	Date time = new Date();
	Set<WishListItem> items;
	WishList list = new WishList((long)2, time, "sessionToken", items);
	
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
	void testGetDate() {
		if(list.getDate().equals(time)) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetDate() {
		list.setDate(new Date());
		if(list.getDate()== time) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}

	}

	@Test
	void testGetSessionToken() {
		if(list.getSessionToken().equals("sessionToken")) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetSessionToken() {
		list.setSessionToken("session");
		if(list.getSessionToken().equals("session")) {
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
