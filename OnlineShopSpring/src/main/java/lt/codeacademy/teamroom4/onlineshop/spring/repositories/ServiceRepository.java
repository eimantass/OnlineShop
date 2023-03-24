package lt.codeacademy.teamroom4.onlineshop.spring.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.ServiceManager;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceManager, Long> {

}
