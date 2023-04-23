package lt.codeacademy.teamroom4.onlineshop.spring.security.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class JwtUtilsTest {
	
	@Value("root")
    private String jwtSecret;

	@Value("86400000")
    private int jwtExpirationMs;

 

    //@InjectMocks
  

//	@Test
//	void testGetUserNameFromJwtToken() {
//		 when(jwtUtil.getUserNameFromJwtToken(jwtToken)).thenReturn("testuser");
//	     String username = jwtUtil.getUserNameFromJwtToken(jwtToken);
//	     assertEquals(username, "testuser");
//	    
//	}
//
//	@Test
//	void testValidateJwtToken() throws SignatureException {
//		 boolean isValid = jwtUtil.validateJwtToken(jwtToken);
//	        assertTrue(isValid);
//	        String invalidToken = "invalidtoken";
//	        boolean isInvalid = jwtUtil.validateJwtToken(invalidToken);
//	        assertFalse(isInvalid);
//	        String expiredToken = jwtUtil.generateJwtToken(authentication);
//	        try {
//	            jwtUtil.validateJwtToken(expiredToken);
//	        } catch (Exception e) {
//	            assertTrue(e instanceof ExpiredJwtException);
//	        }
//	        String malformedToken = "malformedtoken";
//	        try {
//	            jwtUtil.validateJwtToken(malformedToken);
//	        } catch (Exception e) {
//	            assertTrue(e instanceof MalformedJwtException);
//	        }
//	}

}
