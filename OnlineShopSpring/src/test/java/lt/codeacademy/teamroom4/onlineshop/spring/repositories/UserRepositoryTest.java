package lt.codeacademy.teamroom4.onlineshop.spring.repositories;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.User;

@RunWith(SpringRunner.class)
@DataJpaTest
class UserRepositoryTest {
	@Autowired
	private UserRepository underTest;

	@Test
	void testFindByUsername() {
		String username = "username";
		User user = new User(username, "email@gmail.com", "password");
		underTest.save(user);
		Optional<User> find = underTest.findByUsername(username);	
	}

	@Test
	void testExistsByUsername() {
		String username = "username";
		User user = new User(username, "email@gmail.com", "password");
		underTest.save(user);
		boolean exist = underTest.existsByUsername(username);
		assertTrue(exist);
	}

	@Test
	void testExistsByEmail() {
		String email = "email@gmail.com";
		User user = new User("username", email, "password");
		underTest.save(user);
		boolean exist = underTest.existsByEmail(email);
		assertTrue(exist);
	}
}
