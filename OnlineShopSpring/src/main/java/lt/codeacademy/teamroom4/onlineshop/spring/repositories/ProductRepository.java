package lt.codeacademy.teamroom4.onlineshop.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Coupon;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands;

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByNameContainingIgnoreCase(String name);
	
	@Query("SELECT DISTINCT brand FROM Product")
	List<Brands> findAllBrandsDistincts();
	@Query("SELECT MAX(discount) FROM Product") 
	Product findProductWithBiggestDiscount();
	@Query("SELECT * FROM `internetine-parduotuve`.product WHERE Price BETWEEN 100 AND 200")
	List<Product>  filterProductsByPrice();
}