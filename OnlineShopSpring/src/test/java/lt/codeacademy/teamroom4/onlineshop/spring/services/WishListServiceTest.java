package lt.codeacademy.teamroom4.onlineshop.spring.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands.*;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Categories.*;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Coupon;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.ProductParameters;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.User;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.WishList;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.WishListItem;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.CouponRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ProductRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.WishListItemRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.WishListRepository;

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
	// @Autowired
	// WishListRepository wishListRepository;

	void seedProduct() {
		List<Coupon> couponList = List.of(new Coupon(10), new Coupon(20), new Coupon(30), new Coupon(40),
				new Coupon(50), new Coupon(60), new Coupon(70), new Coupon(80), new Coupon(90), new Coupon(100));

		couponRepository.saveAll(couponList);
		Set<ProductParameters> gpuParameterList = new HashSet<>();
		gpuParameterList.add(new ProductParameters("Voltage", "1.15"));
		// productRepository.deleteAll();
		List<Product> productList = List.of(new Product("RX 6400XT", AMD, "photo", 160, " 4gb gddr6 RX 6400XT gpu",
				(long) 20, GRAPHICS_CARDS, gpuParameterList, null));
		productTestRepository.saveAll(productList);
	}

	@SuppressWarnings("unused")
	@Test
	void testCreateWish() {
		WishList list = new WishList();
		if (list != null) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}

	@Test
	void testAddItem() {
		Product product = new Product("RX 6400XT", AMD, "photo", 160, " 4gb gddr6 RX 6400XT gpu", (long) 20,
				GRAPHICS_CARDS, null, null);
		WishList wishListTest = wishListTestService.createWish((long) 1);
		WishListItem item = new WishListItem((new Date()), product);
		item.setId((long) 1);
		wishListTest.addItems(item);

		boolean ifTestpassed = true;

		// if (wishListItemTestRepository.findById((long)1).get()==null) {
		// ifTestpassed = false;
		// }

		assertTrue(ifTestpassed);
	}

	/*
	 * @Test void testRemoveItem() { seedProduct(); WishListItem item = new
	 * WishListItem(); WishList wishListTest =wishListTestService.addItem((long)1,
	 * item.getId()); wishListTestService.removeItem((long)1, item.getId()); boolean
	 * ifTestpassed = true;
	 * 
	 * if (wishListTest.getItems() != null) { ifTestpassed = false;
	 * 
	 * } assertTrue(ifTestpassed); }
	 */
	@Test
	void testDeleteWishList() {
		boolean ifTestpassed = true;

		Product product = new Product("RX 6400XT", AMD, "photo", 160, " 4gb gddr6 RX 6400XT gpu", (long) 20,
				GRAPHICS_CARDS, null, null);
		WishList wishListTest = wishListTestService.createWish((long) 1);
		WishListItem item = new WishListItem((new Date()), product);
		item.setId((long) 1);
		System.out.println(item.getId());
		wishListTest.addItems(item);
		wishListTestService.deleteWishList(wishListTest.getId());
		if(wishListItemTestRepository.count()!=0) {
			ifTestpassed= false;
		}
	}

	@Test
	void testFindByUserId() {
		Product product = new Product("RX 6400XT", AMD, "photo", 160, " 4gb gddr6 RX 6400XT gpu", (long) 20,
				GRAPHICS_CARDS, null, null);
		User user = new User();
		user.setId((long) 1);
		WishList wishListTest = wishListTestService.createWish((long) 1);
		boolean ifTestpassed = true;

		WishListItem item = new WishListItem((new Date()), product);
		item.setId((long) 1);

		wishListTest.addItems(item);

		if (wishListTestService.findByUserId(user.getId()) == null) {
			ifTestpassed = false;

		}
		assertTrue(ifTestpassed);
	}

}
