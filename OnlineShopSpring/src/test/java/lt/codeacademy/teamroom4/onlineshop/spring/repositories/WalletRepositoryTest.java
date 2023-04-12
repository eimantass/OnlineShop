package lt.codeacademy.teamroom4.onlineshop.spring.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Wallet;

class WalletRepositoryTest {
	
	@Autowired
	WalletRepository rep;

	@Test
	void testFindAllByOrderByPriority() {
		int priority = 2;
		Wallet wallet = new Wallet((long)2, "Name", "4545445", "Pervedimas", priority, 452.364);
		rep.save(wallet);
		rep.findAllByOrderByPriority();
	}

}
