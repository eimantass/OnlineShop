package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.User;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Wallet;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.WalletRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.services.WalletService;


@RunWith(SpringRunner.class)
//@WebMvcTest(WalletController.class)
@SpringBootTest
class WalletControllerTest {
	
	
	 @Autowired
	 private WalletService walletService;
	 
	 @Autowired
	 WalletRepository walletRepository;
	 
	
	@Test
	void testGetById() throws Exception {
		Long id = 10L;
		Wallet wallet = new Wallet(id, "SEB" ,"454554");
		walletRepository.save(wallet);
		if(wallet.getId() == 10) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
		  
	}
	
}


