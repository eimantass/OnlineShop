package lt.codeacademy.teamroom4.onlineshop.spring.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

class CustomResponseEntityExceptionHandlerTest {
	
	 @Autowired
	 private MockMvc mockMvc;

	@Test
	void testHandleWalletException() throws Exception {
		 String errorMessage = "Insufficient funds";
	     WalletException exception = new WalletException(errorMessage);

	     mockMvc.perform(MockMvcRequestBuilders.get("/test")
	            .contentType(MediaType.APPLICATION_JSON)
	            .content("{}"))
	            .andExpect(MockMvcResultMatchers.status().isBadRequest())
	            .andExpect(MockMvcResultMatchers.content().json(",\"errorMessage\":\"" + errorMessage + "\"}"
	     ));
	}

}
