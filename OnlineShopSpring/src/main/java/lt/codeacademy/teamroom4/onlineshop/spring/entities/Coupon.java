package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
//This is an Coupon entity
@Entity
public class Coupon {
	// Coupon variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	int discount;
	@Transient
	boolean isDiscount;
	public Long getId() {
		return id;
	}
	// Coupon constructors
	public Coupon(int discount) {
		this.discount = discount;
	}

	public Coupon() {
	}

	public Coupon(Long id, int discount) {
		super();
		this.id = id;
		this.discount = discount;
	}

	public Coupon(Long id, int discount, boolean isDiscount) {
		super();
		this.id = id;
		this.discount = discount;
		this.isDiscount = isDiscount;
	}
	// Setters/Getters
	
	public int getDiscount() {
		return discount;
	}

	public boolean isDiscount() {
		if(this.discount != 0)
			return true;
		return false;
	}
	//Returns hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result =1;
		result = prime * result + discount;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	//Compares to another discount
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coupon other = (Coupon) obj;
		return discount == other.discount && Objects.equals(id, other.id) && isDiscount == other.isDiscount;
	}
}
