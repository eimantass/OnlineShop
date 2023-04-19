package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "wishlistitem")
public class WishListItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Temporal(TemporalType.DATE)
	Date date;
	
	@ManyToOne
	@Cascade({CascadeType.SAVE_UPDATE,CascadeType.PERSIST})
	@JoinColumn(name = "product_id" , referencedColumnName = "id")
	private Product product;
	

	

	public WishListItem() {}
	
	public WishListItem(Long id, Date date, Product product) {
		this.id = id;
		this.date = date;
		this.product = product;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
