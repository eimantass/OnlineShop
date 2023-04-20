package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class WishList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Transient
	Double totalPrice;
	
	@ManyToOne(cascade = {CascadeType.MERGE},fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany( cascade = {CascadeType.ALL},fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "Cart")
	private List<WishListItem> items = new ArrayList<>();
	
	public WishList() {}
	
	public WishList(Double totalPrice, List<WishListItem> items) {
		this.totalPrice = totalPrice;
		this.items = items;
	}
	
	public WishList(Long id, Double totalPrice, List<WishListItem> items) {
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

	public List<WishListItem> getItems() {
		return items;
	}

	public void setItems(List<WishListItem> items) {
		this.items = items;
	}
	public void addItems(WishListItem item) {
	this.items.add(item);
	}


	public WishList(Long id, User user) {
		super();
		this.id = id;
		this.user = user;
	}

	public WishList(User user) {
		super();
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
