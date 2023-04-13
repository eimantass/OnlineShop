package lt.codeacademy.teamroom4.onlineshop.spring.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import lt.codeacademy.teamroom4.onlineshop.spring.repositories.UserRepository;

class UserDetailsServiceImplTest {
	
	@Mock
	private UserRepository rep;
	private UserDetailsServiceImpl underTest;
	

	@Test
	void testLoadUserByUsername() {
		
	}

}
