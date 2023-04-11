package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import lt.codeacademy.teamroom4.onlineshop.spring.utils.ERoles;

import static lt.codeacademy.teamroom4.onlineshop.spring.utils.ERoles.*;

class RoleTest {
	
	List<Role> roles = List.of(new Role(ADMIN), new Role(CUSTOMER), new Role(MANAGER), new Role(SERVICEMANAGER));
	Role role = new Role(1, ADMIN);
	Set<ERoles> eroles = new HashSet<>();

	@Test
	void testRole() {
		if(role == null) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testRoleERoles() {
		if(eroles == null) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetId() {
		if(role.getId().equals(1)) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetId() {
		role.setId(4);
		if(role.getId()==4) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testGetName() {
		if(role.getName().equals(MANAGER)) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	void testSetName() {
		role.setName(ADMIN);
		if(role.getName()== ADMIN) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

}
