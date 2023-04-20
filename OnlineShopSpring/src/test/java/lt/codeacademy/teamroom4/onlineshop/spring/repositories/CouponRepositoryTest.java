package lt.codeacademy.teamroom4.onlineshop.spring.repositories;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Coupon;

@RunWith(SpringRunner.class)
@DataJpaTest
class CouponRepositoryTest {

	@Autowired
	CouponRepository rep;
	
	@Test
	void testFindMax() {
		Coupon cpn = new Coupon((long)2, 30, false);
		rep.save(cpn);
		rep.findMax();
	}

}
