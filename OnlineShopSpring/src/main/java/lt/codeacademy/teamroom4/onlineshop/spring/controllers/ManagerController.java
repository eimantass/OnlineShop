package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Manager;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ManagerRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerController {

	@Autowired
	private ManagerRepository managerRepository;

	@GetMapping
	public List<Manager> getManagers() {
		return managerRepository.findAll();
	}

	@GetMapping("/{id}")
	public Manager getManagers(@PathVariable Long id) {
		return managerRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	@PostMapping
	public Manager createManagers(@RequestBody Manager manager) throws URISyntaxException {
		Manager savedManager = managerRepository.save(manager);
		return savedManager;

	}

	@PutMapping("/{id}")
	public Manager updateManagers(@PathVariable Long id, @RequestBody Manager manager) {
		Manager currentManager = managerRepository.findById(id).orElseThrow(RuntimeException::new);
		currentManager.setFullName(manager.getFullName());
		currentManager.setEmail(manager.getEmail());
		currentManager.setPassword(manager.getPassword());
		currentManager.setMatchingPassword(manager.getMatchingPassword());
		return managerRepository.save(manager);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteManagers(@PathVariable Long id) {
		managerRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
