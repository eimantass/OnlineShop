package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lt.codeacademy.teamroom4.onlineshop.spring.utils.CPUParameters;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.Categories;

@Entity

@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String name;
	String photo;
	double price;
	String description;
	Categories category;
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//List<String> parameters;

	
/*
	public Product(Long id, String name, String photo, double price, String description, Categories category,
			List<String> parameters) {
		super();
		this.id = id;
		this.name = name;
		this.photo = photo;
		this.price = price;
		this.description = description;
		this.category = category;
		this.parameters = parameters;
	}
*/
	public Product(String name,String photo, double price, String description, Categories categories,List<String> parameters) {
		this.name = name;
		this.photo = photo;
		this.price = price;
		this.description = description;
		this.category = categories;

	}
	public Product(String name,String photo, double price, String description, Categories categories) {
		this.name = name;
		this.photo = photo;
		this.price = price;
		this.description = description;
		this.category = categories;
		

	}

	public Product(Long id, String name,String photo, double price, String description, Categories category) {
		this.id = id;
		this.name = name;
		this.photo = photo;
		this.price = price;
		this.description = description;
		this.category = category;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getPavadinimas() {
		return pavadinimas;
	}

	public void setPavadinimas(String pavadinimas) {
		this.pavadinimas = pavadinimas;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	
	public double getKaina() {
		return kaina;
	}

	public void setKaina(double kaina) {
		this.kaina = kaina;
	}

	public String getAprasymas() {
		return aprasymas;
	}

	public void setAprasymas(String aprasymas) {
		this.aprasymas = aprasymas;
	}


	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description
				+ "]";
	}

}
