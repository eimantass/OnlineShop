package lt.codeacademy.teamroom4.onlineshop.spring.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

class ERolesTest {

	@Test
	void test() {
		boolean ifTestpassed = true;
	ERoles eRoleAdmin= ERoles.ADMIN;
	ERoles eRoleCustomer= ERoles.CUSTOMER;
	ERoles eRoleManager= ERoles.MANAGER;
	ERoles eRoleServiceManager= ERoles.SERVICEMANAGER;
	if(!eRoleAdmin.equals(ERoles.ADMIN)&&!eRoleCustomer.equals(ERoles.CUSTOMER) &&!eRoleManager.equals(ERoles.SERVICEMANAGER)  &&!eRoleServiceManager.equals(ERoles.SERVICEMANAGER)) {
		ifTestpassed = false;
	}
	assertTrue(ifTestpassed);
	}

}
