package lt.codeacademy.teamroom4.onlineshop.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByNameContainingIgnoreCase(String name);
	
	@Query("SELECT DISTINCT brand FROM Product")
	List<Brands> findAllBrandsDistincts();
}