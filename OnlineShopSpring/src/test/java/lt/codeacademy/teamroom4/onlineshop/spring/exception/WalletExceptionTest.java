package lt.codeacademy.teamroom4.onlineshop.spring.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WalletExceptionTest {

	@Test
	void testWalletException() {
		try {
	        throw new WalletException("Insufficient funds");
	    }catch (WalletException e) {
	        assertEquals("Insufficient funds", e.getMessage());
	    }
	}

}
