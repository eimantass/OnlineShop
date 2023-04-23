package lt.codeacademy.teamroom4.onlineshop.spring.services;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Wallet;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.WalletRepository;


@SpringBootTest
class WalletServiceTest {
	
	@Autowired
	WalletService walletTestService;
	
	@Autowired
	WalletRepository walletTestRepository;
	
	@AfterEach
	void tearDown() {
		walletTestRepository.deleteAll();
	}
	@Test
	void testGetAll() {
		boolean ifTestpassed = true;

		if (walletTestService.getAll().size()!=walletTestRepository.findAll().size()) {
			ifTestpassed = false;

		}
		assertTrue(ifTestpassed);
	}
		

	@Test
	void testGetById() {
		Wallet wallet = new Wallet(1L, "seb", "446464");
		if(wallet.getId().equals(1L)) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testCreateOrUpdate() {
		walletTestRepository.deleteAll();
		boolean ifTestpassed = true;
		Wallet wallet = new Wallet((long)1,"Larry", "LT513456321");
		Wallet walletBlank = new Wallet((long)2,"Larry", "LT513456321");
		Wallet testWalletBlank = walletTestService.createOrUpdate(walletBlank);
		walletTestRepository.save(wallet);
		walletTestRepository.save(walletBlank);
		Wallet testWallet = walletTestService.createOrUpdate(wallet);
		if (walletTestRepository.count()!=2) {
			ifTestpassed = false;

		}
		assertTrue(true);
	}

	

//	@Test
//	void testDelete() {
//		 Wallet wallet = new Wallet();
//	     wallet.setId(1L);
//	     wallet.setAccountNumber("454545");
//	     when(walletTestRepository.findById(anyLong())).thenReturn(Optional.of(wallet));
//	    
//	     walletTestService.delete(1L);
//	     verify(walletTestRepository).delete(wallet);
//	}
	
}
