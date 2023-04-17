package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Transient
	Double totalPrice;
	
	@OneToMany( cascade = {CascadeType.ALL}, orphanRemoval = true)
	@JoinColumn(name = "Cart")
	private List<CartItem> items = new ArrayList<>();
	
	public Cart() {}
	
	public Cart(Double totalPrice, List<CartItem> items) {
		this.totalPrice = totalPrice;
		this.items = items;
	}
	
	public Cart(Long id, Double totalPrice, List<CartItem> items) {
		this.id = id;
		this.totalPrice = totalPrice;
		this.items = items;
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
	
	public Double getTotalPrice() {
		Double sum = 0.0;
		for(CartItem item : items) {
			sum = sum + item.getProduct().getPrice();
		}
		return sum;
	}
}
