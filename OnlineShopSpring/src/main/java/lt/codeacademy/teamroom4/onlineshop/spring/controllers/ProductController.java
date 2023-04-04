package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ProductRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.services.ProductService;
//This controller handles product mappings
@RestController
@CrossOrigin(origins = "http://localhost:8081", allowCredentials = "true")
@RequestMapping("/products")

public class ProductController {
	//Autowiring repositories and services
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	@CrossOrigin(origins = "http://localhost:3000")
	public String index(ModelMap modelMap) {
		modelMap.put("product", productService.findAll());
		return "products/all";
	}
	//Finding all products
	 @GetMapping("/all")
	public List<Product> getProducts() {
		return productRepository.findAll();
	}
//Finding products by id
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable Long id) {
		return productRepository.findById(id).orElseThrow(RuntimeException::new);
	}
//Creating new products
	@PostMapping("/create")
	public Product createProduct(@RequestBody Product product) throws URISyntaxException {
		Product savedProduct = productRepository.save(product);
		return savedProduct;

	}
//Updating products
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
		Product currentProduct = productRepository.findById(id).orElseThrow(RuntimeException::new);
		currentProduct.setName(product.getName());
		currentProduct.setCategory(product.getCategory());
		currentProduct.setPrice(product.getPrice());
		currentProduct.setDescription(product.getDescription());
		currentProduct.setDiscount(product.getDiscount());
		return productRepository.save(product);
	}
//Deleting products
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
		productRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
}
