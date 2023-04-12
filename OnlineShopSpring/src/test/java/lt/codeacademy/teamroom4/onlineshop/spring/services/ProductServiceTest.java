package lt.codeacademy.teamroom4.onlineshop.spring.services;

import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands.AMD;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands.GOODRAM;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands.INTEL;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands.NVIDIA;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Categories.CPU;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Categories.GPU;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Categories.RAM;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Category;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Coupon;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.ProductParameters;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.CouponRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ProductRepository;
@RunWith(SpringRunner.class)
@SpringBootTest
//@DataJpaTest
//@EnableWebMvc
//@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
	@Autowired
private ProductRepository productRepository;
	@Autowired
	private CouponRepository couponRepository;
	//@InjectMocks
	@Autowired
	private ProductService productService = new ProductService();
Logger logger ;

	private void seedProduct() {
		List<Coupon> couponList=List.of( new Coupon(10),
		 new Coupon(30), new Coupon(50));

		couponRepository.saveAll(couponList);
		Set<ProductParameters> gpuParameterList = null;
		//productRepository.deleteAll();
		List<Product> productList = List.of(new Product("4gb RAM", GOODRAM, "foto.png", 30, "4 gb ddr3 ram", RAM,gpuParameterList, couponList.get(0)),
				
		new Product("4gb RAM", GOODRAM, "foto.png", 30, "4 gb ddr3 ram", RAM,gpuParameterList, couponList.get(1)),
		new Product("4gb RAM", GOODRAM, "foto.png", 30, "4 gb ddr3 ram", RAM,gpuParameterList, couponList.get(2)));

		productRepository.saveAll(productList);
	
		//System.out.println("----------------------------------------------"+productRepository.count());
		//productRepository.saveAll(product);
		//logger.info(productRepository.toString());
	}

	@Test
	void testSortByDiscountAll() {
		seedProduct();
		boolean ifTestpassed =true;
		//logger.info(null, productRepository.count());
		//List<Product> sortedProduct = null;
		List<Product> sortedProduct = productService.sortByDiscountAll(0);
		for(int i =1;i<sortedProduct.size();i++) {
			if(sortedProduct.get(i-1).getDiscount().getDiscount()<sortedProduct.get(i).getDiscount().getDiscount()) {
				ifTestpassed = false;
			}

		}
		assertTrue(ifTestpassed);
	}

	@Test
	void testSortByNameAll() {
		seedProduct();

		fail("Not yet implemented");
	}
//
//	@Test
//	void testSortByPriceAll() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSortByCategoryAll() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSortByBrandAll() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetProductById() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetAllProducts() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSearchByPrice() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSearchProductByNameLike() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSearchProductByCategory() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetAllBrands() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetAllCategories() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetAllParameters() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetProductWithBigestDiscount() {
//		fail("Not yet implemented");
//	}
//
}
