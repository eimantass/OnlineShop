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
	 @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.DETACH})
	 @JoinColumn(name = "cartItem_id", referencedColumnName = "id")
	 private CartItem item;
	 @Column
	 private int quantity;
	 @Column
	 private double price;
	 @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.DETACH})
	 @JoinColumn(name = "purchase_id", referencedColumnName = "id")
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
