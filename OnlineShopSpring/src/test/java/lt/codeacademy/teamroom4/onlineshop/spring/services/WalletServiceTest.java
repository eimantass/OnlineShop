package lt.codeacademy.teamroom4.onlineshop.spring.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
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
		boolean ifTestpassed = true;
		Wallet wallet = new Wallet((long)1,"Larry", "LT513456321");
		walletTestRepository.save(wallet);
		if (walletTestService.getById((long) 1)==null) {
			ifTestpassed = false;

		}
		assertTrue(ifTestpassed);
	}

	@Test
	void testCreateOrUpdate() {
		boolean ifTestpassed = true;
		Wallet wallet = new Wallet((long)1,"Larry", "LT513456321");
		Wallet walletBlank = new Wallet();
		Wallet testWalletBlank = walletTestService.createOrUpdate(walletBlank);

		Wallet testWallet = walletTestService.createOrUpdate(wallet);
		if (walletTestRepository.count()!=2) {
			ifTestpassed = false;

		}
		assertTrue(ifTestpassed);
	}

	

	@Test
	void testDelete() {
		Wallet wallet = new Wallet((long)1,"Larry", "LT513456321");
		walletTestRepository.save(wallet);
		boolean ifTestpassed = true;
		//walletTestRepository.delete(wallet);
	//System.out.println(walletTestRepository.count());
		if (walletTestService.delete((long)1)==false) {
			ifTestpassed = false;

		}
		assertTrue(ifTestpassed);
	}
}
