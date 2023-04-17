package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class WishListItemTest {
	
	Date time = new Date();
	WishListItem item = new WishListItem((long)2, time, new Product());
	
	@Test
	void testWishListItem() {
		if(item == null) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetId() {
		if(item.getId().equals((long)2)) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetId() {
		item.setId((long)4);
		if(item.getId()==4) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetDate() {
		if(item.getDate().equals(time)) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}

	}

	@Test
	void testSetDate() {
		item.setDate(new Date());
		if(item.getDate().equals(time)) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetProduct() {
		if(item.getProduct() == null) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetProduct() {
		item.setProduct(new Product());
		if(item.getProduct() == new Product()) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}	
	}

}
