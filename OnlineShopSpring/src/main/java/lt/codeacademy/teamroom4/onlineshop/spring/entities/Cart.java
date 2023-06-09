package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "cart")

public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Transient
	Double totalPrice;
	
	@ManyToOne(cascade = {CascadeType.MERGE},fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany( cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "Cart")
	private List<CartItem> items = new ArrayList<>();
	@Column
	Boolean ifActiveCart=true;
	

	public Cart() {
		this.ifActiveCart=true;
	}
	
	public Cart(Double totalPrice, List<CartItem> items) {
		this.totalPrice = totalPrice;
		this.items = items;
		this.ifActiveCart=true;
	}
	
	public Cart(Long id, Double totalPrice, List<CartItem> items) {
		this.id = id;
		this.totalPrice = totalPrice;
		this.items = items;
		this.ifActiveCart=true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}
	public void addItems(CartItem item) {
	this.items.add(item);
	}
	public void changeQuantity(int itemId,int quantity) {
	this.items.get(itemId).setQuantity(quantity);
	}

	public Double getTotalPrice() {
		Double sum = 0.0;
		for(CartItem item : items) {
			sum = sum + item.getProduct().getPrice()*item.getQuantity();
		}
		return sum;
	}

	public Cart(Long id, User user) {
		super();
		this.id = id;
		this.user = user;
	}

	public Cart(User user) {
		super();
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getIfActiveCart() {
		return ifActiveCart;
	}

	public void setIfActiveCart(Boolean ifActiveCart) {
		this.ifActiveCart = ifActiveCart;
	}

	
}
