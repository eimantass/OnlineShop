package lt.codeacademy.teamroom4.onlineshop.spring.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.User;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.UserRepository;

//This class handles UserDetail loading and finding by id
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	//Autowiring UserRepository
	@Autowired
	UserRepository userRepository;
	//Loading accordingly to username
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow( () -> new UsernameNotFoundException("User Not found with username" + username));
		return UserDetailsImpl.build(user);
	}
	//Finding user by id
	public Optional<User> getById(long id) {
		return userRepository.findById(id);
	}

}