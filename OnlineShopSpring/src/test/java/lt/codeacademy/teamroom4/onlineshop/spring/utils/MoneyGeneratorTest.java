package lt.codeacademy.teamroom4.onlineshop.spring.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoneyGeneratorTest {

	@Test
	void testVirtualMoney() {
		if(MoneyGenerator.virtualMoney()>0) {
			assertTrue(true);
		}
		else {
			assertTrue(false);;
	}

	}
}
