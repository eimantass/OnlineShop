package lt.codeacademy.teamroom4.onlineshop.spring.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Categories;
//This repository stores products
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByNameContainingIgnoreCase(String name);
	//Finds all brands
	@Query("SELECT DISTINCT brand FROM Product")
	List<Brands> findAllBrandsDistincts();
	//Filters products by price
	@Query("from Product where price between :min and :max")
	List<Product> search(Sort sort, @Param("min") double min, @Param("max") double max);
	//Does not work yet
	@Query("from Product where category = :category")
	List<Product> findAllWithCategory(@Param("category") Categories category);
}