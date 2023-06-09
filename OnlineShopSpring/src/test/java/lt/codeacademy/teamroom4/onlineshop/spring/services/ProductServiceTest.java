package lt.codeacademy.teamroom4.onlineshop.spring.services;


import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands.GOODRAM;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands.NVIDIA;
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
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Category;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Coupon;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.ProductParameters;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.CategoryRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.CouponRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ProductRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Categories;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Categories.*;

@RunWith(SpringRunner.class)
@SpringBootTest

class ProductServiceTest {
	@Autowired
	private ProductRepository productTestRepository;
	@Autowired
	private CategoryRepository categoryTestRepository;
	@Autowired
	private CouponRepository couponRepository;
	
	@Autowired
	private ProductService testProductService;
	Logger logger;

//	@Before
//	void clear() {
//		productTestRepository.deleteAll();
//		couponRepository.deleteAll();
//	}
//	@AfterEach
//	void tearDown() {
//		productTestRepository.deleteAll();
//		couponRepository.deleteAll();
//
//	}
	 void seedProduct() {
		List<Coupon> couponList = List.of(new Coupon(10), new Coupon(20), new Coupon(30), new Coupon(40),
				new Coupon(50), new Coupon(60), new Coupon(70), new Coupon(80), new Coupon(90), new Coupon(100));

		couponRepository.saveAll(couponList);
		Set<ProductParameters> gpuParameterList = new HashSet<>();
		gpuParameterList.add(new ProductParameters("Voltage", "1.15"));
		// productRepository.deleteAll();
		List<Product> productList = List.of(
				new Product("4gb RAM", GOODRAM,  null, 30, "4 gb ddr3 ram", null, LAPTOPS, gpuParameterList,
						couponList.get(0)),
				new Product("Gt710", NVIDIA, null, 40, "RTX", null, GRAPHICS_CARDS, gpuParameterList, couponList.get(1)),
				new Product("Gt730", NVIDIA,  null, 90, "RTX", null, GRAPHICS_CARDS, gpuParameterList, couponList.get(2)),
				new Product("Gt1030", NVIDIA, null, 100, "RTX", null, GRAPHICS_CARDS, gpuParameterList, couponList.get(3)),
				new Product("Gt610", NVIDIA, null, 90, "RTX", null, GRAPHICS_CARDS, gpuParameterList, couponList.get(4)),
				new Product("4gb RAM", GOODRAM, null, 30, "4 gb ddr3 ram", null, LAPTOPS, gpuParameterList,
						couponList.get(5)),
				new Product("4gb RAM", GOODRAM, null, 30, "4 gb ddr3 ram", null, LAPTOPS, gpuParameterList,
						couponList.get(6)),
				new Product("RTX", NVIDIA,  null, 80, "RTX", null, GRAPHICS_CARDS, gpuParameterList, couponList.get(7)));

		productTestRepository.saveAll(productList);

	}
	private void seedCategory() {
		List<Category> categoryList = List.of(
		new Category(PROCESSORS),
		new Category(LAPTOPS),
		new Category(GRAPHICS_CARDS),
		new Category(MAINBOARDS),
		new Category(MOBILE_PHONES),
		new Category(MONITORS),
		new Category(PRINTERS),
		new Category(GAMECONSOLES),
		new Category(GAMES));
		
		categoryTestRepository.saveAll(categoryList);
	}
//	@Test
//	void testSortByDiscountAll() {
//		//seedProduct();
//		boolean ifTestpassed = true;
//		// logger.info(null, productRepository.count());
//		// List<Product> sortedProduct = null;
//		// logger.info(productService.sortByDiscountAll(0).toString());
//		List<Product> sortedProduct = testProductService.sortByDiscountAll(0);
//		for (int i = 2; i < 4; i++) {
//
//			if (sortedProduct.get(i - 1).getDiscount().getDiscount() > sortedProduct.get(i).getDiscount()
//					.getDiscount()) {
//				ifTestpassed = false;
//			}
//
//		}
//		assertTrue(ifTestpassed);
//	}

	

	@Test
	void testSortByNameAll() {
		seedProduct();
		List<Product> sortedProduct = testProductService.sortByNameAll(0);
		// List<Product> sortedProductFromRepository =
		// productTestRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
		if (sortedProduct.get(0).getName().equals("4gb RAM")
				&& sortedProduct.get(sortedProduct.size() - 1).getName().equals("RTX")) {
			assertTrue(true);

		} else {
			assertTrue(false);

		}

	}

	@Test
	void testSortByPriceAll() {
		seedProduct();
		boolean ifTestpassed = true;
		List<Product> sortedProduct = testProductService.sortByPriceAll(0);
		for (int i = 1; i < sortedProduct.size(); i++) {

			if (sortedProduct.get(i - 1).getPrice() > sortedProduct.get(i).getPrice()) {
				ifTestpassed = false;
			}

		}
		assertTrue(ifTestpassed);
	}

//
	@Test
	void testSortByCategoryAll() {
		seedProduct();
		boolean ifTestpassed = true;

		List<Product> sortedProduct = testProductService.sortByCategoryAll(0);
		if (sortedProduct.get(0).getCategory().toString().equals(sortedProduct.get(1).getCategory().toString())) {
			assertTrue(true);

		} else {
			assertTrue(false);
		}
	}

	@Test
	void testSortByBrandAll() {
		seedProduct();
		boolean ifTestpassed = true;

		List<Product> sortedProduct = testProductService.sortByBrandAll(0);
		if (sortedProduct.get(0).getBrand().toString().equals(sortedProduct.get(1).getBrand().toString())) {
			assertTrue(true);

		} else {
			assertTrue(false);
		}
	}

	@Test
	void testGetProductById() {
		seedProduct();
		Product productById = testProductService.getProductById((long) 2);
		if (productById.getId() == 2) {
			assertTrue(true);

		} else {
			assertTrue(false);

		}
	}

//
	@Test
	void testGetAllProducts() {
		seedProduct();
		List<Product> allProducts = testProductService.getAllProducts();
		if (allProducts.size() == productTestRepository.findAll().size()) {
			assertTrue(true);

		} else {
			assertTrue(false);

		}
	}

//	@Test
//	void testSearchByPrice() {
//		fail("Not yet implemented");
//	}

	@Test
	void testSearchProductByNameLike() {
		seedProduct();
		boolean ifTestpassed = true;

		List<Product> allProducts = testProductService.searchProductByNameLike("RTX");
		for(int i=0; i<allProducts.size()-1;i++) {
			if (allProducts.get(i).getName().equals("RTX")) {
				assertTrue(true);
		}
		

		} 
			assertTrue(ifTestpassed);

		
	}

//@Test
//	void sortingPlusPriceFiltering() {
//	fail("Not yet implemented");
//}
	// @Test
//	void sortingPlusPriceFiltering() {
//	fail("Not yet implemented");
//}	
	@Test
	void testSearchProductByCategory() {
		seedProduct();
		seedCategory();
		boolean ifTestpassed = true;
		Categories testCategory = GRAPHICS_CARDS;
		List<Product> allProducts = testProductService.searchProductByCategory(Categories.GRAPHICS_CARDS);
		for(int i=0; i<allProducts.size();i++) {
			if (allProducts.get(i).getCategory()!=Categories.GRAPHICS_CARDS) {
				ifTestpassed = false;
		}
		

		} 
			assertTrue(ifTestpassed);

		
	}
//
	@Test
	void testGetAllBrands() {
		seedProduct();
		List<Brands> allBrands = testProductService.getAllBrands();
		if (allBrands.size() == productTestRepository.findAllBrandsDistincts().size()) {
			assertTrue(true);

		} else {
			assertTrue(false);

		}
	}

	@Test
	void testGetAllCategories() {
		seedCategory();
		seedProduct();

		List<Category> allCategories = testProductService.getAllCategories();
		//System.out.println("---------------"+allCategories);
		if (allCategories.size()!=0 ) {
			assertTrue(true);

		} else {
			assertTrue(false);

		}
	}
	@Test
	void testGetAllParameters() {
		seedProduct();
		List<ProductParameters> allParameters = testProductService.getAllParameters();
		if (allParameters.size()!=0 ) {
			assertTrue(true);

		} else {
			assertTrue(false);

		}
	}
//
//	@Test
//	void testGetProductWithBigestDiscount() {
//		seedProduct();
//		boolean ifTestpassed = true;
//		
//		Product featuredProduct = testProductService.getProductWithBigestDiscount();
//		//List<Product> allProducts = testProductService.getAllProducts();
//		//for(int i =1; i <allProducts.size()-1;i++ ) {
////		if(featuredProduct.getDiscount().getDiscount()<allProducts.get(i).getDiscount().getDiscount()){
////			ifTestpassed= false;
////		}
//		
//		//}
//		assertTrue(ifTestpassed);
//
//	}

}
