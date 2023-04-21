package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Categories;
//This is an product entity
@Entity
@Table(name = "product")
public class Product {
	//Product variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	
	@OneToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "discount")
	private Coupon discount;
	@Enumerated(EnumType.STRING)
	@Column
	private Brands brand;

	//@OneToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "photo")
	private String photo;
	@Column
	private double price;
	@Column
	private String description;
	@Column
	private Long quantity;
	//@OneToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH}, fetch = FetchType.EAGER)
	//@JoinColumn(name = "category", referencedColumnName = "id")
	@Enumerated(EnumType.STRING)
	private Categories category;
	
	//@JsonManagedReference
	//@Transient
	//@Column
	//@ElementCollection()
	@OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.DETACH}, orphanRemoval = true)
	 @JoinColumn(name = "product_id", referencedColumnName = "id")
	Set<ProductParameters> productParameters = new HashSet<>();
	
	
	//Product constructors
	public Product() {
	}
	
	public Product(Long id) {
		this.id = id;
	}

	public Product(Long id, String name, Brands brand, String photo, double price, String description,
			Categories category) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.photo = photo;
		this.price = price;
		this.description = description;
		this.category = category;
	}

	public Product(String name, Brands brand, String photo, double price, String description, Categories category) {
		super();
		this.name = name;
		this.brand = brand;
		this.photo = photo;
		this.price = price;
		this.description = description;
		this.category = category;
	}
	
	public Product(Long id, String name, Brands brand, double price, String description, Categories category) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.description = description;
		this.category = category;
	}



	public Product(String name,  Brands brand, String photo, double price, String description,
			Long quantity, Categories category, Set<ProductParameters> productParameters, Coupon discount) {
		super();
		this.name = name;
		this.discount = discount;
		this.brand = brand;
		this.photo = photo;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
		this.category = category;
		this.productParameters = productParameters;
	}

	

	public Product(Long id,Long quantity, String name, Coupon discount, Brands brand, double price,
			String description, Categories category, Set<ProductParameters> productParameters) {
		this.id = id;
		this.quantity=quantity; 
		this.name = name;
		this.discount = discount;
		this.brand = brand;
		this.price = price;
		this.description = description;
		this.category = category;
		this.productParameters = productParameters;
	}
	
	public Product(String name, double price, String description) {
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public Product(Long id, Long quantity, String name, Brands brand, double price, String description,
			Categories category, Set<ProductParameters> productParameters, Coupon discount) {
		this.id = id;
		this.quantity=quantity;
		this.name = name;
		this.discount = discount;
		this.brand = brand;
		this.price = price;
		this.description = description;
		this.category = category;
		this.productParameters = productParameters;
	}
	public Product(String name, Long quantity, Brands brand, double price, String description,
			Categories category, Set<ProductParameters> productParameters, Coupon discount) {
		this.name = name;
		this.quantity=quantity;
		this.discount = discount;
		this.brand = brand;
		this.price = price;
		this.description = description;
		this.category = category;
		this.productParameters = productParameters;
	}
	
	public Product(Long quantity,String name, double price, String description) {
		this.quantity=quantity;
		this.name = name;
		this.price = price;
		this.description = description;
	}
	
	public Product(Long id, Long quantity, String name, double price) {
		this.id = id;
		this.quantity=quantity;
		this.name = name;
		this.price = price;
	}

	//Product getters/setters
	public Product(Set<ProductParameters> productParameters) {
		this.productParameters = productParameters;
	}
	
	public Set<ProductParameters> getProductParameters() {
		return productParameters;
	}

	public void setProductParameters(Set<ProductParameters> productParameters) {
		this.productParameters = productParameters;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Product(Categories category) {
		this.category = category;
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
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}
	


	public void setDescription(String description) {
		this.description = description;
	}
	
	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	public Brands getBrand() {
		return brand;
	}


	public void setBrand(Brands brand) {
		this.brand = brand;
	}
	
	public Coupon getDiscount() {
		return discount;
	}

	public void setDiscount(Coupon discount) {
		this.discount = discount;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	//Returns product values in String
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", photo=" + ", price=" + price + ", description="
				+ description + ", category=" + category.toString() + ", parameters=" +  "]";
	}

}