package lt.codeacademy.teamroom4.onlineshop.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.CartItem;
// This repository stores and retrieves CartItems
@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
