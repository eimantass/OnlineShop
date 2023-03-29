package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.Categories;
//This is the Product entity

@Entity

@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String brand;
	private String photo;
	private double price;
	private String description;
	private Categories category;
	private ArrayList<String[]> parameters = new ArrayList<>();
	//List<String> parameters = new ArrayList<String>();
	
	

	

	public Product(Long id, String name, String brand, String photo, double price, String description, Categories category) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.photo = photo;
		this.price = price;
		this.description = description;
		this.category = category;
	}

	
	public Product(Long id, String name, String brand, String photo, double price, String description, Categories category,
			ArrayList<String[]> parameters) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.photo = photo;
		this.price = price;
		this.description = description;
		this.category = category;
		this.parameters = parameters;
	}


	public Product(String name, String brand, String photo, double price, String description, Categories category,
			ArrayList<String[]> parameters) {
		super();
		this.name = name;
		this.brand = brand;
		this.photo = photo;
		this.price = price;
		this.description = description;
		this.category = category;
		this.parameters = parameters;
	}


	public Product(String name,String brand,String photo, double price, String description, Categories categories) {
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


	

	public ArrayList<String[]> getParameters() {
		return parameters;
	}


	public void setParameters(ArrayList<String[]> parameters) {
		this.parameters = parameters;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", photo=" + photo + ", price=" + price + ", description="
				+ description + ", category=" + category + ", parameters=" +  "]";
	}

}
