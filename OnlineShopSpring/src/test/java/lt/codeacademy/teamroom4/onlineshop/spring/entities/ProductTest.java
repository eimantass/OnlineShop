package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands.INTEL;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Categories.CPU;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Categories;

class ProductTest {
	Set<ProductParameters> cpuParameterList = new HashSet<>();
	ProductParameters firstCPU = new ProductParameters("I3", "Intel");
	Coupon coupon1 = new Coupon(10);
	Product product = new Product((long) 5, "IntelI7", INTEL, "foto.png", 250, "16 core cpu", CPU, cpuParameterList,coupon1);

	void addProductParameters() {
	cpuParameterList.add(firstCPU);
	}

	@Test
	void testProductParameters() {
		Product emptyProduct = new Product();
		// emptyProduct.setName("RTX");

		if (emptyProduct.getName() == null) {
			assertTrue(true);
		} else {
			assertTrue(false);

		}
	}

	@Test
	void testProductParametersStringBrandPhotoDoubleStringDescriptionCategories() {
		// String name, Brands brand, String photo, double price, String description,
		// Categories categories
		Product testProduct = new Product("IntelI7", INTEL, "foto.png", 250, "16 core cpu", CPU);
		// emptyProduct.setName("RTX");

		if (
				testProduct.getName().equals("IntelI7") &&
				testProduct.getBrand().equals(INTEL) &&
				testProduct.getPhoto().equals("foto.png") &&
				testProduct.getPrice() ==250 &&
				testProduct.getCategory().equals(CPU) && 
				testProduct.getDescription().equals("16 core cpu") ) 
		{
			assertTrue(true);
		} else {
			assertTrue(false);

		}
	}
	@Test
	void testProductParametersAllExceptIdAndCoupon() {
		Product product = new Product( "IntelI7", INTEL, "foto.png", 250, "16 core cpu", CPU, cpuParameterList);

		addProductParameters();
		
		if(
		product.getName().equals("IntelI7") &&
		product.getBrand().equals(INTEL) &&
		product.getPhoto().equals("foto.png") &&
		product.getPrice() ==250 &&
		product.getCategory().equals(CPU) && 
		product.getProductParameters().equals(cpuParameterList) && 
		product.getDescription().equals("16 core cpu") ) {
		
		}
	}
	@Test
	void testProductParametersAllExceptId() {
		Product product = new Product( "IntelI7", INTEL, "foto.png", 250, "16 core cpu", CPU, cpuParameterList,coupon1);

		addProductParameters();
		
		if(
		product.getName().equals("IntelI7") &&
		product.getDiscount().equals(coupon1) &&
		product.getBrand().equals(INTEL) &&
		product.getPhoto().equals("foto.png") &&
		product.getPrice() ==250 &&
		product.getCategory().equals(CPU) && 
		product.getProductParameters().equals(cpuParameterList) && 
		product.getDescription().equals("16 core cpu") ) {
		
		}
	}

	@Test
	void testProductParametersAll() {
		Product product = new Product((long) 5, "IntelI7", INTEL, "foto.png", 250, "16 core cpu", CPU, cpuParameterList,coupon1);

		addProductParameters();
		
		if(
		product.getId().equals((long)5) &&
		product.getName().equals("IntelI7") &&
		product.getDiscount().equals(coupon1) &&
		product.getBrand().equals(INTEL) &&
		product.getPhoto().equals("foto.png") &&
		product.getPrice() ==250 &&
		product.getCategory().equals(CPU) && 
		product.getProductParameters().equals(cpuParameterList) && 
		product.getDescription().equals("16 core cpu") ) {
		
		}
	}

	@Test
	void testGetId() {
		if (product.getId().equals((long) 5)) {
			assertTrue(true);

		} else {
			assertTrue(false);

		}
	}

	@Test
	void testSetId() {
		product.setId((long) 4);
		if (product.getId() == 4) {
			assertTrue(true);

		} else {
			assertTrue(false);

		}

	}

	@Test
	void testGetName() {
		if(product.getName()=="IntelI7"){
			assertTrue(true);
		}
		else {
			assertTrue(false);

		}
	}

	@Test
	void testSetName() {
		product.setName("Desktop Celeron G5905");
		if(product.getName()=="Desktop Celeron G5905"){
			assertTrue(true);
		}
		else {
			assertTrue(false);

		}
	}

	@Test
	void testGetDescription() {
		if(product.getDescription()=="16 core cpu"){
			assertTrue(true);
		}
		else {
			assertTrue(false);

		}
	}

	@Test
	void testSetDescription() {
		product.setDescription("6 core cpu");
		if(product.getDescription()=="6 core cpu"){
			assertTrue(true);
		}
		else {
			assertTrue(false);

		}

	}
	@Test
	void toStringTest() {
		if(product.toString().equals("Product [id=5, name=IntelI7, photo=foto.png, price=250.0, description=16 core cpu, category=CPU, parameters=]")) {
			assertTrue(true);
		}
		else {
			assertTrue(false);

		}
	}

}
