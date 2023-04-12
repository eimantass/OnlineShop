package lt.codeacademy.teamroom4.onlineshop.spring.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Category;

class CategoryRepositoryTest {
	
	@Autowired
	CategoryRepository rep;
	
	@Test
	void test() {
		rep.save(new Category());
	}

}
