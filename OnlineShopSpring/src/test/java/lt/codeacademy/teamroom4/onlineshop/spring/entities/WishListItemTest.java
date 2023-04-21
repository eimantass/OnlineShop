package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class WishListItemTest {
	
	Date time = new Date();
	WishListItem item = new WishListItem((long)2, time, new Product());
	
	@Test
	void testWishListItem() {
		boolean ifTestSuccesfull =true;
		if(item == null) {
			ifTestSuccesfull = false;
		}
		assertTrue(ifTestSuccesfull);

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
		Boolean ifTestSuccesfull = true;
		Date testDate =new Date();
		item.setDate(new Date());
		if(!item.getDate().equals(testDate)) {
			ifTestSuccesfull = false;
			}
	
			assertTrue(ifTestSuccesfull);
	}

	@Test
	void testGetProduct() {
		boolean ifTestSuccesfull =true;
		
		if(item.getProduct() == null) {
			ifTestSuccesfull=false;
		}
		assertTrue(ifTestSuccesfull);

	}

	@Test
	void testSetProduct() {
		Product product = new Product();
		item.setProduct(product);
		if(item.getProduct() == product) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}	
	}

}
