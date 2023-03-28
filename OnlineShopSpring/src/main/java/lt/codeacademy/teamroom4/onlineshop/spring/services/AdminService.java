package lt.codeacademy.teamroom4.onlineshop.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Admin;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Manager;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.AdminRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ManagerRepository;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;

	public Admin findByName(String searchName) {
		searchName = searchName.toUpperCase();
		List<Admin> allAdmin = new ArrayList<Admin>();
		allAdmin.addAll(adminRepository.findAll());
		
		for(long i =1; i<=allAdmin.size();i++) {
			//Customer currentCustomer = customerRepository.getById(i);
			Admin currentAdmin = adminRepository.findById(i).orElseThrow(RuntimeException::new);
			if(currentAdmin.getFullName().toUpperCase().equals(searchName)){
				return (currentAdmin);
			}
		}
		//return customerRepository.findById((long) 1);
		return null;
		
	}
}
