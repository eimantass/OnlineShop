package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


//This is an cartItem entity
@Entity
@Table(name = "cartitem")
public class CartItem {
	//CartItem variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	int quantity;
	
	@Temporal(TemporalType.DATE)
	Date date;
	
	@ManyToOne
	@Cascade({CascadeType.SAVE_UPDATE,CascadeType.PERSIST})
	@JoinColumn(name = "product_id" , referencedColumnName = "id")
	Product product;
	
	public CartItem() {}
	
	public CartItem(int quantity, Date date, Product product) {
		this.quantity = quantity;
		this.date = date;
		this.product = product;
	}
	

	public CartItem(Long id, int quantity, Date date, Product product) {
		this.id = id;
		this.quantity = quantity;
		this.date = date;
		this.product = product;
	}

	// Getters/Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getSum() {
		return quantity * getProduct().getPrice();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	//Returns object hash code
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	//Compares to another CartItem
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItem other = (CartItem) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
