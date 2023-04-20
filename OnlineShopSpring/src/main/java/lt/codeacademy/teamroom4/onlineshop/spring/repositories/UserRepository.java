package lt.codeacademy.teamroom4.onlineshop.spring.repositories;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Role;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.User;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.ERoles;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.Roles;
//This repository stores users
@Repository
public interface UserRepository  extends JpaRepository<User, Long>{
	//Finds users by usernams
	Optional<User> findByUsername(String username);
	@Query("SELECT u FROM User u JOIN u.roles r WHERE r.name = ?1")
	List<User> findAllByRole(ERoles roleName);
	//Checks if user exists accordingly to username
	Boolean existsByUsername(String username);
	//Checks if user exists accordingly to email
	Boolean existsByEmail(String email);
}
