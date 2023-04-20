package lt.codeacademy.teamroom4.onlineshop.spring.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CartDtoTest {
	
	List<RecordDto> records = new ArrayList<>();
	CartDto dto = new CartDto((long)2, records);
	
	@Test
	void testCartDto() {
		if(dto == null) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetId() {
		if(dto.getId().equals((long)2)) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetId() {
		dto.setId((long)4);
		if(dto.getId()==4) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetRecords() {
		if(dto.getRecords() == null) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}


	@Test
	void testGetTotalPrice() {
		records.add(new RecordDto(1L, "suris", 5, 22.5, 4.5));
		records.add(new RecordDto(1L, "pienas", 2, 4.6, 2.3));
		CartDto cart = new CartDto(1L, records);
		cart.getTotalPrice();
	}

}
