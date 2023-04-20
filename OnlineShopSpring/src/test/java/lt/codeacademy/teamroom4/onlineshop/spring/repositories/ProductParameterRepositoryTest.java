package lt.codeacademy.teamroom4.onlineshop.spring.repositories;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.ProductParameters;

@RunWith(SpringRunner.class)
@DataJpaTest
class ProductParameterRepositoryTest {
	
	@Autowired
	ProductParameterRepository rep;
	
	@Test
	void test() {
		rep.save(new ProductParameters());
	}

}
