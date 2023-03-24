package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Krepselis;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.KrepselisRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.services.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	KrepselisRepository krepselisRep;
	
	@GetMapping("/")
	public String startPage() {
		return "index";
	}
	
	@GetMapping("/products")
	public List<Product> getAllProduct(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/krepselis")
	public Krepselis getKrepselis() {
		return krepselisRep.findById(1L).get();
	}
	
	
}
