package lt.codeacademy.teamroom4.onlineshop.spring.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ServiceRepository extends JpaRepository<Service, Long> {

}
