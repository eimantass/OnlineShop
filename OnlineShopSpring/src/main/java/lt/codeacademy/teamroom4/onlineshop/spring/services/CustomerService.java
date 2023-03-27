package lt.codeacademy.teamroom4.onlineshop.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Customer;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer findByName(String searchName) {
		searchName = searchName.toUpperCase();
		List<Customer> allCustomers = new ArrayList<Customer>();
		allCustomers.addAll(customerRepository.findAll());
		
		for(long i =1; i<=allCustomers.size();i++) {
			//Customer currentCustomer = customerRepository.getById(i);
			Customer currentCustomer = customerRepository.findById(i).orElseThrow(RuntimeException::new);
			if(currentCustomer.getFullName().toUpperCase().equals(searchName)){
				return (currentCustomer);
			}
		}
		//return customerRepository.findById((long) 1);
		return null;
		
		
		
	
	}
}
