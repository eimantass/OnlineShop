package lt.codeacademy.teamroom4.onlineshop.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Cart;
//This repository stores shopping carts
@Repository
public interface ShoppingCartRepository extends JpaRepository<Cart, Long>{
	//ShoppingCart findBySessionToken(String sessionToken);
	List<Cart> findByUserId(Long userId);
	@Query("from Cart c where c.ifActiveCart = 1 and c.user.id = :userId")
	List<Cart> findActiveCartsByUserId(@Param("userId") Long userId);
	@Query("from Cart c where c.ifActiveCart = 0 and c.user.id = :userId")


	List<Cart> findInactiveCartsByUserId(Long userId);
}