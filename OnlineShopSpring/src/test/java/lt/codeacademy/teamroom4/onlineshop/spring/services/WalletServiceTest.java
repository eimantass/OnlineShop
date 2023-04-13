package lt.codeacademy.teamroom4.onlineshop.spring.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
		walletService.getAll();
		
	}

	@Test
	void testGetById() {
		fail("Not yet implemented");
	}

	@Test
	void testCreateOrUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

}
