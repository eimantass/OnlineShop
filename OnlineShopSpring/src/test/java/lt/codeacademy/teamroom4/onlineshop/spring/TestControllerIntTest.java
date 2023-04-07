package lt.codeacademy.teamroom4.onlineshop.spring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import lt.codeacademy.teamroom4.onlineshop.spring.controllers.TestController;
import lt.codeacademy.teamroom4.onlineshop.spring.services.UserDetailsServiceImpl;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TestController.class)
 class TestControllerIntTest {
	@Autowired
	private UserDetailsService userDetailsService;
 
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
	private MockMvc mvc;
	
	@Test
	void hello() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/hello");
		MvcResult result = mvc.perform(request).andReturn();
		assertEquals("Hello, World", result.getResponse().getContentAsString());
	}
	@Test
	 void testHelloWithName() throws Exception{
	mvc.perform(get("/hello?name=Larry"))
	.andExpect(content().string("Hello, Larry"));
	}
}
