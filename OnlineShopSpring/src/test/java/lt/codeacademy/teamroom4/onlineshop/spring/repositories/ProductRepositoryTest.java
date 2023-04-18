package lt.codeacademy.teamroom4.onlineshop.spring.repositories;

import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands.INTEL;
import java.util.HashSet;
import java.util.Set;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Categories.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Coupon;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.ProductParameters;

class ProductRepositoryTest {
	
	@Autowired
	ProductRepository rep;
	
	
	Set<ProductParameters> cpuParameterList = new HashSet<>();
	ProductParameters firstCPU = new ProductParameters("I3", "Intel");
	Coupon coupon1 = new Coupon(10);
	String name = "IntelI7";
	Product product = new Product((long) 5, name, INTEL,  250, "16 core cpu", PROCESSORS, cpuParameterList,
			coupon1);


	@Test
	void testFindByNameContainingIgnoreCase() {
		rep.save(product);
		rep.findByNameContainingIgnoreCase(name);
	}

	@Test
	void testFindAllBrandsDistincts() {
		rep.save(product);
		rep.findAllBrandsDistincts();
	}

	@Test
	void testSearch() {
		
	}

	@Test
	void testFindAllWithCategory() {
		rep.save(product);
		rep.findAllWithCategory(null);
	}

}
