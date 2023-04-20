package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import static lt.codeacademy.teamroom4.onlineshop.spring.utils.ERoles.MANAGER;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import lt.codeacademy.teamroom4.onlineshop.spring.config.SecurityConfig;

class UserTest {
	//Set<Role> roles = new HashSet<>();
	//Role role = new Role(MANAGER);
	//Wallet wal = new Wallet();
	//User user = new User(1L,"manager", "manager@gmail.com", SecurityConfig.passwordEncoder().encode("manager"), 6465456, wal, roles);
	
	@Test
	void testUser() {
		User user = new User();
	     user.setId(1L);
	     user.setUsername("John");
	     user.setEmail("john@example.com");
	     user.setPassword("pass");

	     assertEquals(1L, user.getId());
	     assertEquals("John", user.getUsername());
	     assertEquals("john@example.com", user.getEmail());
	     assertEquals("pass", user.getPassword());
	}

//	@SuppressWarnings("unlikely-arg-type")
//	@Test
//	void testUserLongStringStringStringSetOfRole() {
//		User us = new User((long)5, "user", "user@gmail.com", "user123", roles);
//		if(
//			us.getId().equals((long)5) && 
//			us.getUsername().equals("user") &&
//			us.getEmail().equals("user@gmail.com") &&
//			us.getPassword().equals("user123") &&
//			us.getRoles().equals(MANAGER)){
//			assertTrue(true);
//		}else {
//			assertTrue(false);
//		}
//	}

//	@Test
//	void testUserStringStringStringSetOfRole() {
//		User us = new User( "user", "user@gmail.com", "user123", roles);
//		if(
//			us.getUsername().equals("user") &&
//			us.getEmail().equals("user@gmail.com") &&
//			us.getPassword().equals("user123") &&
//			us.getRoles().equals(MANAGER)){
//			assertTrue(true);
//		}else {
//			assertTrue(false);
//		}
//	}

//	@Test
//	void testUserStringStringString() {
//		User us = new User( "user", "user@gmail.com", "user123");
//		if(
//			us.getUsername().equals("user") &&
//			us.getEmail().equals("user@gmail.com") &&
//			us.getPassword().equals("user123")) {
//			assertTrue(true);
//		}else {
//			assertTrue(false);
//		}
//	}

//	@SuppressWarnings("unlikely-arg-type")
//	@Test
//	void testUserStringStringStringLongDoubleSetOfRole() {
//		User us = new User( "user", "user@gmail.com", "user123", 46464, wal, roles);
//		if(
//			us.getUsername().equals("user") &&
//			us.getEmail().equals("user@gmail.com") &&
//			us.getPassword().equals("user123") &&
//			us.getNumber() == 46464 &&
//			us.getMoney().getCurrentBalance() == 456.35 &&
//			us.getRoles().equals(MANAGER)){
//			assertTrue(true);
//		}else {
//			assertTrue(false);
//		}
//	}
//
//	@SuppressWarnings("unlikely-arg-type")
//	@Test
//	void testUserLongStringStringStringLongDoubleSetOfRole() {
//		User us = new User((long)5, "user", "user@gmail.com", "user123", 46464, wal, roles);
//		if(
//			us.getId().equals((long)5) && 
//			us.getUsername().equals("user") &&
//			us.getEmail().equals("user@gmail.com") &&
//			us.getPassword().equals("user123") &&
//			us.getNumber() == 46464 &&
//			us.getMoney().getCurrentBalance() == 456.35 &&
//			us.getRoles().equals(MANAGER)){
//			assertTrue(true);
//		}else {
//			assertTrue(false);
//		}
//	}

	@Test
	void testGetId() {
		 User user = new User();
	     user.setId(1L);
	     assertEquals(1L, user.getId());
	}

	@Test
	void testSetId() {
		User user = new User();
        user.setId(1L);
        assertEquals(1L, user.getId());
	}

	@Test
	void testGetUsername() {
		User user = new User();
        user.setUsername("username");
        assertEquals("username", user.getUsername());
	}

	@Test
	void testSetUsername() {
		User user = new User();
        user.setUsername("username");
        assertEquals("username", user.getUsername());
	}

	@Test
	void testGetEmail() {
		User user = new User();
        user.setEmail("username@gmail.com");
        assertEquals("username@gmail.com", user.getEmail());
	}

	@Test
	void testSetEmail() {
		User user = new User();
        user.setEmail("username@gmail.com");
        assertEquals("username@gmail.com", user.getEmail());
	}

	@Test
	void testGetPassword() {
		User user = new User();
        user.setPassword("pass");
        assertEquals("pass", user.getPassword());
	}

	@Test
	void testSetPassword() {
		User user = new User();
        user.setPassword("pass");
        assertEquals("pass", user.getPassword());
	}


	@Test
	void testGetNumber() {
		User user = new User();
        user.setNumber(454545);
        assertEquals(454545, user.getNumber());
	}

	@Test
	void testSetNumber() {
		User user = new User();
        user.setNumber(454545);
        assertEquals(454545, user.getNumber());
	}

	@Test
	void testGetMoney() {
		Wallet wallet = new Wallet();
		
		User user = new User();
        user.setMoney(wallet);
        assertEquals(wallet.getCurrentBalance(), user.getMoney());
	}

//	@Test
//	void testSetMoney() {
//		user.setMoney(wal.setCurrentBalance(45.32));
//		if(user.getMoney().getCurrentBalance() ==  45.32) {
//			assertTrue(true);
//		}else {
//			assertTrue(false);
//		}
//	}

}
