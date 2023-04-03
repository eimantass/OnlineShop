package lt.codeacademy.teamroom4.onlineshop.spring.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Role;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.ERoles;


public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERoles name);
}
