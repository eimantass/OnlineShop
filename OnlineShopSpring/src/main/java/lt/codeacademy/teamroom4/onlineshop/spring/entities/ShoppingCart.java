package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "shoppingcart")
public class ShoppingCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Temporal(TemporalType.DATE)
	Date date;
	
	@Transient
	Double totalPrice;
	
	@Transient
	int itemsNumber;
	
	@OneToMany(cascade = CascadeType.ALL)
	Collection<CartItem> cartItems;
	
	String tokenSession;
	
	public ShoppingCart() {
		cartItems = new ArrayList<CartItem>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTotalPrice() {
		Double sum = 0.0;
		for(CartItem item : cartItems) {
			sum = sum + item.getProduct().getPrice();
		}
		return sum;
	}


	public int getItemsNumber() {
		return cartItems.size();
	}

	

	public Collection<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Collection<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public String getTokenSession() {
		return tokenSession;
	}

	public void setTokenSession(String tokenSession) {
		this.tokenSession = tokenSession;
	}
	
	
}
