package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Line {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	int amount;
	
	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "product_id" , referencedColumnName = "id")
	Product product;
	
	public Line() {}
	
	public Line(Product product,int amount) {
		this.amount = amount;
		this.product = product;
	}

	public Line(Long id, int amount, Product product) {
		this.id = id;
		this.amount = amount;
		this.product = product;
	}
	
	public double getSuma() {
		return product.price * amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Eilute [id=" + id + ", kiekis=" + amount + ", preke=" + product + "]";
	}
	
	
	
	
}
