package lt.codeacademy.teamroom4.onlineshop.spring.security.jwt;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AuthTokenFilterTest {

	@Test
	void testDoFilterInternalHttpServletRequestHttpServletResponseFilterChain() throws ServletException, IOException {
		 HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		 HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
		 FilterChain filterChain = Mockito.mock(FilterChain.class);
		 Mockito.when(request.getHeader("X-Auth-Token")).thenReturn("myAuthToken");
		 AuthTokenFilter filter = new AuthTokenFilter();
		 filter.doFilter(request, response, filterChain);
		 Mockito.verify(filterChain).doFilter(request, response);
	}

}
