package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Coupon;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.ProductParameters;
import lt.codeacademy.teamroom4.onlineshop.spring.services.ProductService;

class ProductControllerTest {
	
	

	 @MockBean
	 private ProductService productService;

	 Set<ProductParameters> cpuParameterList = new HashSet<>();
	 ProductParameters firstCPU = new ProductParameters("I3", "Intel");
	 Coupon coupon1 = new Coupon(10);
		
	@Test
	public void testGetProductById() throws Exception {
		
	}

}
