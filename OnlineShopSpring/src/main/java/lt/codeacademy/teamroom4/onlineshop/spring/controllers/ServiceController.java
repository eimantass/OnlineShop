package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.ServiceManager;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ServiceRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {
@Autowired
private ServiceRepository serviceRepsitory;
@GetMapping
public List<ServiceManager> getCustomers() {
	return serviceRepsitory.findAll();
}

@GetMapping("/{id}")
public ServiceManager getCustomer(@PathVariable Long id) {
	return serviceRepsitory.findById(id).orElseThrow(RuntimeException::new);
}

@PostMapping
public ServiceManager createCustomer(@RequestBody ServiceManager manager) throws URISyntaxException {
	ServiceManager savedAdmin = serviceRepsitory.save(manager);
	return savedAdmin;

}

@PutMapping("/{id}")
public ServiceManager updateCustomer(@PathVariable Long id, @RequestBody ServiceManager manager) {
	ServiceManager currentAdmin = serviceRepsitory.findById(id).orElseThrow(RuntimeException::new);
	currentAdmin.setFullName(manager.getFullName());
	currentAdmin.setEmail(manager.getEmail());
	currentAdmin.setPassword(manager.getPassword());
	currentAdmin.setMatchingPassword(manager.getMatchingPassword());
	return serviceRepsitory.save(manager);
}

@DeleteMapping("/{id}")
public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
	serviceRepsitory.deleteById(id);
	return ResponseEntity.ok().build();
	}

}
