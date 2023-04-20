package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Table(name="purchase")
@Entity
public class Purchase {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column
	 private Long id;
	 
	 double price;

	@OneToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER, orphanRemoval = true)
	 @JoinColumn(name = "cart")
	 Cart cart;
	 
	public Purchase() {}
	
	public Purchase( Cart cart) {
		this.cart = cart;
	}
	
	public Purchase(Long id, double price, Cart cart) {
		this.id = id;
		this.price = price;
		this.cart = cart;
	}
	
	public Purchase(double price, Cart cart) {
		this.price = price;
		this.cart = cart;
	}

	public Purchase(Long id, Wallet wallet, Cart cart) {
		this.id = id;
		this.cart = cart;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

}
