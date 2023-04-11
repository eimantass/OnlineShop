package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "wishlist")
public class WishList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	private String sessionToken;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<WishListItem> items = new HashSet<WishListItem>();
	
	public WishList() {}
	
	public WishList(Long id, Date date, String sessionToken, Set<WishListItem> items) {
		this.id = id;
		this.date = date;
		this.sessionToken = sessionToken;
		this.items = items;
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

	public String getSessionToken() {
		return sessionToken;
	}

	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}

	public Set<WishListItem> getItems() {
		return items;
	}

	public void setItems(Set<WishListItem> items) {
		this.items = items;
	}
	
}
