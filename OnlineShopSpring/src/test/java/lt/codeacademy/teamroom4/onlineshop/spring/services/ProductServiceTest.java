package lt.codeacademy.teamroom4.onlineshop.spring.services;

import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands.AMD;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands.GOODRAM;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands.INTEL;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands.NVIDIA;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Categories.CPU;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Categories.GPU;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Categories.RAM;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Category;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Coupon;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.ProductParameters;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ProductRepository;
//@RunWith(SpringRunner.class)
//@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
	@MockBean
	ProductRepository productRepository;
	@InjectMocks
	ProductService productService = new ProductService();
Logger logger ;
	private void seedProduct() {
		Set<ProductParameters> cpuParameterList = new HashSet<>();
		Set<ProductParameters> gpuParameterList = new HashSet<>();
		ProductParameters firstCPU = new ProductParameters("I3", "Intel");
		ProductParameters firstGpu = new ProductParameters("RX 6400XT", "2321 Mhz");
		gpuParameterList.add(firstGpu);
		cpuParameterList.add(firstCPU);
		List<Product> product = List.of(
//				new Product("i3-10100F", INTEL, "foto.png", 67, "Quad Core CPU", categoryList.get(1),cpuParameterList),
				new Product("RX 6400XT", AMD, "foto.png", 160, " 4gb gddr6 RX 6400XT gpu", GPU, gpuParameterList),
				new Product("GTX 1650 Super", NVIDIA, "foto.png", 220, "4 gb gddr6 GTX 1650 Super gpu", GPU,
						gpuParameterList),
				new Product("4gb RAM", GOODRAM, "foto.png", 30, "4 gb ddr3 ram", RAM, gpuParameterList),
				new Product("IntelI5", INTEL, "foto.png", 200, "12 core cpu", CPU),
				new Product("IntelI7", INTEL, "foto.png", 250, "16 core cpu", CPU, cpuParameterList),
				new Product("IntelI7", INTEL, "foto.png", 250, "16 core cpu", CPU, cpuParameterList));
//
		productRepository.saveAll(product);
		//logger(productRepository.findAll());
		//System.out.println(productRepository.toString());

	}

	@Test
	void testSortByDiscountAll() {
		seedProduct();
		List<Product> sortedProduct = productService.sortByDiscountAll(0);
		if (sortedProduct != null) {
			assertTrue(true);
		} else {
			assertTrue(false);

		}
	}

//	@Test
//	void testSortByNameAll() {
//		fail("Not yet implemented");
//	}
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
