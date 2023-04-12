package lt.codeacademy.teamroom4.onlineshop.spring.repositories;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Coupon;

class CouponRepositoryTest {
@Autowired
private CouponRepository couponRepTest;
	@Test
	void testFindMax() {
		Coupon coupon1 = new Coupon(20);
		Coupon coupon2 = new Coupon(40);
		couponRepTest.save(coupon1);
		couponRepTest.save(coupon2);
		if(couponRepTest.findMax().getDiscount()==40) {
		assertTrue(true);
		}
		else {
			assertTrue(false);
	
		}
		
	}

}
