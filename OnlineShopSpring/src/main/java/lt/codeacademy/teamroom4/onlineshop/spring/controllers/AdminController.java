package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Admin;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Customer;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Manager;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.ServiceManager;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.AdminRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.CustomerRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ManagerRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ServiceRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.services.CustomerService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// In this class admins and other users(which require admin security level to edit) mapping are configured
@RestController
@RequestMapping("/admins")

public class AdminController {
	//Autowiring repositories
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private ManagerRepository managerRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ServiceRepository serviceRepsitory;
	
	//This function is used to get list of all admins
	@GetMapping
	public List<Admin> getAdmins() {
		return adminRepository.findAll();
	}

	//Here admins can be found by id 
	@GetMapping("/{id}")
	public Admin getAdmin(@PathVariable Long id) {
		return adminRepository.findById(id).orElseThrow(RuntimeException::new);
	}
//Here new admin accounts are created
	@PostMapping
	public Admin createAdmin(@RequestBody Admin admin) throws URISyntaxException {
		Admin savedAdmin = adminRepository.save(admin);
		return savedAdmin;

	}
//Here admin update operations are handled
	@PutMapping("/{id}")
	public Admin updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
		Admin currentAdmin = adminRepository.findById(id).orElseThrow(RuntimeException::new);
		currentAdmin.setFullName(admin.getFullName());
		currentAdmin.setEmail(admin.getEmail());
		currentAdmin.setPassword(admin.getPassword());
		currentAdmin.setMatchingPassword(admin.getMatchingPassword());
		return adminRepository.save(admin);
	}
//Here admins can be deleted
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAdmin(@PathVariable Long id) {
		adminRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	//Admins can delete customers here
	@DeleteMapping("/customers/delete/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
		customerRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	// Admins can get list of all managers here
	@GetMapping("/managers/all")
	public List<Manager> getManagers() {
		return managerRepository.findAll();
	}
	//Admins can delete managers here
	@DeleteMapping("/managers/{id}")
	public ResponseEntity<?> deleteManager(@PathVariable Long id) {
		managerRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	// Admins can find all service managers here
	@GetMapping("/service-managers/all")
	public List<ServiceManager> getServiceManagers() {
		return serviceRepsitory.findAll();
	}
	//Admins can delete service managers here
	@DeleteMapping("/service-managers/delete/{id}")
	public ResponseEntity<?> deleteServiceManager(@PathVariable Long id) {
		serviceRepsitory.deleteById(id);
		return ResponseEntity.ok().build();
		}
	
	
}
