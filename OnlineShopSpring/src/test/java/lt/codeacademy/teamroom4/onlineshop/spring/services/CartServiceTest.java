package lt.codeacademy.teamroom4.onlineshop.spring.services;

import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands.GOODRAM;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands.NVIDIA;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Categories.GRAPHICS_CARDS;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Categories.LAPTOPS;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.CartItem;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Coupon;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.ProductParameters;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.ShoppingCart;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.CartItemRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.CouponRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ProductRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ShoppingCartRepository;
@RunWith(SpringRunner.class)
@SpringBootTest
class CartServiceTest {
	@Autowired
	private ShoppingCartRepository shoppingCartTestRepository;
	@Autowired
	private ProductRepository productTestRepository;
	@Autowired
	private CartItemRepository cartItemRepository;

	@Autowired
	private ProductService productService;
	@Autowired
	CartService cartService;
	@Autowired
	private CouponRepository couponTestRepository;

	private void seedProduct() {
		List<Coupon> couponList = List.of(new Coupon(10), new Coupon(20), new Coupon(30), new Coupon(40),
				new Coupon(50), new Coupon(60), new Coupon(70), new Coupon(80), new Coupon(90), new Coupon(100));

		couponTestRepository.saveAll(couponList);
		Set<ProductParameters> gpuParameterList = new HashSet<>();
		gpuParameterList.add(new ProductParameters("Voltage", "1.15"));
		// productRepository.deleteAll();
		List<Product> productList = List.of(
				new Product("4gb RAM", GOODRAM, "foto.png", 30, "4 gb ddr3 ram", LAPTOPS, gpuParameterList,
						couponList.get(0)),
				new Product("Gt710", NVIDIA, "foto.png", 40, "RTX", GRAPHICS_CARDS, gpuParameterList,
						couponList.get(1)),
				new Product("Gt730", NVIDIA, "foto.png", 90, "RTX", GRAPHICS_CARDS, gpuParameterList,
						couponList.get(2)),
				new Product("Gt1030", NVIDIA, "foto.png", 100, "RTX", GRAPHICS_CARDS, gpuParameterList,
						couponList.get(3)),
				new Product("Gt610", NVIDIA, "foto.png", 90, "RTX", GRAPHICS_CARDS, gpuParameterList,
						couponList.get(4)),
				new Product("4gb RAM", GOODRAM, "foto.png", 30, "4 gb ddr3 ram", LAPTOPS, gpuParameterList,
						couponList.get(5)),
				new Product("4gb RAM", GOODRAM, "foto.png", 30, "4 gb ddr3 ram", LAPTOPS, gpuParameterList,
						couponList.get(6)),
				new Product("RTX", NVIDIA, "foto.png", 80, "RTX", GRAPHICS_CARDS, gpuParameterList, couponList.get(7)));

		productTestRepository.saveAll(productList);
	}

	@Test
	void testAddShoppingCartFirstTime() {
		seedProduct();
		ShoppingCart shoppingCartWithFirstProduct = cartService.addShoppingCartFirstTime((long) 3, "TestToken", 1);
		boolean ifTestpassed = true;

		if (shoppingCartWithFirstProduct.getCartItems() == null) {
			ifTestpassed = false;

		}
		assertTrue(ifTestpassed);
	}

	@Test
	void testAddToExistingShoppingCart() {
		seedProduct();
		//ShoppingCart shoppingCartWithFirstProduct = 
				//cartService.addShoppingCartFirstTime((long) 1, "TestToken", 1);
		//ShoppingCart secondShoppingCart =
			ShoppingCart shoppingCartWithExistingProduct = cartService.addToExistingShoppingCart((long) 1, "TestToken", 1);
			boolean ifTestpassed = true;

			if (shoppingCartWithExistingProduct.getCartItems() == null) {
				ifTestpassed = false;

			}
			assertTrue(ifTestpassed);
	}

	@Test
	void testGetShoppingCartBySessionToken() {
		seedProduct();
		ShoppingCart testShoppingCart = cartService.addShoppingCartFirstTime((long) 1, "TestToken1", 1);
		ShoppingCart shoppingCartFromDatabase = cartService.getShoppingCartBySessionToken("TestToken1");
		boolean ifTestpassed = true;

		if (shoppingCartFromDatabase.getCartItems() == null) {
			ifTestpassed = false;

		}
		assertTrue(ifTestpassed);

	}

	@Test
	void testUpdateShoppingCartItem() {
		seedProduct();

		CartItem updatedCartItem = cartService.updateShoppingCartItem((long)1,10);
	boolean ifTestpassed = true;

	if (updatedCartItem.getQuantity() != 10) {
		ifTestpassed = false;

	}
	assertTrue(ifTestpassed);
	}

	@Test
	void testRemoveCartItemFromShoppingCart() {
		seedProduct();

		ShoppingCart testShoppingCart = cartService.addShoppingCartFirstTime((long) 1, "TestToken4", 1);

		ShoppingCart cartToRemoveItems = cartService.removeCartItemFromShoppingCart((long)1,"TestToken4");
		boolean ifTestpassed = true;

		if (testShoppingCart ==null) {
			ifTestpassed = false;

		}
		assertTrue(ifTestpassed);
		}
	@Test
	void testClearShoppingCart() {
		ShoppingCart testShoppingCart = cartService.addShoppingCartFirstTime((long) 1, "TestToken5", 1);
		cartService.clearShoppingCart("TestToken5");
		boolean ifTestpassed = true;

		if (cartService.getShoppingCartBySessionToken("TestToken5") != null) {
			ifTestpassed = false;

		}
		assertTrue(ifTestpassed);
	}
}
