package lt.codeacademy.teamroom4.onlineshop.spring.security.jwt;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.security.SignatureException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
@SpringBootTest
class JwtUtilsTest {
	
	@Value("${axios-post.app.jwtSecret}")
    private String jwtSecret;

	@Value("${axios-post.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    @Autowired
    private JwtUtils jwtUtils;

    @InjectMocks
    @Autowired
    private JwtUtils jwtUtil;
    @Autowired
    private String jwtToken;
    
    private Authentication authentication;

	@Test
	void testGetUserNameFromJwtToken() {
		 when(jwtUtils.getUserNameFromJwtToken(jwtToken)).thenReturn("testuser");
	     String username = jwtUtil.getUserNameFromJwtToken(jwtToken);
	     assertEquals(username, "testuser");
	    
	}

	@Test
	void testValidateJwtToken() throws SignatureException {
		 boolean isValid = jwtUtil.validateJwtToken(jwtToken);
	        assertTrue(isValid);
	        String invalidToken = "invalidtoken";
	        boolean isInvalid = jwtUtil.validateJwtToken(invalidToken);
	        assertFalse(isInvalid);
	        String expiredToken = jwtUtil.generateJwtToken(authentication);
	        try {
	            jwtUtil.validateJwtToken(expiredToken);
	        } catch (Exception e) {
	            assertTrue(e instanceof ExpiredJwtException);
	        }
	        String malformedToken = "malformedtoken";
	        try {
	            jwtUtil.validateJwtToken(malformedToken);
	        } catch (Exception e) {
	            assertTrue(e instanceof MalformedJwtException);
	        }
	}

}
