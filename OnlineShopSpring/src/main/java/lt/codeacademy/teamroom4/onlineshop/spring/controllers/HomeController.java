package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String startPage() {
		return "index";
	}
}
