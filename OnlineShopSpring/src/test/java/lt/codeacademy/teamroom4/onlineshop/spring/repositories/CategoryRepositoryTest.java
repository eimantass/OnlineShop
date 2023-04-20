package lt.codeacademy.teamroom4.onlineshop.spring.repositories;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Category;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Categories.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class CategoryRepositoryTest {
	
	@Autowired
	CategoryRepository rep;
	
	@Test
	void test() {
		Category cat = new Category(1L, LAPTOPS);
		rep.save(cat);
	}

}
