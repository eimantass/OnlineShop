package lt.codeacademy.teamroom4.onlineshop.spring.repositories;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.User;

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
		boolean exist = underTest.existsByEmail(username);
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
