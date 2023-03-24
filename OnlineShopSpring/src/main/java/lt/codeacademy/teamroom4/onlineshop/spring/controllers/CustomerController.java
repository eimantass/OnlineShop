package lt.codeacademy.teamroom4.onlineshop.spring.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Customer;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.CustomerRepository;

@RestController
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable Long id) {
		return customerRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	@PostMapping
	public Customer createCustomer(@RequestBody Customer customer) throws URISyntaxException {
		Customer savedCustomer = customerRepository.save(customer);
		return savedCustomer;

	}

	@PutMapping("/{id}")
	public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
		Customer currentCustomer = customerRepository.findById(id).orElseThrow(RuntimeException::new);
		currentCustomer.setFullName(customer.getFullName());
		currentCustomer.setNumber(customer.getNumber());
		currentCustomer.setEmail(customer.getEmail());
		currentCustomer.setPassword(customer.getPassword());
		currentCustomer.setMatchingPassword(customer.getMatchingPassword());
		return customerRepository.save(customer);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
		customerRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
