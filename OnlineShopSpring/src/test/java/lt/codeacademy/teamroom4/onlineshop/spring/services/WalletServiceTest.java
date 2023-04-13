package lt.codeacademy.teamroom4.onlineshop.spring.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Wallet;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.WalletRepository;
@RunWith(SpringRunner.class)
@SpringBootTest
class WalletServiceTest {
	@Autowired
	WalletService walletService;
	@Autowired
	WalletRepository walletRepository;
	@Test
	void testGetAll() {
		boolean ifTestpassed = true;

		if (walletService.getAll().size()!=walletRepository.findAll().size()) {
			ifTestpassed = false;

		}
		assertTrue(ifTestpassed);
	}
		

	@Test
	void testGetById() {
		boolean ifTestpassed = true;
		Wallet wallet = new Wallet((long)1,"Larry", "LT513456321");
		walletRepository.save(wallet);
		if (walletService.getById((long) 1)==null) {
			ifTestpassed = false;

		}
		assertTrue(ifTestpassed);
	}

	@Test
	void testCreateOrUpdate() {
		Wallet testWallet = walletService.createOrUpdate(null);
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

}
