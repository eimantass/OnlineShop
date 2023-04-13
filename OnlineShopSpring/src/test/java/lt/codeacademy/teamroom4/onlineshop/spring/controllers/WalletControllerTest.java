package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Wallet;
import lt.codeacademy.teamroom4.onlineshop.spring.services.WalletService;

@WebMvcTest(WalletController.class)
class WalletControllerTest {
	
	 @Autowired
	 private MockMvc mvc;

	 @MockBean
	 private WalletService walletService;
	
	@Test
	void testGetById() throws Exception {
		Wallet wallet = new Wallet((long)1, "John Doe","544556415");
        walletService.getById((long)1);
        
        mvc.perform(get("/wallets/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.ownerName").value("John Doe"))
                .andExpect(jsonPath("$.accountNumber").value("544556415"));
	}

}
