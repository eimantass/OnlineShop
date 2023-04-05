package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Categories;

@Entity

@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "discount")

	private Coupon discount;
	@Enumerated(EnumType.STRING)
	@Column
	private Brands brand;
	@Column
	private String photo;
	@Column
	private double price;
	@Column
	private String description;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "category", referencedColumnName = "id")
	@Enumerated(EnumType.STRING)
	private Category category;
	
	//@JsonManagedReference
	//@Transient
	//@Column
	//@ElementCollection()
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	 @JoinColumn(name = "product_id", referencedColumnName = "id")
	Set<ProductParameters> productParameters = new HashSet<>();
	
	//List<String> parameters = new ArrayList<String>();

	public Product(String name,Brands brand,String photo, double price, String description, Category categories) {
		this.name = name;
		this.brand = brand;
		this.photo = photo;
		this.price = price;
		this.description = description;
		this.category = categories;
		

	}

	public Product(Long id, String name, Coupon discount, Brands brand, String photo, double price, String description,
			Category category, Set<ProductParameters> productParameters) {
		this.id = id;
		this.name = name;
		this.discount = discount;
		this.brand = brand;
		this.photo = photo;
		this.price = price;
		this.description = description;
		this.category = category;
		this.productParameters = productParameters;
	}

	public Product(String name, Coupon discount, Brands brand, String photo, double price, String description,
			Category category, Set<ProductParameters> productParameters) {
		super();
		this.name = name;
		this.discount = discount;
		this.brand = brand;
		this.photo = photo;
		this.price = price;
		this.description = description;
		this.category = category;
		this.productParameters = productParameters;
	}

	public Product(String name, Brands brand, String photo, double price, String description,
			Category category, Set<ProductParameters> productParameters) {
		super();
		this.name = name;
		this.brand = brand;
		this.photo = photo;
		this.price = price;
		this.description = description;
		this.category = category;
		this.productParameters = productParameters;
	}

	public Product(Set<ProductParameters> productParameters) {
		this.productParameters = productParameters;
	}
	
	public Set<ProductParameters> getProductParameters() {
		return productParameters;
	}

	public void setProductParameters(Set<ProductParameters> productParameters) {
		this.productParameters = productParameters;
	}

	public Product() {
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
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
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
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


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", photo=" + photo + ", price=" + price + ", description="
				+ description + ", category=" + category + ", parameters=" +  "]";
	}

}