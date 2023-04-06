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
//This controller handles user access accordingly to roles
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user-access")
public class UserAccessController {
	
	@Autowired
	UserRepository userRepository;
	
	// Return all usersList
	@GetMapping("/customers")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	//Shows the content that is visible without logging in
	@GetMapping("/all")
	public String allAccess() {
		return "This is the Public content from UserAccessController! @GetMapping(\"/all\") ";
	}
	//Shows customer board
	@GetMapping("/customer")
	//@PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN') or hasRole('SERVICEMANAGER')" )
	public String userAccess() {
	return "This is the CustomerBoard from UserAccessController! @GetMapping(\"/customer\")";
	}
	//Shows manager board
	@GetMapping("/manager")
	//@PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
	public String managerAccess() {
	return "This is the Manager Board from UserAccessController! @GetMapping(\"/manager\")";
	}
	//Show Service Manager board
	@GetMapping("/service-manager")
	//@PreAuthorize("hasRole('SERVICEMANAGER') or hasRole('ADMIN')")
	public String serviceManagerAccess() {
	return "This is the ServiceManger Board from UserAccessController! @GetMapping(\"/service-manager\")";
	}
	//Shows admin board
	@GetMapping("/admin")
	//@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "This is the Admin Board from UserAccessController! @GetMapping(\"/admin\")";
	}
}
