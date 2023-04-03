package lt.codeacademy.teamroom4.onlineshop.spring.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
