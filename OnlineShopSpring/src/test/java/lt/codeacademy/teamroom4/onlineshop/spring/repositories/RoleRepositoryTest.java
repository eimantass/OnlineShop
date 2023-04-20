package lt.codeacademy.teamroom4.onlineshop.spring.repositories;

import static lt.codeacademy.teamroom4.onlineshop.spring.utils.ERoles.ADMIN;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.ERoles.CUSTOMER;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.ERoles.MANAGER;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.ERoles.SERVICEMANAGER;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Role;

@RunWith(SpringRunner.class)
@DataJpaTest
class RoleRepositoryTest {
	
	@Autowired
	RoleRepository rep;

	@Test
	void testFindByName() {
		Role role = new Role(1, ADMIN);
		rep.save(role);
		rep.findByName(SERVICEMANAGER);
	}

}
