package lt.codeacademy.teamroom4.onlineshop.spring.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WalletExceptionResponseTest {

	@Test
	void testWalletExceptionResponse() {
        String errorMessage = "Wallet not found";
        WalletExceptionResponse response = new WalletExceptionResponse(errorMessage);
        assertEquals(errorMessage, response.getErrorMessage());
	}

}
