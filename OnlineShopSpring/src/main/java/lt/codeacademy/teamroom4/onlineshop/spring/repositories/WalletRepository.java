package lt.codeacademy.teamroom4.onlineshop.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long>{
	List<Wallet> findAllByOrderByPriority();
}
