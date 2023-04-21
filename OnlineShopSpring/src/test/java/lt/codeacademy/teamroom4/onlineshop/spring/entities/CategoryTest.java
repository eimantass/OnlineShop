package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Categories.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Categories;

class CategoryTest {
	
	List<Category> categoryList = List.of(new Category(GRAPHICS_CARDS),new Category(PROCESSORS));
	Category cat = new Category((long)2, GRAPHICS_CARDS);
	Set<Categories> cato = new HashSet<>();
	
	@Test
	void testCategoryCategories() {
		boolean ifTestSuccesfull =true;
		Set<Categories> emptyCategory = new HashSet<>();		
		if(!cato.equals(emptyCategory)) {
			ifTestSuccesfull=false;
		}
		assertTrue(ifTestSuccesfull);
		
	}

	@Test
	void testCategory() {
		if(cat != null) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetId() {
		if(cat.getId().equals((long)2)) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetId() {
		cat.setId((long)4);
		if(cat.getId()==4) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetName() {
		if(cat.getName().equals(GRAPHICS_CARDS)) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetName() {
		cat.setName(PROCESSORS);
		if(cat.getName().equals(PROCESSORS)) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

}
