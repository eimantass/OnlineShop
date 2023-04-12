package lt.codeacademy.teamroom4.onlineshop.spring.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RecordDtoTest {
	
	RecordDto dto = new RecordDto((long)2, "name", 5, 250.445, 45.32);
	
	@Test
	void testRecordDto() {
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
	void testGetName() {
		if(dto.getName().equals("name")) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetName() {
		dto.setName("name1");
		if(dto.getName().equals("name1")) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetAmount() {
		if(dto.getAmount() == 5) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetAmount() {
		dto.setAmount(10);
		if(dto.getAmount() == 10) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetSuma() {
		if(dto.getSuma() == 250.445) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetTotalPrice() {
		dto.setTotalPrice(500.41);;
		if(dto.getSuma() == 500.41) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetPrice() {
		if(dto.getPrice() == 45.32) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetPrice() {
		dto.setPrice(20.20);
		if(dto.getPrice() == 20.20) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

}
