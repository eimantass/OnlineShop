package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import static lt.codeacademy.teamroom4.onlineshop.spring.utils.ERoles.MANAGER;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import lt.codeacademy.teamroom4.onlineshop.spring.config.SecurityConfig;

class UserTest {
	Set<Role> roles = new HashSet<>();
	Role role = new Role(MANAGER);
	Wallet wal = new Wallet();
	User user = new User((long)5,"manager", "manager@gmail.com", SecurityConfig.passwordEncoder().encode("manager"), 6465456, wal, roles);
	
	@Test
	void testUser() {
		if(user == null) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	@Test
	void testUserLongStringStringStringSetOfRole() {
		User us = new User((long)5, "user", "user@gmail.com", "user123", roles);
		if(
			us.getId().equals((long)5) && 
			us.getUsername().equals("user") &&
			us.getEmail().equals("user@gmail.com") &&
			us.getPassword().equals("user123") &&
			us.getRoles().equals(MANAGER)){
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testUserStringStringStringSetOfRole() {
		User us = new User( "user", "user@gmail.com", "user123", roles);
		if(
			us.getUsername().equals("user") &&
			us.getEmail().equals("user@gmail.com") &&
			us.getPassword().equals("user123") &&
			us.getRoles().equals(MANAGER)){
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testUserStringStringString() {
		User us = new User( "user", "user@gmail.com", "user123");
		if(
			us.getUsername().equals("user") &&
			us.getEmail().equals("user@gmail.com") &&
			us.getPassword().equals("user123")) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	@Test
	void testUserStringStringStringLongDoubleSetOfRole() {
		User us = new User( "user", "user@gmail.com", "user123", 46464, wal, roles);
		if(
			us.getUsername().equals("user") &&
			us.getEmail().equals("user@gmail.com") &&
			us.getPassword().equals("user123") &&
			us.getNumber() == 46464 &&
			us.getMoney().getCurrentBalance() == 456.35 &&
			us.getRoles().equals(MANAGER)){
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	@Test
	void testUserLongStringStringStringLongDoubleSetOfRole() {
		User us = new User((long)5, "user", "user@gmail.com", "user123", 46464, wal, roles);
		if(
			us.getId().equals((long)5) && 
			us.getUsername().equals("user") &&
			us.getEmail().equals("user@gmail.com") &&
			us.getPassword().equals("user123") &&
			us.getNumber() == 46464 &&
			us.getMoney().getCurrentBalance() == 456.35 &&
			us.getRoles().equals(MANAGER)){
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetId() {
		if(user.getId().equals((long)5)) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetId() {
		user.setId((long)4);
		if(user.getId()==4) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetUsername() {
		if(user.getUsername().equals("manager")) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetUsername() {
		user.setUsername("user");
		if(user.getUsername()=="user") {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetEmail() {
		if(user.getEmail().equals("manager@gmail.com")) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetEmail() {
		user.setEmail("manager1@gmail.com");
		if(user.getUsername()=="manager1@gmail.com") {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetPassword() {
		if(user.getPassword().equals("manager")) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetPassword() {
		user.setPassword("manager");
		if(user.getPassword()=="manager") {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	@Test
	void testGetRoles() {
		if(user.getRoles().equals(MANAGER)) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetRoles() {
		user.setRoles(roles);
		if(user.getRoles() == roles ) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetNumber() {
		if(user.getNumber() == 6465456) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}	
	}

	@Test
	void testSetNumber() {
		user.setNumber(45445);
		if(user.getNumber() ==  45445) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetMoney() {
		if(user.getMoney().getCurrentBalance() == 454.4545) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}	
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
