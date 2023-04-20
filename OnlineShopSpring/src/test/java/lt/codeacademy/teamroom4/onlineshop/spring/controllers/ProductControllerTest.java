package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands.INTEL;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Categories.PROCESSORS;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Coupon;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.ProductParameters;
import lt.codeacademy.teamroom4.onlineshop.spring.services.ProductService;

class ProductControllerTest {
	
	 @Autowired
	 private MockMvc mockMvc;

	 @MockBean
	 private ProductService productService;

	 Set<ProductParameters> cpuParameterList = new HashSet<>();
	 ProductParameters firstCPU = new ProductParameters("I3", "Intel");
	 Coupon coupon1 = new Coupon(10);
		
	@Test
	public void testGetProductById() throws Exception {
		
		long productId = 1L;
		Product product = new Product(productId, "IntelI7", INTEL,  250, "16 core cpu", PROCESSORS, cpuParameterList,
				coupon1);
	
	}

}
