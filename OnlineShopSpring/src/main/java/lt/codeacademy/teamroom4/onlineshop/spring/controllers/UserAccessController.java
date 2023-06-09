package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.codeacademy.teamroom4.onlineshop.spring.config.SecurityConfig;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Role;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.User;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.RoleRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.UserRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.ERoles;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.Roles;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.ERoles.*;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands.*;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Categories.*;

import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//This controller handles user access accordingly to roles
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user-access")
public class UserAccessController {
	
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
    private RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	// Return all usersList
	@GetMapping("/customers")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	// Get a single user by ID
	@GetMapping("/customers/{id}")
	public User getUserById(@PathVariable Long id) {
	    return userRepository.findById(id).orElseThrow();
	}
	@GetMapping("/customers-by-role/{roleName}")
	public List<User> getUserByRole(@PathVariable ERoles roleName) {
		//Set<Role> role =  userRepository.findById(id).orElseThrow().getRoles();
	    return userRepository.findAllByRole(roleName);
	}
	// Update an existing user
	@PutMapping("/customer/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User UpdatedUser) {
	    log.info(UpdatedUser.toString());
	    Set<Role> roles =new HashSet<>();
	    roles.addAll(UpdatedUser.getRoles());
	    //roles.addAll(roleRepository.findAll());
		return userRepository.findById(id)
	    	.map(user -> {
		        user.setUsername(UpdatedUser.getUsername());
		        user.setEmail(UpdatedUser.getEmail());
		        if(UpdatedUser.getPassword()!="") {
		        user.setPassword(SecurityConfig.passwordEncoder().encode(UpdatedUser.getPassword()));}
		        user.getRoles().addAll(roles);
		        user.setNumber(UpdatedUser.getNumber());
		        user.setMoney(UpdatedUser.getMoney());
		        // user.setRoles(UpdatedUser.getRoles());
		        User savedUser = userRepository.save(user);
		        log.info(null);
                log.info("User with id {} updated successfully: {}", id, savedUser);
                return savedUser;
		    }).orElseThrow(() -> {
                log.error("User with id {} not found for update", id);
                return new RuntimeException("User with id " + id + " not found for update");
            });
		}
	// Get all roles
    @GetMapping("/roles")
    public List<Role> getRoles() {
        List<Role> roles = roleRepository.findAll();
        return roles;
    }
    
	// Get role by userID
	@GetMapping("/role/{id}")
	public Set<Role> getCustomerRoleById(@PathVariable Long id) {
	    return userRepository.findById(id).orElseThrow().getRoles();
	}
	
	//Delete a user by ID
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
	    return userRepository.findById(id).map(user -> {
	        userRepository.delete(user);
	        return ResponseEntity.ok().build();
	    }).orElseThrow();
	}
	@PostMapping("/customers/create")
	public User createUser(@RequestBody User user) throws URISyntaxException {
		User savedUser = userRepository.save(user);
		return savedUser;}
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
