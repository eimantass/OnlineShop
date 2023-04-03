package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.ERoles.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user-access")
public class UserAccessController {
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
