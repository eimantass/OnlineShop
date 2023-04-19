package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Purchase {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private CartItem item;
	 private int quantity;
	 private double price;
	 private Wallet wallet;
	 
	 
	
	public Purchase() {}

	public Purchase(Long id, CartItem item, int quantity, double price,Wallet wallet) {
		this.id = id;
		this.item = item;
		this.quantity = quantity;
		this.price = price;
		this.wallet = wallet;
	 }

	public Purchase(CartItem item, int quantity, double price,Wallet wallet) {
		this.item = item;
		this.quantity = quantity;
		this.price = price;
		this.wallet = wallet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CartItem getItem() {
		return item;
	}

	public void setItem(CartItem item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return item.getSum();
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	
	
	
}
