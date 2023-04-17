package lt.codeacademy.teamroom4.onlineshop.spring.services;

import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands.GOODRAM;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands.NVIDIA;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Categories.GRAPHICS_CARDS;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Categories.LAPTOPS;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Coupon;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.ProductParameters;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.WishList;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.CouponRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ProductRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.WishListItemRepository;
@RunWith(SpringRunner.class)
@SpringBootTest
class WishListServiceTest {
	@Autowired
	private ProductRepository productTestRepository;
	@Autowired
	private CouponRepository couponRepository;
	@Autowired
	private WishListService wishListTestService;
	@Autowired
	private WishListItemRepository wishListItemTestRepository;
//	@AfterEach
//	void tearDown() {
//		wishListItemTestRepository.deleteAll();
//	}
		


	 void seedProduct() {
		List<Coupon> couponList = List.of(new Coupon(10), new Coupon(20), new Coupon(30), new Coupon(40),
				new Coupon(50), new Coupon(60), new Coupon(70), new Coupon(80), new Coupon(90), new Coupon(100));

		couponRepository.saveAll(couponList);
		Set<ProductParameters> gpuParameterList = new HashSet<>();
		gpuParameterList.add(new ProductParameters("Voltage", "1.15"));
		// productRepository.deleteAll();
		List<Product> productList = List.of(

				new Product("Gt710", NVIDIA, "foto.png", 40, "RTX", GRAPHICS_CARDS, gpuParameterList, couponList.get(1)),
				new Product("RTX", NVIDIA, "foto.png", 80, "RTX", GRAPHICS_CARDS, gpuParameterList, couponList.get(7)));

		productTestRepository.saveAll(productList);

	}
	@Test
	void testAddToWishFirstTime() {
	//	WishList wishListTest =
		wishListTestService.addToWishFirstTime((long)1, "TestToken");
		boolean ifTestpassed = true;

		if (wishListItemTestRepository.findById((long)1).get()==null) {
			ifTestpassed = false;

		}
		assertTrue(ifTestpassed);	
	}

	@Test
	void testAddToExistingShoppingCart() {
		WishList wishListTest = wishListTestService.addToExistingShoppingCart((long)1, "TestToken");
		boolean ifTestpassed = true;

		if (wishListTest == null) {
			ifTestpassed = false;

		}
		assertTrue(ifTestpassed);	
	}
	@Test
	void testGetWishListBySessionToken() {
		boolean ifTestpassed = true;
		wishListTestService.addToWishFirstTime((long)2, "TestToken2");

		if (wishListTestService.getWishListBySessionToken("TestToken2") == null) {
			ifTestpassed = false;

		}
		assertTrue(ifTestpassed);	
	}

	@Test
	void testRemoveItemFromWishList() {
		seedProduct();
		WishList wishListTest =wishListTestService.addToWishFirstTime((long)1, "TestToken3");
		
		wishListTestService.removeItemFromWishList((long)1, "TestToken3");
		
		boolean ifTestpassed = true;

		
		if (wishListTest.getItems() != null) {
			ifTestpassed = false;

		}
		assertTrue(ifTestpassed);	
	
	}

	@Test
	void testClearWishList() {
		WishList wishListTest =wishListTestService.addToWishFirstTime((long)6, "TestToken6");
		wishListTestService.clearWishList("TestToken6");
	}

}
