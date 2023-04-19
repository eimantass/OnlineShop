package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


//This is an cartItem entity
@Entity
public class WishListItem {
	//CartItem variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Temporal(TemporalType.DATE)
	Date date;
	
	@ManyToOne
	@Cascade({CascadeType.SAVE_UPDATE,CascadeType.PERSIST})
	@JoinColumn(name = "product_id" , referencedColumnName = "id")
	Product product;
	
	public WishListItem() {}
	
	public WishListItem( Date date, Product product) {
		this.date = date;
		this.product = product;
	}
	

	public WishListItem(Long id,  Date date, Product product) {
		this.id = id;
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
		WishListItem other = (WishListItem) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
