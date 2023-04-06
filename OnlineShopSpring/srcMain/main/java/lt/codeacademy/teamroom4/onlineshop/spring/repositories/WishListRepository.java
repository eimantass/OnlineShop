package lt.codeacademy.teamroom4.onlineshop.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.WishList;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Long> {
	WishList findBySessionToken(String sessionToken);
}
