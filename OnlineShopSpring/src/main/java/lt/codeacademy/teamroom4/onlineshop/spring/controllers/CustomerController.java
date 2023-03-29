package lt.codeacademy.teamroom4.onlineshop.spring.controllers;


import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Customer;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.CustomerRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.services.CustomerService;
//This class handles customer controllers
@RestController
@RequestMapping("/customers")
public class CustomerController {
	//Autowiring repositories
	@Autowired
	private CustomerRepository customerRepository;
	//All customers are shown here
	@GetMapping("/all")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Customer> getAllCustomers() {
	    return customerRepository.findAll();
	}
	//Here customers can be found by id
	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable Long id) {
		return customerRepository.findById(id).orElseThrow(RuntimeException::new);
	}
	//Here customer data can be updated
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
}
