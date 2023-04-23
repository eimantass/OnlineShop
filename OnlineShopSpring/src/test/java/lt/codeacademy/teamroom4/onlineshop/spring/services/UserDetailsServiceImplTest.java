package lt.codeacademy.teamroom4.onlineshop.spring.services;

import static lt.codeacademy.teamroom4.onlineshop.spring.utils.ERoles.ADMIN;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import lt.codeacademy.teamroom4.onlineshop.spring.config.SecurityConfig;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Role;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.User;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.UserRepository;
@RunWith(SpringRunner.class)
@SpringBootTest
class UserDetailsServiceImplTest {
	
	//@Mock
	@Autowired
	private UserRepository userRep;
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImplTest;
	

	@Test
	void testLoadUserByUsername() {
		User user = seedUser();
		userRep.save(user);
		UserDetailsImpl newUserDetailsImpl = UserDetailsImpl.build(user);		
		UserDetails userDetails = userDetailsServiceImplTest.loadUserByUsername(newUserDetailsImpl.getUsername());
		boolean ifTestpassed = true;
		if (userDetails == null) {
			ifTestpassed = false;
		}
		assertTrue(ifTestpassed);
	}

	private  User seedUser() {
		Set<Role> roles = new HashSet<>();
		roles.add(new Role(ADMIN));
		User user = new User((long)1,"admin", "admin@gmail.com", SecurityConfig.passwordEncoder().encode("administrator"),
				roles);
		return user;
	}

}
