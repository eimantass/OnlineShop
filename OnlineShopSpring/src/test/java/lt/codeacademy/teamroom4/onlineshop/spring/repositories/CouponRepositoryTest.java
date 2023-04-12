package lt.codeacademy.teamroom4.onlineshop.spring.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Coupon;

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
