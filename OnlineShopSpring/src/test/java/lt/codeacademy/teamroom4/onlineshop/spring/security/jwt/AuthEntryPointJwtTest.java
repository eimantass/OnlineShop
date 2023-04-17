package lt.codeacademy.teamroom4.onlineshop.spring.security.jwt;

import static org.mockito.Mockito.verify;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.AuthenticationException;

class AuthEntryPointJwtTest {
	
	 @Mock
	 private HttpServletRequest request;

	 @Mock
	 private HttpServletResponse response;

	 @Mock
	 private AuthenticationException authException;

	 @InjectMocks
	 private AuthEntryPointJwt authEntryPointJwt;

	@Test
	void testCommence() throws IOException,ServletException {
		MockitoAnnotations.openMocks(this);
	    authEntryPointJwt.commence(request, response, authException);
	    verify(response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized");
	}

}
