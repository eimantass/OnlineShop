package lt.codeacademy.teamroom4.onlineshop.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Customer;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Manager;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.CustomerRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ManagerRepository;

@Service
public class ManagerService {
	@Autowired
	private ManagerRepository managerRepository;

	public Manager findByName(String searchName) {
		searchName = searchName.toUpperCase();
		List<Manager> allCustomers = new ArrayList<Manager>();
		allCustomers.addAll(managerRepository.findAll());
		
		for(long i =1; i<=allCustomers.size();i++) {
			//Customer currentCustomer = customerRepository.getById(i);
			Manager currentManager = managerRepository.findById(i).orElseThrow(RuntimeException::new);
			if(currentManager.getFullName().toUpperCase().equals(searchName)){
				return (currentManager);
			}
		}
		//return customerRepository.findById((long) 1);
		return null;
		
	}
}
