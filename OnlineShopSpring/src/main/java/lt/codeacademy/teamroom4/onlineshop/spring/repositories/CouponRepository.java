package lt.codeacademy.teamroom4.onlineshop.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Coupon;
//This repository stores and retrieves coupons
@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {
	
	@Query("SELECT DISTINCT c FROM Coupon c where c.discount=(SELECT MAX(discount) From Coupon)")
	Coupon findMax();

}
