package lt.codeacademy.teamroom4.onlineshop.spring.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MapBindingResult;
@RunWith(SpringRunner.class)
@SpringBootTest
class ValidationErrorServiceTest {
	@Autowired
	ValidationErrorService validationErrorService;
	@Test
	void testValidate() {
		BindingResult bindingResult = new MapBindingResult(new HashMap<>(),"test");
			boolean ifTestpassed = true;

			if(validationErrorService.validate(bindingResult)!=null) {
				ifTestpassed = false;

			}
			assertTrue(ifTestpassed);
		}
	

}
