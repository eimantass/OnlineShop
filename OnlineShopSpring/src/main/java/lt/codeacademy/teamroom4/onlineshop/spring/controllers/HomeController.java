package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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
//This class handles functions, which do not require authentication to use
@RestController
public class HomeController {
	//Autowiring services and repositories
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	ProductService productService;
	
	@Autowired
	CartItemRepository cartRep;
	
	//Shows the main start page
	@GetMapping("/")
	public String startPage() {
		return "index";
	}
	
	//Shows all products
	@GetMapping("/products")
	public List<Product> getAllProduct(){
		return productService.getAllProducts();
	}
	//Adds customers
	@PostMapping("/add-customer")
	public Customer createCustomer(@RequestBody Customer customer) {
		Customer savedCustomer = customerRepository.save(customer);
		return savedCustomer;

	}
	//Shows cart
	@GetMapping("/cart")
	public CartItem getCart() {
		return cartRep.findById(1L).get();
	}
	//Searches products by name
	@GetMapping("/products/search/{searchName}")
	public Product getCustomerByName(@PathVariable String searchName) {
		return productService.findByName(searchName);
	}
	//Sorts products by name
	@GetMapping("/products/sort-by-name-asc")
	public List<Product> SortProductsByNameAsc() {
		return productService.sortByNameAsc();
	}
	@GetMapping("/products/sort-by-name-desc")
	public List<Product> SortProductsByNameDesc() {
		return productService.sortByNameDesc();
	}
	
	//Sorts products by price
	@GetMapping("/products/sort-by-price-asc")
	public List<Product> SortProductsByPriceAsc() {
		return productService.sortByNameAsc();
	}
	@GetMapping("/products/sort-by-price-desc")
	public List<Product> SortProductsByPriceDesc() {
		return productService.sortByPriceDesc();
	}
	
	//Sorts products by category
	@GetMapping("/products/sort-by-category-asc")
	public List<Product> SortProductsByCategoryAsc() {
		return productService.sortByCategoryAsc();
	}
	
	@GetMapping("/products/sort-by-category-desc")
	public List<Product> SortProductsByCategoryDesc() {
		return productService.sortByCategoryDesc();
	}
	//Filters products by brand
	@GetMapping("/products/filter-by-brand/{brand}")
	public List<Product> filterByBrand(@PathVariable Brands brand) {
		return productService.filterBrand(brand);
	}
	//Filters products by max price
	
	@GetMapping("/products/filter-by-max-price/{maxPrice}")
	public List<Product> filterByMaxPrice(@PathVariable Long maxPrice) {
		return productService.filterByMaxPrice(maxPrice);
	}
	@GetMapping("/products/filter-by-min-price/{minPrice}")
	public List<Product> filterByMinPrice(@PathVariable Long minPrice) {
		return productService.filterByMinPrice(minPrice);
	}
	@GetMapping("/products/filter-by-both-min-and-max-price/{minPrice}/{maxPrice}")
	public List<Product> filterByBothMinAndMaxPrice(@PathVariable Long minPrice, @PathVariable Long maxPrice) {
		return productService.filterByMinAndMaxPrice(minPrice, maxPrice);
	}
	@GetMapping("/products/filter-by-cpu-socket")
	public List<Product> filterByCpuSocket(String[] cpuParameters) {
		ArrayList<String[]> intelI3parametersArray = new ArrayList<>();
		String[] intelI3CPUparameters = { "CPU_SOCKET,", "LGA1200" };
		intelI3parametersArray.add(intelI3CPUparameters);
		
		return productService.filterByCpuSocket(intelI3CPUparameters);
	}
}
