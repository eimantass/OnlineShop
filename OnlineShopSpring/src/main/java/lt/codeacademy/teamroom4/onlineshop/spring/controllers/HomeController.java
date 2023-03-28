package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Cart;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Customer;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.CartRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.services.ProductService;

@RestController
public class HomeController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CartRepository krepselisRep;
	
	@GetMapping("/")
	public String startPage() {
		return "index";
	}
	
	@GetMapping("/products")
	public List<Product> getAllProduct(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/cart")
	public Cart getKrepselis() {
		return krepselisRep.findById(1L).get();
	}
	@GetMapping("/products/search/{searchName}")
	public Product getCustomerByName(@PathVariable String searchName) {
		return productService.findByName(searchName);
	}
	@GetMapping("/products/sort-by-name")
	public Product SortProductsByName(@PathVariable String searchName) {
		return productService.findByName(searchName);
	}
}
