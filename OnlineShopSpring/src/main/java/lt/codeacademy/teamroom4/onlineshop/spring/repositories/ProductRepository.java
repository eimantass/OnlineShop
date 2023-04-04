package lt.codeacademy.teamroom4.onlineshop.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByNameContainingIgnoreCase(String name);
}
