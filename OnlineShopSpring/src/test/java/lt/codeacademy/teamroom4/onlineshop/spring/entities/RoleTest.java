package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import lt.codeacademy.teamroom4.onlineshop.spring.utils.ERoles;

import static lt.codeacademy.teamroom4.onlineshop.spring.utils.ERoles.*;

class RoleTest {
	
	List<Role> roles = List.of(new Role(ADMIN), new Role(CUSTOMER), new Role(MANAGER), new Role(SERVICEMANAGER));
	Role role = new Role(1, ADMIN);
	Set<ERoles> eroles = Set.of(ADMIN,CUSTOMER,MANAGER,SERVICEMANAGER);
			//new HashSet<>();

	@Test
	void testRole() {
		boolean ifTestSuccesfull =true;
		if(role == null) {
			ifTestSuccesfull = false;
		}
			assertTrue(ifTestSuccesfull);
	}

	@Test
	void testRoleERoles() {
		if(eroles.contains(ADMIN)&&eroles.contains(CUSTOMER)&&eroles.contains(MANAGER)&&eroles.contains(SERVICEMANAGER)) {
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
		boolean ifTestSuccesfull =true;

		if(!role.getName().equals(ADMIN)) {
			ifTestSuccesfull = false;

		}
		assertTrue(ifTestSuccesfull);

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
