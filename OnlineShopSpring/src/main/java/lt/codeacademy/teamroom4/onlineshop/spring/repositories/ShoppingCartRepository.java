package lt.codeacademy.teamroom4.onlineshop.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.ShoppingCart;
//This repository stores shopping carts
@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long>{
	ShoppingCart findBySessionToken(String sessionToken);
}
