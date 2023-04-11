package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CouponTest {
	
	Coupon cpn = new Coupon((long)2, 30, false);
	@Test
	void testGetId() {
		if(cpn.getId().equals((long)1)) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testCouponInt() {
		Coupon coupon = new Coupon(30);
		if(coupon.getDiscount() == 30) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testCoupon() {
		if(cpn == null) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testCouponLongInt() {
		Coupon coupon1 = new Coupon((long)3, 30);
		if(coupon1.getId().equals((long)3) && coupon1.getDiscount() == 30) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testCouponLongIntBoolean() {
		if( 
			cpn.getId().equals((long)3) &&
			cpn.getDiscount() == 30) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetDiscount() {
		if(cpn.getDiscount() == 30) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testIsDiscount() {
		//padaryti veliau
	}

}
