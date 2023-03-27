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
	String pavadinimas;
	String photo;
	double kaina;
	String aprasymas;
	Categories kategorija;
	
	public Product() {}

	public Product(String pavadinimas,String photo, double kaina, String aprasymas, Categories kategorija) {
		this.pavadinimas = pavadinimas;
		this.photo = photo;
		this.kaina = kaina;
		this.aprasymas = aprasymas;
		this.kategorija = kategorija;
	}

	public Product(Long id, String pavadinimas,String photo, double kaina, String aprasymas, Categories kategorija) {
		this.id = id;
		this.pavadinimas = pavadinimas;
		this.photo = photo;
		this.kaina = kaina;
		this.aprasymas = aprasymas;
		this.kategorija = kategorija;

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
