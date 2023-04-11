package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class CartItemTest {
	
	Date time = new Date();
	CartItem item = new CartItem((long)2, 5,time ,new Product());
	
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
	void testGetQuantity() {
		if(item.getQuantity() == 5) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetQuantity() {
		item.setQuantity(4);
		if(item.getQuantity() == 4) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetSum() {
		if(item.getSum() == 5) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetProduct() {
		if(item.getProduct() != null) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetProduct() {
		item.setProduct(new Product());
		if(item.getProduct() != null) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetDate() {
		if(item.getDate() == time) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetDate() {
		item.setDate(time);
		if(item.getDate() == time) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

}
