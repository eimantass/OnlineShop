package lt.codeacademy.teamroom4.onlineshop.spring.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Roles.*;
class RolesTest {

	@Test
	void test() {
	boolean ifTestpassed = false;

	if(ADMIN == "ADMIN" && CUSTOMER == "CUSTOMER" && MANAGER == "MANAGER" && SERVICEMANAGER == "SERVICEMANAGER") {
		ifTestpassed = true;	
	}
	}

}
