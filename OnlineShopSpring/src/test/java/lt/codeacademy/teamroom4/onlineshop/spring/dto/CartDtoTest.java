package lt.codeacademy.teamroom4.onlineshop.spring.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class CartDtoTest {
	
	List<RecordDto> records;
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
	void testSetIrasai() {
		dto.setIrasai(records);
		if(dto.getRecords().equals(records)) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetTotalPrice() {
		if(dto.getTotalPrice() == 0) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

}
