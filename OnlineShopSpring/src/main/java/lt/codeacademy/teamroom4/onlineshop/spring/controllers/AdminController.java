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

@RestController
@RequestMapping("/admins")

public class AdminController {
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private ManagerRepository managerRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ServiceRepository serviceRepsitory;
	
	@GetMapping
	public List<Admin> getAdmins() {
		return adminRepository.findAll();
	}


	@GetMapping("/{id}")
	public Admin getAdmin(@PathVariable Long id) {
		return adminRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	@PostMapping
	public Admin createAdmin(@RequestBody Admin admin) throws URISyntaxException {
		Admin savedAdmin = adminRepository.save(admin);
		return savedAdmin;

	}

	@PutMapping("/{id}")
	public Admin updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
		Admin currentAdmin = adminRepository.findById(id).orElseThrow(RuntimeException::new);
		currentAdmin.setFullName(admin.getFullName());
		currentAdmin.setEmail(admin.getEmail());
		currentAdmin.setPassword(admin.getPassword());
		currentAdmin.setMatchingPassword(admin.getMatchingPassword());
		return adminRepository.save(admin);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAdmin(@PathVariable Long id) {
		adminRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	// Managing Customers
	@DeleteMapping("/customers/delete/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
		customerRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	// Managing Managers
	@GetMapping("/managers/all")
	public List<Manager> getManagers() {
		return managerRepository.findAll();
	}
	@DeleteMapping("/managers/{id}")
	public ResponseEntity<?> deleteManager(@PathVariable Long id) {
		managerRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	// Managing ServiceManagement
	@GetMapping("/servicemanagers/all")
	public List<ServiceManager> getServiceManagers() {
		return serviceRepsitory.findAll();
	}
	@DeleteMapping("/servicemanagers/delete/{id}")
	public ResponseEntity<?> deleteServiceManager(@PathVariable Long id) {
		serviceRepsitory.deleteById(id);
		return ResponseEntity.ok().build();
		}
	
	
}
