package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Role;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.User;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.RoleRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.UserRepository;

import lt.codeacademy.teamroom4.onlineshop.spring.security.jwt.JwtUtils;
import lt.codeacademy.teamroom4.onlineshop.spring.services.UserDetailsImpl;
import payload.request.LoginRequest;
import payload.request.SignupRequest;
import payload.response.JwtResponse;
import payload.response.MessageResponse;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.ERoles.*;
//This class handles user authentication
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	//Autowiring services, utils and repositories
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	JwtUtils jwtUtils;
	//Signing users
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt,
				userDetails.getId(),
				userDetails.getUsername(),
				userDetails.getEmail(),
				roles));
	}
	
	//Registering new users
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest){
		if(userRepository.existsByUsername(signupRequest.getUsername())){
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if(userRepository.existsByEmail(signupRequest.getEmail())){
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is in use!"));
		}

		User user = new User(signupRequest.getUsername(),
				signupRequest.getEmail(),
				encoder.encode(signupRequest.getPassword()));

		Set<String> strRoles = signupRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if(strRoles == null) {

			Role userRole = roleRepository.findByName(CUSTOMER).orElseThrow( () -> new RuntimeException("Error: Role is not found"));

			roles.add(userRole);
		}else {
			strRoles.forEach(role -> {
				switch(role) {
				case "admin":

					Role adminRole = roleRepository.findByName(ADMIN)
					.orElseThrow( () -> new RuntimeException("Error: Role is not found"));
					roles.add(adminRole);

					break;
				case "man":

					Role manRole = roleRepository.findByName(MANAGER)

					.orElseThrow( () -> new RuntimeException("Error: Role is not found"));
					roles.add(manRole);

					break;
				case "serman":

					Role sermanRole = roleRepository.findByName(SERVICEMANAGER)
					.orElseThrow( () -> new RuntimeException("Error: Role is not found"));
					roles.add(sermanRole);

					break;
				default:

					Role userRole = roleRepository.findByName(CUSTOMER)
					.orElseThrow( () -> new RuntimeException("Error: Role is not found"));
					roles.add(userRole);
				}
			});
		}
		user.setRoles(roles);
		userRepository.save(user);
		return ResponseEntity.ok(new MessageResponse("User registered successfully"));
	}
	
}
