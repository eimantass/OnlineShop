package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Table(name="purchase")
@Entity
public class Purchase {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column
	 private Long id;
	 
	 double price;
	
	 @JoinColumn()
	 private Wallet wallet;
	 @JoinColumn()
	 Cart cart;
	 
	public Purchase() {}
	
	public Purchase(Wallet wallet, Cart cart) {
		this.wallet = wallet;
		this.cart = cart;
	}
	
	public Purchase(Long id, double price, Wallet wallet, Cart cart) {
		this.id = id;
		this.price = price;
		this.wallet = wallet;
		this.cart = cart;
	}
	
	public Purchase(double price, Wallet wallet, Cart cart) {
		this.price = price;
		this.wallet = wallet;
		this.cart = cart;
	}

	public Purchase(Long id, Wallet wallet, Cart cart) {
		this.id = id;
		this.wallet = wallet;
		this.cart = cart;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public double getPrice() {
		return cart.getTotalPrice();
	}

	public void setPrice(double price) {
		this.price = cart.getTotalPrice();
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

}
