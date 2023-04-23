package lt.codeacademy.teamroom4.onlineshop.spring.services;

import static lt.codeacademy.teamroom4.onlineshop.spring.utils.ERoles.ADMIN;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

import lt.codeacademy.teamroom4.onlineshop.spring.config.SecurityConfig;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Role;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.User;

class UserDetailsImplTest {

	
	private Collection<? extends GrantedAuthority> authorities;

	@Test
	void testUserDetailsImpl() {
		UserDetailsImpl userDetailsImplTest = new UserDetailsImpl((long) 1, "TestUser", "larry@hotmail.com",
				"SecretLibrary", authorities);
		boolean ifTestpassed = true;

		if (userDetailsImplTest.getEmail() == null || userDetailsImplTest.getUsername() == null
				|| userDetailsImplTest.getId() == 0) {
			ifTestpassed = false;

		}
		assertTrue(ifTestpassed);
	}

	@Test
	void testBuild() {
		User user = seedUser();
		UserDetailsImpl newUserDetailsImpl = UserDetailsImpl.build(user);
		boolean ifTestpassed = true;

		if (newUserDetailsImpl.getEmail() == null || newUserDetailsImpl.getUsername() == null) {
			ifTestpassed = false;

		}
		assertTrue(ifTestpassed);
	}

	 User seedUser() {
		Set<Role> roles = new HashSet<>();
		roles.add(new Role(ADMIN));
		User user = new User((long)1,"admin", "admin@gmail.com", SecurityConfig.passwordEncoder().encode("administrator"),
				roles);
		return user;
	}

	@Test
	void testGetAuthorities() {
		User user = seedUser();
		UserDetailsImpl newUserDetailsImpl = UserDetailsImpl.build(user);
		boolean ifTestpassed = true;

		if (newUserDetailsImpl.getAuthorities() == null) {
			ifTestpassed = false;

		}
		assertTrue(ifTestpassed);
	}

	@Test
	void testGetId() {
		User user = seedUser();
		UserDetailsImpl newUserDetailsImpl = UserDetailsImpl.build(user);
		boolean ifTestpassed = true;

		if (newUserDetailsImpl.getId() == null) {
			ifTestpassed = false;

		}
		assertTrue(ifTestpassed);
	}

	@Test
	void testGetEmail() {
		User user = seedUser();
		UserDetailsImpl newUserDetailsImpl = UserDetailsImpl.build(user);
		boolean ifTestpassed = true;

		if (newUserDetailsImpl.getEmail() == null) {
			ifTestpassed = false;

		}
		assertTrue(ifTestpassed);
	}

	@Test
	void testGetPassword() {
		User user = seedUser();
		UserDetailsImpl newUserDetailsImpl = UserDetailsImpl.build(user);
		boolean ifTestpassed = true;

		if (newUserDetailsImpl.getPassword() == null) {
			ifTestpassed = false;

		}
		assertTrue(ifTestpassed);
	}

	@Test
	void testGetUsername() {
		User user = seedUser();
		UserDetailsImpl newUserDetailsImpl = UserDetailsImpl.build(user);
		boolean ifTestpassed = true;

		if (newUserDetailsImpl.getUsername() == null) {
			ifTestpassed = false;

		}
		assertTrue(ifTestpassed);
	}

	@Test
	void testIsAccountNonExpired() {
		User user = seedUser();
		UserDetailsImpl newUserDetailsImpl = UserDetailsImpl.build(user);
		boolean ifTestpassed = true;

		if (newUserDetailsImpl.isAccountNonExpired() == false) {
			ifTestpassed = false;
		}
		assertTrue(ifTestpassed);
	}

	@Test
	void testIsAccountNonLocked() {
		User user = seedUser();
		UserDetailsImpl newUserDetailsImpl = UserDetailsImpl.build(user);
		boolean ifTestpassed = true;

		if (newUserDetailsImpl.isAccountNonLocked() == false) {
			ifTestpassed = false;
		}
		assertTrue(ifTestpassed);
	}

	@Test
	void testIsCredentialsNonExpired() {
		User user = seedUser();
		UserDetailsImpl newUserDetailsImpl = UserDetailsImpl.build(user);
		boolean ifTestpassed = true;

		if (newUserDetailsImpl.isCredentialsNonExpired() == false) {
			ifTestpassed = false;
		}
		assertTrue(ifTestpassed);
	}

	@Test
	void testIsEnabled() {
		User user = seedUser();
		UserDetailsImpl newUserDetailsImpl = UserDetailsImpl.build(user);
		boolean ifTestpassed = true;

		if (newUserDetailsImpl.isEnabled() == false) {
			ifTestpassed = false;
		}
		assertTrue(ifTestpassed);
	}
	@Test
	void hashCodeTest() {
		User user = seedUser();
		UserDetailsImpl newUserDetailsImpl = UserDetailsImpl.build(user);
		boolean ifTestpassed = true;
		if (newUserDetailsImpl.hashCode() == 0) {
			ifTestpassed = false;
		}
		assertTrue(ifTestpassed);
	}
	@Test
	void equalsTest() {
		User user = seedUser();
		UserDetailsImpl newUserDetailsImpl = UserDetailsImpl.build(user);
		UserDetailsImpl newUserDetailsImpl2 = UserDetailsImpl.build(user);
		boolean ifTestpassed = true;

		if (!newUserDetailsImpl.equals(newUserDetailsImpl2)) {
			ifTestpassed = false;
		}
		assertTrue(ifTestpassed);
	}
}
