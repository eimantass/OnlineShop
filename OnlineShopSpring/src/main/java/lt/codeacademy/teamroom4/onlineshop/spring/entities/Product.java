package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Categories;

@Entity

@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//@JoinColumn(name = "product_id")
	private Coupon discount;
	private Brands brand;

	private String photo;
	private double price;
	private String description;
	private Categories category;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//@JoinColumn(name = "product_id")
	@JsonManagedReference
	private Set<ProductParameters> productParameters = new HashSet<>();
	//private ArrayList<String[]> parameters = new ArrayList<>();
	//List<String> parameters = new ArrayList<String>();
	
	

	

	public Product(Long id, String name, Brands brand, String photo, double price, String description, Categories category) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.photo = photo;
		this.price = price;
		this.description = description;
		this.category = category;
	}

	
	public Product(String name, Coupon discount, Brands brand, String photo, double price, String description,
			Categories category, Set<ProductParameters> productParameters) {
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


	public Product(Long id, String name, Coupon discount, Brands brand, String photo, double price, String description,
			Categories category, Set<ProductParameters> productParameters, ArrayList<String[]> parameters) {
		super();
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


	public Product(Long id, String name, Brands brand, String photo, double price, String description, Categories category,
			ArrayList<String[]> parameters) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.photo = photo;
		this.price = price;
		this.description = description;
		this.category = category;
	}


	public Product(String name, Brands brand, String photo, double price, String description, Categories category,
			ArrayList<String[]> parameters) {
		super();
		this.name = name;
		this.brand = brand;
		this.photo = photo;
		this.price = price;
		this.description = description;
		this.category = category;
	}


	public Product(String name,Brands brand,String photo, double price, String description, Categories categories) {
		this.name = name;
		this.brand = brand;
		this.photo = photo;
		this.price = price;
		this.description = description;
		this.category = categories;
		

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


	public Set<ProductParameters> getProductParameters() {
		return productParameters;
	}


	public void setProductParameters(Set<ProductParameters> productParameters) {
		this.productParameters = productParameters;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", photo=" + photo + ", price=" + price + ", description="
				+ description + ", category=" + category + ", parameters=" +  "]";
	}

}
