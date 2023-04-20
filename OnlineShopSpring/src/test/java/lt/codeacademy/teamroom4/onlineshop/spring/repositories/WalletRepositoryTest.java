package lt.codeacademy.teamroom4.onlineshop.spring.repositories;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Wallet;

@RunWith(SpringRunner.class)
@DataJpaTest
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
