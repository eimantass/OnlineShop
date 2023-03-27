package lt.codeacademy.teamroom4.onlineshop.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
