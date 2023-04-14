package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Category;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ProductRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.services.ProductService;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Categories;
//This controller handles product mappings
@RestController
@CrossOrigin(origins = "http://localhost:8081", allowCredentials = "true")
@RequestMapping("/products")

public class ProductController {
	
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);
	//Autowiring repositories and services
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductService productService;

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
	// Finding all categories
	@GetMapping("/categories")
	public List<String> getCategories() {
	    Categories[] categories = Categories.values(); // Get all values of the Categories enum
	    List<String> categoryList = new ArrayList<>(); // Create a list to hold the categories
	    for (Categories category : categories) {
	        categoryList.add(category.toString()); // Add the string representation of the enum value to the list
	    }
	    return categoryList; // Return the list of categories
	}
	//Finding all brands (Taking from ENUM)
	@GetMapping("/brands")
	public static List<String> getBrandsList() {
	    List<String> brandsList = new ArrayList<>();
	    for (Brands brand : Brands.values()) {
	        brandsList.add(brand.name());
	    }
	    return brandsList;
		}
//Updating products
	@PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setName(updatedProduct.getName());
                    product.setBrand(updatedProduct.getBrand());
                    product.setCategory(updatedProduct.getCategory());
                    product.setPrice(updatedProduct.getPrice());
                    product.setDescription(updatedProduct.getDescription());
                    product.setPhoto(updatedProduct.getPhoto());
                    product.setDiscount(updatedProduct.getDiscount());
                    Product savedProduct = productRepository.save(product);
                    log.info(null);
                    log.info("Product with id {} updated successfully: {}", id, savedProduct);
                    return savedProduct;
                })
                .orElseThrow(() -> {
                    log.error("Product with id {} not found for update", id);
                    return new RuntimeException("Product with id " + id + " not found for update");
                });
    }
//Deleting products
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
		productRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
}
