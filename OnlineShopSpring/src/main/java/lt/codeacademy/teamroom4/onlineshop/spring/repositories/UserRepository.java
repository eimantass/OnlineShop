package lt.codeacademy.teamroom4.onlineshop.spring.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.User;
//This repository stores users
@Repository
public interface UserRepository  extends JpaRepository<User, Long>{
	//Finds users by usernams
	Optional<User> findByUsername(String username);
	//Checks if user exists accordingly to username
	Boolean existsByUsername(String username);
	//Checks if user exists accordingly to email
	Boolean existsByEmail(String email);
}
