package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.User;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.UserRepository;

import static lt.codeacademy.teamroom4.onlineshop.spring.utils.ERoles.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user-access")
public class UserAccessController {
	
	@Autowired
	UserRepository userRepository;
	
	// Return all usersList
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	@GetMapping("/customer")
	@PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN') or hasRole('SERVICEMANAGER')" )
	public String userAccess() {
	return "Customer Content.";
	}
	@GetMapping("/manager")
	@PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
	public String managerAccess() {
	return "Moderator Board.";
	}
	@GetMapping("/service-manager")
	@PreAuthorize("hasRole('SERVICEMANAGER') or hasRole('ADMIN')")
	public String serviceManagerAccess() {
	return "Service Manager Board";
	}
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
}
