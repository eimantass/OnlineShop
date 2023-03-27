package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lt.codeacademy.teamroom4.onlineshop.spring.utils.Categories;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String name;
	double price;
	String description;
	Categories categories;
	
	public Product() {}

	public Product(String name, double price, String description, Categories categories) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.categories = categories;
	}

	public Product(Long id, String name, double price, String description, Categories categories) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.categories = categories;
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

	public void setPrice(double kaina) {
		this.price = kaina;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Categories getCategory() {
		return categories;
	}

	public void setCategory(Categories category) {
		this.categories = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", pavadinimas=" + name + ", kaina=" + price + ", aprasymas=" + description
				+ "]";
	}

}
