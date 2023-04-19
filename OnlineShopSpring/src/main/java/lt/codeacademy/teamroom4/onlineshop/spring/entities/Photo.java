package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Table(name="Photo")
@Entity
public class Photo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id; 
	
	private String name; 
	
	@Lob 
	private byte[] data;
	
	@OneToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "user")
	private Product product;
	
	public Photo() {}

	public Photo(String name, byte[] data) {
		this.name = name;
		this.data = data;
	}

	public Photo(Long id, String name, byte[] data, Product product) {
		this.id = id;
		this.name = name;
		this.data = data;
		this.product = product;
	}

	public Photo(Long id, String name, byte[] data) {
		this.id = id;
		this.name = name;
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


	
}
