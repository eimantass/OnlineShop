package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.CartItem;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Customer;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.CartItemRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.CustomerRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.services.ProductService;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands;

import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands.*;

@RestController
public class HomeController {
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	ProductService productService;
	
	@Autowired
	CartItemRepository krepselisRep;
	
	@GetMapping("/")
	public String startPage() {
		return "index";
	}
	
	@GetMapping("/products")
	public List<Product> getAllProduct(){
		return productService.getAllProducts();
	}
	@PostMapping("/add-customer")
	public Customer createCustomer(@RequestBody Customer customer) {
		Customer savedCustomer = customerRepository.save(customer);
		return savedCustomer;

	}
	@GetMapping("/cart")
	public CartItem getKrepselis() {
		return krepselisRep.findById(1L).get();
	}
	@GetMapping("/products/search/{searchName}")
	public Product getCustomerByName(@PathVariable String searchName) {
		return productService.findByName(searchName);
	}
	@GetMapping("/products/sort-by-name-asc")
	public List<Product> SortProductsByNameAsc() {
		return productService.sortByNameAsc();
	}
	@GetMapping("/products/sort-by-name-desc")
	public List<Product> SortProductsByNameDesc() {
		return productService.sortByNameDesc();
	}
	
	@GetMapping("/products/sort-by-price-asc")
	public List<Product> SortProductsByPriceAsc() {
		return productService.sortByNameAsc();
	}
	@GetMapping("/products/sort-by-price-desc")
	public List<Product> SortProductsByPriceDesc() {
		return productService.sortByPriceDesc();
	}
	@GetMapping("/products/sort-by-category-asc")
	public List<Product> SortProductsByCategoryAsc() {
		return productService.sortByCategoryAsc();
	}
	
	@GetMapping("/products/sort-by-category-desc")
	public List<Product> SortProductsByCategoryDesc() {
		return productService.sortByCategoryDesc();
	}
	@GetMapping("/products/filter-by-brand/{brand}")
	public List<Product> filterByBrand(@PathVariable Brands brand) {
		return productService.filterBrand(brand);
	}
	@GetMapping("/products/filter-by-max-price/{maxPrice}")
	public List<Product> filterByMaxPrice(@PathVariable Long maxPrice) {
		return productService.filterByMaxPrice(maxPrice);
	}
	@GetMapping("/products/filter-by-min-price/{minPrice}")
	public List<Product> filterByMinPrice(@PathVariable Long minPrice) {
		return productService.filterByMinPrice(minPrice);
	}
	@GetMapping("/products/filter-by-both-min-and-max-price/{minPrice}/{maxPrice}")
	public List<Product> filterByBothMinAndMaxPrice(@PathVariable Long minPrice, Long maxPrice) {
		return productService.filterByMinPrice(minPrice);
	}
}
