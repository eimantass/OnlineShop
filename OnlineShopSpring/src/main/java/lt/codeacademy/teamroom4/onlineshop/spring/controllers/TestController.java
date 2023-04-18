package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Controller used for testing various functions. 
@RestController
@RequestMapping("/test")
public class TestController {
	@GetMapping("/hello")
	public String hello(@RequestParam(name = "name", defaultValue="World") String name) {
		return String.format("Hello, %s",name);
	
	}
}
