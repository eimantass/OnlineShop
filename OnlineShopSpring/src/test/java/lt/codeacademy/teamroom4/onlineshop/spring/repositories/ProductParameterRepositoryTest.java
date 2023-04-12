package lt.codeacademy.teamroom4.onlineshop.spring.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.ProductParameters;

class ProductParameterRepositoryTest {
	
	@Autowired
	ProductParameterRepository rep;
	
	@Test
	void test() {
		rep.save(new ProductParameters());
	}

}
