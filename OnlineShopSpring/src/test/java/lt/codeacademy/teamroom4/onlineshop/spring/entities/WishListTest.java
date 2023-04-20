package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
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
		Date laikas = new Date();
		WishList wish = new WishList();
		List<WishListItem> produktai = new ArrayList<>();
		WishListItem pro1 = new WishListItem(1L, laikas, new Product());
		WishListItem pro2 = new WishListItem(2L, laikas, new Product());
		produktai.add(pro1);
		produktai.add(pro2);
		wish.setItems(produktai);
		
		assertEquals(produktai, wish.getItems());
        assertEquals(2, wish.getItems().size());
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
		Date laikas = new Date();
		WishList wish = new WishList();
		List<WishListItem> produktai = new ArrayList<>();
		WishListItem pro1 = new WishListItem(1L, laikas, new Product());
		WishListItem pro2 = new WishListItem(2L, laikas, new Product());
		produktai.add(pro1);
		produktai.add(pro2);
		wish.setItems(produktai);
		
		 assertEquals(produktai, wish.getItems());
	}

	@Test
	void testSetItems() {
		Date laikas = new Date();
		WishList wish = new WishList();
		List<WishListItem> produktai = new ArrayList<>();
		WishListItem pro1 = new WishListItem(1L, laikas, new Product());
		WishListItem pro2 = new WishListItem(2L, laikas, new Product());
		produktai.add(pro1);
		produktai.add(pro2);
		wish.setItems(produktai);
		
		assertEquals(produktai, wish.getItems());
	}

}
