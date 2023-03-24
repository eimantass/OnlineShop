package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ProductRepository;

@Controller
@RequestMapping("/customers")

public class ProductController {
	@Autowired
	private ProductRepository productRepository;

	@GetMapping
	public List<Product> getCustomers() {
		return productRepository.findAll();
	}

	@GetMapping("/{id}")
	public Product getCustomer(@PathVariable Long id) {
		return productRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	@PostMapping
	public Product createCustomer(@RequestBody Product customer) throws URISyntaxException {
		Product savedCustomer = productRepository.save(customer);
		return savedCustomer;

	}

	@PutMapping("/{id}")
	public Product updateCustomer(@PathVariable Long id, @RequestBody Product product) {
		Product currentProduct = productRepository.findById(id).orElseThrow(RuntimeException::new);
		currentProduct.setPavadinimas(product.getPavadinimas());
		currentProduct.setKategorija(product.getKategorija());
		currentProduct.setKaina(product.getKaina());
		currentProduct.setAprasymas(product.getAprasymas());
		return productRepository.save(product);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
		productRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
