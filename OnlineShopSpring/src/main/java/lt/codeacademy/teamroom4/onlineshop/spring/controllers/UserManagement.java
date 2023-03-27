package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Customer;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.CustomerRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.services.CustomerService;

@RestController
@RequestMapping("/manage-customers")
public class UserManagement {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	CustomerService customerService;
	@GetMapping("/customers/all")
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@GetMapping("/customers/search/{searchName}")
	public Customer getCustomerByName(@PathVariable String searchName) {
		return customerService.findByName(searchName);
	}
}
